/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.controller;

import Empleate.domain.Category;
import Empleate.domain.Job;
import Empleate.logica.CategoryModel;
import Empleate.logica.JobModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
@WebServlet(name = "consultasEmpleate", urlPatterns = {"consultasEmpleateJobsByCategory","/iniciar","/consultasEmpleateJobsByLocation","consultasEmpleateAllJobsByCategory","/consultasEmpleateAllJobsByLocation","/desplegar"})
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
    
    public List<Category> resumen = new ArrayList<Category>();
    List<Category> hijosFijos = new ArrayList<Category>();
    List<Category> roots=new ArrayList<Category>();
    List<Category> cat = new ArrayList<>();
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
                this.doSearchGeneralJobsByCategory(request,response);
                break;
            case "/consultasEmpleateAllJobsByLocation":
                this.doSearchGeneralJobsByLocate(request,response);
                break;
            case "/desplegar":
                this.doDesplegar(request,response);
                break;
            case "/iniciar":
                this.iniciar(request,response);
                break;
        }
    }

    private void doSearchPublicJobsByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{ 
            HttpSession s =  request.getSession( true);
            List<Category> cat = 
            //String p = request.getParameter("percentage");
            cat = CategoryModel.instance().giveChilds(1);//1 por programacion perrito
            s.setAttribute("cat", cat);
            request.getRequestDispatcher("busquedaForm.jsp").
                    forward( request, response);
        }catch(Exception e){
            String error = e.getMessage();
            request.setAttribute("error",error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            
        }
    }
private void iniciar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{ 
            roots = CategoryModel.instance().giveRootParents();
            cat = roots;
            HttpSession s =  request.getSession( true);
            String op = request.getParameter("limpiar");
            if(Objects.equals(op, new String("1"))){//limpiar busqueda
                resumen.clear();
            }
            request.setAttribute("cat", cat);
            request.getRequestDispatcher("categoryTree.jsp").
                    forward( request, response);
            
        }catch(Exception e){
            String error = e.getMessage();
            request.setAttribute("error",error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }
    private void doDesplegar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{ 
            HttpSession s =  request.getSession( true);
            cat = new ArrayList<Category>();
            String aux = request.getParameter("papa");
            cat = CategoryModel.instance().giveChilds(Integer.parseInt(aux));
            Category cth = CategoryModel.instance().findCategoryById(Integer.parseInt(aux));
            if(CategoryModel.instance().giveChilds( Integer.parseInt(aux) ).size() == 0 ){
                resumen.add(cth);// solo add hojas
            }
            request.setAttribute("cat", cat);
            s.setAttribute("resumen", resumen);
            request.getRequestDispatcher("categoryTree.jsp").
                    forward( request, response);
        }catch(Exception e){
            String error = e.getMessage();
            request.setAttribute("error",error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            resumen = new ArrayList();
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
