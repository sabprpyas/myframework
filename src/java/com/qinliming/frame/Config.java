/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qinliming.frame;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author qinliming
 */
public abstract class Config {

    private static String view = "jsp";
    private static boolean debug = true;
    private static final ConcurrentHashMap<String, Controller> actions = new ConcurrentHashMap<>();
    public static void setView(String view){
        Config.view = view;
    }
    public static void setDebug(boolean debug){
        Config.debug = debug;
    } 
    public static void addController(String router,Controller controller){
        Config.actions.put(router, controller);
    }
    /**
     *
     * @return 
     */
    public Map getControllers(){
        return Config.actions;
    }
    
    abstract public void view(View view);
    abstract public void router(Debug debug);
    abstract public void debug(Controllers controllers);
}
