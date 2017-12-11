/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Posts;
import model.Tags;

/**
 *
 * @author kasettilameri
 */
@WebServlet(name = "FileUpload", urlPatterns = {"/trunkly/upload/fileupload"})
@MultipartConfig(location = "/var/www/html/trunkly/media")
public class FileUpload extends HttpServlet {
    @EJB
    private DBcontrol dbc;
    private EntityManager em;
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
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        //response.setContentType("application/json");
        //response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            request.getPart("fileup").write(request.getPart("fileup").getSubmittedFileName());
            //response.sendRedirect("/trunkly/upload.html");
            //out.print("{\"src\" : \"//10.114.32.28/trunkly/media/" + request.getPart("fileup").getSubmittedFileName() +"\"}");
            
            Posts img = new Posts();
            Tags tag = new Tags();
            img.setFilename("/var/www/html/trunkly/media/" + request.getPart("fileup").getSubmittedFileName());
            img.setTitle(request.getParameter("title"));
            img.setPDate(Calendar.getInstance().getTime());
            tag.setTagName(request.getParameter("tags"));
            //request.getPart("fileup").write(request.getPart("fileup").getSubmittedFileName());
            //out.print("{\"src\" : \"//10.114.32.28/trunkly/" + request.getPart("fileup").getSubmittedFileName() +"\"}");
            dbc.upload(img);
            response.setHeader("Refresh", "0; URL=" + request.getContextPath());
            
        }
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
