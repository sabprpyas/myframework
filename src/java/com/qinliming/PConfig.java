/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qinliming;

import com.tester.Tester;
import com.qinliming.core.Config;
import com.qinliming.core.Controllers;
import com.qinliming.core.Debug;
import com.qinliming.core.View;

/**
 *
 * @author qinliming
 */
public class PConfig extends Config{

    @Override
    public void view(View view) {
        view.setView("jsp");
    }

    @Override
    public void router(Controllers controller) {
        controller.useSpring("config.xml");
        controller.add("/hello", Tester.class);
        
    }

    @Override
    public void debug(Debug debug) {
     debug.setDebug(true);
    }
    
}
