/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.controller;
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
@WebServlet(name = "Home", urlPatterns = {"/login", "/logout","/top5","publicJobsByCategory","/publicJobsByLocation"})
public class Home extends HttpServlet {
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
        }
     
            }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{ 
        HttpSession s =  request.getSession( true);
        }catch(Exception e){
            String error = e.getMessage();
            request.setAttribute("error",error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            
        }
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{ 
        HttpSession s =  request.getSession( true);
        }catch(Exception e){
            String error = e.getMessage();
            request.setAttribute("error",error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            
        }
    }

    private void giveTop5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try{ 
        HttpSession s =  request.getSession( true);
        }catch(Exception e){
            String error = e.getMessage();
            request.setAttribute("error",error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            
        }
    }

    private void doSearchPublicJobsByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{ 
        HttpSession s =  request.getSession( true);
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
