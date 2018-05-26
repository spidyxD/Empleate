/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.controller;

import Empleate.domain.Category;
import Empleate.domain.Dad;
import Empleate.domain.Porcentaje;
import Empleate.domain.categorySimple;
import Empleate.logica.CategoryModel;
import Empleate.logica.JobModel;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
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
@WebServlet(name = "consultasEmpleate", urlPatterns = {"consultasEmpleateJobsByCategory", "/iniciar",
    "consultasEmpleateAllJobsByCategory", "/consultarOffrers", "/desplegar", "/colap"})
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
    List<Category> roots = new ArrayList<Category>();//Para imprimir los roots
    List<Category> cat = new ArrayList<>();//Mostrar las categorias en un momento dado
    String pr = "";
    HashMap<Category, String> resumenCompleto = new HashMap();//nuevo resumen
    double x, y = 0;
    List jobs = new ArrayList();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getServletPath()) {
            //Para Jobs
            case "/consultasEmpleateJobsByCategory"://Publico
                this.doSearchPublicJobsByCategory(request, response);
                break;
            //Para Categorias
            case "/consultasEmpleateAllJobsByCategory"://Privado,public (Sesion iniciada)
                this.doSearchGeneralJobsByCategory(request, response);
                break;
            case "/consultarOffrers":
                this.doSearchOfferers(request, response);
                break;
            case "/desplegar"://sirve para desplegar las categorias deseadas(como si fuera el publico)
                this.doDesplegar(request, response);
                break;
            case "/iniciar"://al inicio de la busqueda
                this.iniciar(request, response);
                break;
        }
    }

    private void iniciar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            roots = CategoryModel.instance().giveRootParents();
            cat = roots;
            HttpSession s = request.getSession(true);
            String op = request.getParameter("limpiar");
            if (Objects.equals(op, new String("1"))) {//limpiar busqueda
                resumen.clear();
                resumenCompleto.clear();
            }
            s.setAttribute("resumen", resumen);
            s.setAttribute("resumenCompleto", resumenCompleto);
            request.setAttribute("cat", cat);
            request.getRequestDispatcher("categoryTree.jsp").
                    forward(request, response);
        } catch (Exception e) {
            String error = e.getMessage(); 
            request.setAttribute("error", error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    private void doDesplegar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession s = request.getSession(true);
            cat = new ArrayList<Category>();
            String aux = request.getParameter("papa");
            pr = request.getParameter("porcentaje");
            cat = CategoryModel.instance().giveChilds(Integer.parseInt(aux));
            Category cth = CategoryModel.instance().findCategoryById(Integer.parseInt(aux));
            if (CategoryModel.instance().giveChilds(Integer.parseInt(aux)).isEmpty()) {
                resumen.add(cth);// solo add hojas
                resumenCompleto.put(cth, "90");//cambiar el string por el parametro del usuario
            }
            request.setAttribute("cat", cat);
            s.setAttribute("resumen", resumen);
            s.setAttribute("resumenCompleto", resumenCompleto);
            request.setAttribute("por", pr);
            request.getRequestDispatcher("categoryTree.jsp").
                    forward(request, response);
        } catch (Exception e) {
            String error = e.getMessage();
            request.setAttribute("error", error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            resumen.clear();
            resumenCompleto.clear();  
}
    }

    private void doSearchPublicJobsByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession s = request.getSession(true);
            jobs.clear();
            x = Double.parseDouble(request.getParameter("localeX"));
            y = Double.parseDouble(request.getParameter("localeY"));
            //System.out.println(x+y);

            jobs = JobModel.instance().getAllJobsByCategoryPublic((HashMap<Category, String>) s.getAttribute("resumenCompleto"), x, y);
            if (!jobs.isEmpty()) {
                s.setAttribute("jobsByCategory", jobs);
            }
            request.getRequestDispatcher("ResultadosBusquedas.jsp").
                    forward(request, response);
            jobs.clear();
        } catch (Exception e) {
            String error = e.getMessage();
            request.setAttribute("error", error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);

        }
    }

    /**
     * @return lista de jobs que concuerdan con las cateogrias
     */
    private void doSearchGeneralJobsByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession s = request.getSession(true);
            jobs.clear();
            x = Double.parseDouble(request.getParameter("localeX"));
            y = Double.parseDouble(request.getParameter("localeY"));
            jobs = JobModel.instance().getAllJobsByCategory((HashMap<Category, String>) s.getAttribute("resumenCompleto"), x, y);
            if (!jobs.isEmpty()) {
                request.setAttribute("jobsByCategory", jobs);
            }
            request.getRequestDispatcher("ResultadosBusquedas.jsp").
                    forward(request, response);
            jobs.clear();
        } catch (Exception e) {
            String error = e.getMessage();
            request.setAttribute("error", error);
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

    private void doSearchOfferers(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
