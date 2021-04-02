/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qinliming.frame;

import com.qinliming.frame.ann.Spring;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author qinliming
 */
public abstract class Config {

    private static ApplicationContext ac;

    public ApplicationContext getAc() {
        return ac;
    }

    public void setAc(ApplicationContext ac) {
        this.ac = ac;
    }
    private static String view = "jsp";
    private static boolean debug = true;
    private static boolean spring = false;
    private static String springconf = null;
    private static final ConcurrentHashMap<String, Controller> actions = new ConcurrentHashMap<>();

    public static void setView(String view) {
        Config.view = view;
    }

    public static void setDebug(boolean debug) {
        Config.debug = debug;
    }

    public static void initSpring() {
        System.out.println(Config.spring);
        if (Config.spring) {
            if (null != Config.springconf) {
               Config.ac = new ClassPathXmlApplicationContext(Config.springconf);
            }
        } else {
            Logger.getLogger(Config.class.getName()).log(Level.WARNING, "you use spring but do not give a spring config file");
            System.exit(0);
        }
    }

    public static void addController(String router, Class controller) {
        if (Config.Spring(controller) && Config.spring) {
            Logger.getLogger(Config.class.getName()).log(Level.INFO,"use spring to load class "+controller.getName());
            Controller ctrl = (Controller) ac.getBean(controller);
            Config.actions.put(router, ctrl);
        } else {
            try {
                Config.actions.put(router, (Controller) controller.newInstance());
            } catch (InstantiationException ex) {
                Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void toUserSpring(String config) {
        Config.springconf = config;
        Config.spring = true;
    }

    public static boolean Spring(Class cls) {
        if (null != cls.getAnnotation(Spring.class)) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public Map getControllers() {
        return Config.actions;
    }

    public boolean getDebug() {
        return Config.debug;
    }

    public String getView() {
        return Config.view;
    }

    abstract public void view(View view);

    abstract public void router(Controllers controller);

    abstract public void debug(Debug debug);

}
