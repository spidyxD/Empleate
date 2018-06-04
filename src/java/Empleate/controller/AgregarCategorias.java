/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.controller;

import Empleate.domain.Category;
import Empleate.domain.Company;
import Empleate.domain.Login;
import Empleate.domain.Manager;
import Empleate.logica.CategoryModel;
import Empleate.logica.CompanyModel;
import Empleate.logica.LoginModel;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrés Gutiérrez
 */
@WebServlet(name = "AgregarCategorias", urlPatterns = {"/agregarAdmin","/redireccionar"})
public class AgregarCategorias extends HttpServlet {
    
     ArrayList<Category> categories = CategoryModel.instance().findAllCategories();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/agregarAdmin":
                this.doAgregarCatAdmin(request, response);
                break;
            case "/redireccionar":
                this.doRedireccionar(request, response);
                break;
        }

    }
    
    
    
    private void doAgregarCatAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession s = request.getSession(true);
            request.setAttribute("categories", categories);           
            
            request.getRequestDispatcher("AgregarCategorias.jsp").forward(request, response);
        } catch (Exception e) {
            String error = e.getMessage();
            response.setStatus(401); //add successfull
        }
    }
    
       private void doRedireccionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession s = request.getSession(true);
            
            Category ct = new Category();
            String nomb = request.getParameter("nombre");
            String scod = request.getParameter("codCat");
            int cod=0;
            
            if(scod !=""){
                cod = Integer.parseInt(scod);
            }
            
            //insertar
            
            CategoryModel.instance().insertarCategory(nomb, cod);
            
            request.setAttribute("categories", categories);           
            Manager m = (Manager) s.getAttribute("manager"); 
            request.getRequestDispatcher("visMan?idMan="+m.getLogin()).forward(request, response);
        } catch (Exception e) {
            String error = e.getMessage();
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
