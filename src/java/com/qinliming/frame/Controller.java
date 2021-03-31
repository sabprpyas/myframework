/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qinliming.frame;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.qinliming.frame.ann.View;
/**
 *
 * @author qinliming
 */
public class Controller {
    private HttpServletRequest request;
    private HttpServletResponse response;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
    public String get(String key){
        return request.getParameter(key);
    }
    public String getSession(){
        return null;
    }
    @View("fuck.html")
    public void setSession(String key,Object value){
    
    }
    
    
}
