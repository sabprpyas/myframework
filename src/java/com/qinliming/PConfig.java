/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qinliming;

import com.qinliming.frame.Config;
import com.qinliming.frame.Controllers;
import com.qinliming.frame.Debug;
import com.qinliming.frame.View;

/**
 *
 * @author qinliming
 */
public class PConfig extends Config{

    @Override
    public void view(View view) {
        view.setView("php");
    }

    @Override
    public void router(Controllers controller) {
        
    }

    @Override
    public void debug(Debug debug) {
      
    }
    
}
