/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tester;

import com.qinliming.core.Controller;
import com.qinliming.core.ann.View;
import org.springframework.stereotype.Service;

/**
 *
 * @author qinliming
 */
@Service
public class Tester extends Controller{
    
    @View("hello.jsp")
    public void test(){
        
    }
}
