/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.controller;

import Empleate.logica.JobModel;
import java.io.IOException;
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
 * @author Addiel
 */
@WebServlet(name = "consultasEmpleate", urlPatterns = {"consultasEmpleateJobsByCategory","/consultasEmpleateJobsByLocation","consultasEmpleateAllJobsByCategory","/consultasEmpleateAllJobsByLocation"})
public class consultasEmpleate extends HttpServlet {

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
         switch(request.getServletPath()){
            case "/consultasEmpleateJobsByCategory":
                this.doSearchPublicJobsByCategory(request,response);
                break;
            case "/consultasEmpleateJobsByLocation":
                this.doSearchPublicJobsByLocate(request,response);
                break;
            case "/consultasEmpleateAllJobsByCategory":
                //if(request.getSession().)
                this.doSearchGeneralJobsByCategory(request,response);
                break;
            case "/consultasEmpleateAllJobsByLocation":
                this.doSearchGeneralJobsByLocate(request,response);
                break;
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
  
    private void doSearchGeneralJobsByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try{ 
        HttpSession s =  request.getSession( true);
        List jobs = new ArrayList();
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
