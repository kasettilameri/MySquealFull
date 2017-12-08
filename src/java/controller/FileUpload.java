/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kasettilameri
 */
@WebServlet(name = "FileUpload", urlPatterns = {"/upload/fileupload"})
@MultipartConfig(location = "/var/www/html/trunkly")
public class FileUpload extends HttpServlet {
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
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            request.getPart("fileup").write(request.getPart("fileup").getSubmittedFileName());
            //out.println("<!doctype html><title>upload</title><meta charset=\"utf-8\"><h1>upload</h1>");
            out.print("{\"src\" : \"//10.114.32.28/trunkly/" + request.getPart("fileup").getSubmittedFileName() +"\"}");
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
