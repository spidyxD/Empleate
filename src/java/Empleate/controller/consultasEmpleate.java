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
    public List<Category> resumen = new ArrayList<>();
    List<Category> hijosFijos = new ArrayList<>();
    List<Category> roots = new ArrayList<>();//Para imprimir los roots
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
            case "/colap"://al inicio de la busqueda
                this.doColap(request, response);
                break;
        }
    }

    private void doColap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Reader personaReader = new BufferedReader(new InputStreamReader(request.getPart("persona").getInputStream()));
            Gson gson = new Gson();
            //Persona persona = gson.fromJson(personaReader, Persona.class);
            PrintWriter out = response.getWriter();
            ArrayList<Category> ls  = CategoryModel.instance().findAllCategories();
            ArrayList<categorySimple>catSim = new ArrayList<>();
            for (Category c : ls) {
                if(c.getCategory() != null){
                catSim.add(new categorySimple(c.getIdCategory(),
                        c.getNameCategory(),c.getCategory().getIdCategory()));
                }else{
                    catSim.add(new categorySimple(c.getIdCategory(),
                        c.getNameCategory(),0));//cero para indicar que no tiene papa
                }
            }
            response.setContentType("application/json; charset=UTF-8");
            out.write(gson.toJson(catSim));
            response.setStatus(200); // ok with content
        } catch (Exception e) {
            response.setStatus(401); //Bad request
        }
    }

    private void iniciar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            roots = CategoryModel.instance().giveRootParents();
            cat = CategoryModel.instance().findAllCategories();
            HttpSession s = request.getSession(true);
            /*String op = request.getParameter("limpiar");
            if (Objects.equals(op, new String("1"))) {//limpiar busqueda
                resumen.clear();
                resumenCompleto.clear();
            }*/
            ArrayList<categorySimple> catSim = new ArrayList<>();
            for (Category c : cat) {
                if(c.getCategory() != null){
                catSim.add(new categorySimple(c.getIdCategory(),
                        c.getNameCategory(),c.getCategory().getIdCategory()));
                }else{
                    catSim.add(new categorySimple(c.getIdCategory(),
                        c.getNameCategory(),0));//cero para indicar que no tiene papa
                }
            }
            String myJson = new Gson().toJson(catSim);
    
            s.setAttribute("resumen", resumen);
            s.setAttribute("resumenCompleto", resumenCompleto);
            request.setAttribute("cat", cat);
            request.setAttribute("root", roots);
            request.setAttribute("catSim", catSim);
            request.setAttribute("myJson",myJson);
            request.getRequestDispatcher("categoryTree.jsp").
                    forward(request, response);
        } catch (Exception e) {
            String error = e.getMessage();
            System.out.println(e.getMessage());
            request.setAttribute("error", error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    private void doDesplegar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession s = request.getSession(true);
            cat = new ArrayList<>();
            BufferedReader reader = request.getReader();
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Dad d = gson.fromJson(reader, Dad.class);
            String ex1 = d.getDady();
            // System.out.println(ex1);

            cat = CategoryModel.instance().giveChilds(Integer.parseInt(ex1));
            String cl = cat.get(1).getNameCategory();
            System.out.println(cl);
            Category cth = CategoryModel.instance().findCategoryById(Integer.parseInt(ex1));
            if (CategoryModel.instance().giveChilds(Integer.parseInt(ex1)).isEmpty()) {
                Porcentaje p = gson.fromJson(reader, Porcentaje.class);
                String ex2 = p.getPercent();
                //System.out.println(ex2);
                resumen.add(cth);// solo add hojas
                resumenCompleto.put(cth, ex2);
                response.setContentType("application/json; charset=UTF-8");
                out.write(gson.toJson(cat));
                response.setStatus(200);
            }
            response.setContentType("application/json; charset=UTF-8");
            out.write(gson.toJson(resumen));
            response.setStatus(200);
        } catch (Exception e) {
            String error = e.getMessage();
            resumen.clear();
            resumenCompleto.clear();
            response.setStatus(401);
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
