/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.controller;

import Empleate.domain.Company;
import Empleate.domain.Login;
import Empleate.domain.Offerer;
import Empleate.logica.CompanyModel;
import Empleate.logica.LoginModel;
import Empleate.logica.OffererModel;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Addiel
 */

@WebServlet(name = "updateInf", urlPatterns = {"/UpdateInfOfferer","/UpdateInfCompany"})
@MultipartConfig
public class updateInf extends HttpServlet {

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
          switch (request.getServletPath()) {
            case "/UpdateInfOfferer":
                this.doUpdateOfferer(request, response);
                break;
            case "/UpdateInfCompany":
                this.doUpdateCompany(request, response);
                break;

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

    private void doUpdateOfferer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try {
            HttpSession s = request.getSession(true);
            BufferedReader readerOff = new BufferedReader(new InputStreamReader(request.getPart("offerer").getInputStream()));
            BufferedReader readerLog = new BufferedReader(new InputStreamReader(request.getPart("login").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Offerer o = gson.fromJson(readerOff, Offerer.class);
            
            System.out.println(o.getNameOfferer());
            Login l = gson.fromJson(readerLog, Login.class);
             System.out.println(l.getUsername());
            OffererModel.instance().updateOfferer(o);
            LoginModel.instance().updateLogin(l);
            response.setContentType("application/json; charset=UTF-8");
            out.write(gson.toJson(o));
            response.setStatus(200); //update successfull
            
         } 
             catch (Exception e) {
            String error = e.getMessage();
            request.setAttribute("error", error);  
            response.setStatus(401); //si hay un error en el update
        }
    }

    private void doUpdateCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession s = request.getSession(true);
            BufferedReader readerCmp = new BufferedReader(new InputStreamReader(request.getPart("company").getInputStream()));
            BufferedReader readerLog = new BufferedReader(new InputStreamReader(request.getPart("login").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Company c = gson.fromJson(readerCmp, Company.class);
            Login l = gson.fromJson(readerLog, Login.class);
            CompanyModel.instance().updateCompany(c);
            LoginModel.instance().updateLogin(l);
            response.setContentType("application/json; charset=UTF-8");
            out.write(gson.toJson(c));
            response.setStatus(200); //update successfull
            
        } 
        catch (Exception e) {
            String error = e.getMessage();
            request.setAttribute("error", error);
            ;
            response.setStatus(400); //si hay un error en el envio de la ubicacion
            request.getRequestDispatcher("registCompany.jsp").forward(request, response);
        }
        
    }

}
