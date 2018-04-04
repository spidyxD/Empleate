/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.controller;

import Empleate.domain.Company;
import Empleate.domain.Login;
import Empleate.domain.Manager;
import Empleate.domain.Offerer;
import Empleate.logica.CompanyModel;
import Empleate.logica.LoginModel;
import Empleate.logica.ManagerModel;
import Empleate.logica.OffererModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Addiel
 */
@WebServlet(name = "login", urlPatterns = {"/Login", "/Logout"})
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
         throws ServletException, IOException {
    switch(request.getServletPath()){
        case "/Login":
            this.doLogin(request,response);
            break;
        case "/Logout":
            this.doLogout(request,response);
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

    protected void doLogin(HttpServletRequest request, 
        HttpServletResponse response) throws ServletException, IOException {
        Login l = new Login();
        try{ 
            HttpSession s =  request.getSession(true);
            
            l.setUsername(request.getParameter("username"));
            l.setPassword(request.getParameter("password"));
        
        if(verifyLogin(l,request,response)){
             l = LoginModel.instance().findLoginByData(request.getParameter("username"), request.getParameter("password"));
             switch(l.getType_log()){
                 case "company":
                     Company c = new Company();
                     c =CompanyModel.instance().findCompanyByIdLogin(String.valueOf(l.getIdLogin()));
                     s.setAttribute("company", c);
                     s.setAttribute("login", l);
                     request.getRequestDispatcher("Home").forward( request, response);
                 break;
                 case "offerer":
                     Offerer o = new Offerer();
                     o = OffererModel.instance().findByIdLogin(l.getIdLogin());
                     s.setAttribute("offerer", o);
                     s.setAttribute("login", l);
                     request.getRequestDispatcher("Home").forward( request, response);
                 break;
                 case "manager":
                     Manager m= new Manager();
                     m = ManagerModel.instance().findByIdLogin(l.getIdLogin());
                     s.setAttribute("manager", m);
                     s.setAttribute("login", l);
                     request.getRequestDispatcher("Home").forward( request, response);
                 break;    
                 default:
                     request.getRequestDispatcher("Error.jsp").forward(request, response);
                     break;
         }
       
       }
       }catch(Exception e){
            String error = "Error de credenciales del usuario: "+ request.getParameter("username") + " idRegister: " +l.getIdLogin() + " type: " + l.getType_log();
            request.setAttribute("error",error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            
        }	
    }
    protected void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getSession().invalidate();
            request.getRequestDispatcher("Home").forward( request, response);          
    }    
   public boolean verifyLogin(Login l,HttpServletRequest request, 
        HttpServletResponse response){
        l = LoginModel.instance().findLoginByData(request.getParameter("username"),request.getParameter("password"));
        return l.getIdLogin() != -1;
   }

}
