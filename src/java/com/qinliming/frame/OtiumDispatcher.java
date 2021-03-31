/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qinliming.frame;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author qinliming
 */
public class OtiumDispatcher extends HttpServlet {

    private String configClassName;
    private Config config;

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }
    
    public String getConfigClassName() {
        return configClassName;
    }

    public void setConfigClassName(String configClassName) {
        this.configClassName = configClassName;
    }

    /**
     *
     * @param config
     */
    @Override
    public void init(ServletConfig config) {
        if(null == config){
            Logger.getLogger(OtiumDispatcher.class.getName()).log(Level.WARNING,"use null augument in init(ServletConfig config)");
            System.exit(0);
        }
        this.setConfigClassName(config.getInitParameter("config"));
        this.setConfig(getCongfigInstance());
    }

    private Config getCongfigInstance() {
        String config = this.getConfigClassName();
        if (null != config) {
            Config newConfig = (Config) this.getInstance(config);
            return newConfig;
        } else {
            return null;
            // need an exception
        }

    }

    private Object getInstance(String name) {
        if(null == name){
            Logger.getLogger(OtiumDispatcher.class.getName()).log(Level.WARNING,"use an eror augument in getInstance(String name) ");
            System.exit(0);
        }
        try {
            Class obj = Class.forName(name);
            return obj.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(OtiumDispatcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String method = request.getMethod();
            System.out.println(config.getControllers());
            System.out.println(config.getDebug());
            System.out.println(config.getView());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
