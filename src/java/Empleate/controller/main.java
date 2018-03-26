/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Empleate.controller;
import Empleate.domain.Login;
import Empleate.logica.JobModel;
import Empleate.logica.LoginModel;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "main", urlPatterns = {"/login", "/logout","/top5","publicJobsByCategory","/publicJobsByLocation","generalJobsByCategory","/generalJobsByLocation","/registCompany", "/registOffer"})
public class main extends HttpServlet {
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                switch(request.getServletPath()){
            case "/login":
                this.doLogin(request,response);
                break;
            case "/logout":
                this.doLogout(request,response);
                break;
            case "/top5":
                this.giveTop5(request,response);
                break; 
            case "/publicJobsByCategory":
                this.doSearchPublicJobsByCategory(request,response);
                break;
            case "/publicJobsByLocation":
                this.doSearchPublicJobsByLocate(request,response);
                break;
            case "/generalJobsByCategory":
                //if(request.getSession().)
                this.doSearchGeneralJobsByCategory(request,response);
                break;
            case "/generalJobsByLocation":
                this.doSearchGeneralJobsByLocate(request,response);
                break;
            case "/registCompany":
                this.doRegisterCompany(request,response);
                break;
            case "/registOffer":
                this.doResgiterOfferent(request,response);
                break;
        }
     
            }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{ 
        HttpSession s =  request.getSession( true);
        Login l = new Login();
        l.setUsername(request.getParameter("username"));
        l.setPassword(request.getParameter("password"));
        l = LoginModel.instance().findLoginByData(l.getUsername(),l.getPassword());
        s.setAttribute("usuario", l);
        //LA VALIDACION  DE TIPO DE LOGIN SE DEBERA IMPLEMENTAR EN EL JSP UNA FUNCION JAVA
        request.getRequestDispatcher("Home.jsp").forward( request, response);
        
        }catch(Exception e){
            String error = e.getMessage();
            request.setAttribute("error",error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            
        }
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getSession().invalidate();
            request.getRequestDispatcher("Home.jsp").forward( request, response);          
    }

    private void giveTop5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try{ 
        HttpSession s =  request.getSession( true);
        ArrayList top = new ArrayList();
        top = (ArrayList) JobModel.instance().top5();
        s.setAttribute("top5", top);
        request.getRequestDispatcher("main.jsp").
                forward( request, response);
        }catch(Exception e){
            String error = e.getMessage();
            request.setAttribute("error",error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            
        }
    }

    private void doSearchPublicJobsByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{ 
        HttpSession s =  request.getSession( true);
        ArrayList jobs = new ArrayList();
        String p = request.getParameter("percentage");
        jobs = JobModel.instance().findJobByCategory(request.getParameter("category"),p);
        s.setAttribute("jobsByCategory", jobs);
         request.getRequestDispatcher("main.jsp").
                forward( request, response);
        }catch(Exception e){
            String error = e.getMessage();
            request.setAttribute("error",error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            
        }
    }

    private void doSearchPublicJobsByLocate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{ 
        HttpSession s =  request.getSession( true);
        }catch(Exception e){
            String error = e.getMessage();
            request.setAttribute("error",error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            
        }
    }
    private void doRegisterCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("registCompany.jsp").forward(request, response);
    }

    private void doResgiterOfferent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("registOfferer.jsp").forward(request, response);
    }
  
    private void doSearchGeneralJobsByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try{ 
        HttpSession s =  request.getSession( true);
        ArrayList jobs = new ArrayList();
        String p = request.getParameter("percentage");
        jobs = JobModel.instance().findGeneralJobByCategory(request.getParameter("category"),p);
        s.setAttribute("jobsByCategory", jobs);
         request.getRequestDispatcher("main.jsp").
                forward( request, response);
        }catch(Exception e){
            String error = e.getMessage();
            request.setAttribute("error",error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            
        }
    }

    private void doSearchGeneralJobsByLocate(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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


