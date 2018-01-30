package com.miternos.odata;

import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by miternos on 7/28/17.
 */
public class Servlet extends CXFNonSpringJaxrsServlet {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Servlet.class);

    public void init(ServletConfig servletConfig) throws ServletException{
        try {
            super.init(servletConfig);
        } catch (ServletException e){
            logger.error("Exception init: ",e);
            throw e;
        }
    }

    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        try {
            super.handleRequest(request,response);
        } catch (ServletException e){
            logger.error("Exception handleRequest: ",e);
            throw e;
        }
    }
}
