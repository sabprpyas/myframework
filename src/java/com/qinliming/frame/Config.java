/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qinliming.frame;

import com.qinliming.frame.ann.Spring;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author qinliming
 */
public abstract class Config {
    
    public ApplicationContext ac;
    
    public Config(){
        
    }
    private static String view = "jsp";
    private static boolean debug = true;
    private static boolean spring = false;
    private static String sprngconf = null;
    private static final ConcurrentHashMap<String, Controller> actions = new ConcurrentHashMap<>();
    public static void setView(String view){
        Config.view = view;
    }
    public static void setDebug(boolean debug){
        Config.debug = debug;
    } 
    public static void addController(String router,Class controller){
        if(Config.Spring(controller)){
            
        }
    }
    public static void toUserSpring(String config){
        Config.spring = true;
    }    
    public static boolean Spring(Class cls){
        if(null != cls.getAnnotation(Spring.class)){
            return true;
        }
        return false;
    }
    
    /**
     *
     * @return 
     */
    public Map getControllers(){
        return Config.actions;
    }
    public boolean getDebug(){
        return Config.debug;
    }
    public String getView(){
        return Config.view;
    }
    abstract public void view(View view);
    abstract public void router(Controllers controller);
    abstract public void debug(Debug debug);
    
}
