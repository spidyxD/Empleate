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
import com.google.gson.Gson;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
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
@WebServlet(name = "login", urlPatterns = {"/doLogin", "/Logout"})
@MultipartConfig
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
        case "/doLogin":
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
            BufferedReader readerLog = request.getReader();
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
             Login aux = gson.fromJson(readerLog, Login.class);
             l = aux;
            String u = l.getUsername();
            System.out.print(u);
        if(verifyLogin(l,request,response)){
             l = LoginModel.instance().findLoginByData(l.getUsername(), l.getPassword());
             switch(l.getType_log()){
                 case "company":
                     Company c = new Company();
                     c =CompanyModel.instance().findCompanyByIdLogin(String.valueOf(l.getIdLogin()));
                     s.setAttribute("company", c);
                     s.setAttribute("login", l);
                     out.write(gson.toJson(l));
                     response.setStatus(200); // successfull
                 break;
                 case "offerer":
                     Offerer o = new Offerer();
                     o = OffererModel.instance().findByIdLogin(l.getIdLogin());
                     s.setAttribute("offerer", o);
                     s.setAttribute("login", l);
                      out.write(gson.toJson(l));
                     response.setStatus(200); // successfull
                 break;
                 case "manager":
                     Manager m= new Manager();
                     m = ManagerModel.instance().findByIdLogin(l.getIdLogin());
                     s.setAttribute("manager", m);
                     s.setAttribute("login", l);
                      out.write(gson.toJson(l));
                     response.setStatus(200); // successfull
                 break;    
                 default: 
                     response.setStatus(400); // faild
                     break;
         }
       
       }
       }catch(Exception e){
            String error = "Error de credenciales del usuario: "+ request.getParameter("username") + " idRegister: " +l.getIdLogin() + " type: " + l.getType_log();
            request.setAttribute("error",error);
            response.setStatus(400); // faild
            
        }	
    }
    protected void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getSession().invalidate();
            request.getRequestDispatcher("Home").forward( request, response);          
    }    
   public boolean verifyLogin(Login l,HttpServletRequest request, 
        HttpServletResponse response){
        l = LoginModel.instance().findLoginByData(l.getUsername(),l.getPassword());
        return l.getIdLogin() != -1;
   }

}
