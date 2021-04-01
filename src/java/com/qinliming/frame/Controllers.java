/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qinliming.frame;

/**
 *
 * @author qinliming
 */
public class Controllers {
    public void add(String router,Class controller){
        Config.addController(router, controller);
    }
    public void useSpring(String config){
        Config.toUserSpring(config);
    }
}
