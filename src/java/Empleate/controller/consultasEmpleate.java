/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.controller;

import Empleate.domain.Category;
import Empleate.domain.Job;
import Empleate.domain.Login;
import Empleate.domain.Ubicacion;
import Empleate.logica.CategoryModel;
import Empleate.logica.JobModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
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
@WebServlet(name = "consultasEmpleate", urlPatterns = {"/consultas","/iniciar"})
@MultipartConfig
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
    List<Job> jobs = new ArrayList();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        switch (request.getServletPath()) {
            //Para Jobs
            case "/consultas":
                System.out.print("AQUI ENTRE");
                this.doSearchJobsByCategory(request, response);
                break;
            case "/iniciar"://al inicio de la busqueda
                this.iniciar(request, response);
                break;
        }
    }

    private void iniciar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            cat = new ArrayList();
            //cat= CategoryModel.instance().findAllCategories();
            roots = CategoryModel.instance().giveRootParents();
            List<Category> aux = CategoryModel.instance().findAllCategories();
            for (int i = 0; i < aux.size(); i++) {
                if (aux.get(i).getIsRoot() == 1) {
                    cat.add(aux.get(i));
                    if (!CategoryModel.instance().giveChilds(aux.get(i).getIdCategory()).isEmpty()) {
                        for (int j = 0; j < CategoryModel.instance().giveChilds(aux.get(i).getIdCategory()).size(); j++) {
                            cat.add(CategoryModel.instance().giveChilds(aux.get(i).getIdCategory()).get(j));
                            if (!CategoryModel.instance().giveChilds(CategoryModel.instance().giveChilds(aux.get(i).getIdCategory()).get(j).getIdCategory()).isEmpty()) {
                                for (int g = 0; g < CategoryModel.instance().giveChilds(CategoryModel.instance().giveChilds(aux.get(i).getIdCategory()).get(j).getIdCategory()).size(); g++) {
                                    cat.add(CategoryModel.instance().giveChilds(CategoryModel.instance().giveChilds(aux.get(i).getIdCategory()).get(j).getIdCategory()).get(g));
                                }
                            }
                        }
                    }
                }
            }

            HttpSession s = request.getSession(true);
            String op = request.getParameter("limpiar");
            if (Objects.equals(op, new String("1"))) {//limpiar busqueda
                resumen.clear();
                resumenCompleto.clear();
            }
            s.setAttribute("resumen", resumen);
            s.setAttribute("resumenCompleto", resumenCompleto);
            request.setAttribute("cat", cat);
            request.setAttribute("root", roots);
            request.getRequestDispatcher("categoryTree.jsp").
                    forward(request, response);
        } catch (Exception e) {
            String error = e.getMessage();
            System.out.println(e.getMessage());
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

    private void doSearchJobsByCategory(HttpServletRequest request, HttpServletResponse response) {
         try {
            HttpSession s = request.getSession(true);
            BufferedReader readerCats = new BufferedReader(new InputStreamReader(request.getPart("categories").getInputStream()));
            BufferedReader readerLoc = new BufferedReader(new InputStreamReader(request.getPart("location").getInputStream()));
            BufferedReader readerPerc = new BufferedReader(new InputStreamReader(request.getPart("percents").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            Gson gson2 = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Job>>() {
            }.getType();
            List<Double> cats = gson.fromJson(readerCats, List.class);
            List<String> perc = gson.fromJson(readerPerc, List.class);
            Ubicacion lc = gson.fromJson(readerLoc, Ubicacion.class);
            System.out.println(cats.size());
            System.out.println(perc.size());
            double lx = lc.getLocaleHX();
            System.out.println(lx);
            Login l = (Login)s.getAttribute("login");
            if(l.getUsername().isEmpty()){
            jobs = JobModel.instance().findPublicJobByCategory(cats, perc, lc.getLocaleHX(), lc.getLocaleHY());
            for(int i=0;i<jobs.size();i++){
               Job aux= JobModel.instance().giveJobComplete(jobs.get(i).getIdJob());
                jobs.get(i).setCompany(aux.getCompany());
                System.out.println(aux.getCompany().getNameCompany()+"hola");
            }
            }else {
            jobs = JobModel.instance().findGeneralJobByCategory(cats, perc, lc.getLocaleHX(), lc.getLocaleHY());
            for(int i=0;i<jobs.size();i++){
               Job aux= JobModel.instance().giveJobComplete(jobs.get(i).getIdJob());
                jobs.get(i).setCompany(aux.getCompany());
            }
            }
            System.out.println(jobs.size());
            if(!jobs.isEmpty()){
             response.setContentType("application/json; charset=UTF-8");             
             out.write(gson2.toJson(jobs,listType));
             response.setStatus(200); //search successfull
            }
            else{
              String error = l.getUsername()+" No se han encontrado puestos ";  
              response.setStatus(400,error); //search failed 
            }
            jobs.clear();        
            
        } catch (Exception e) {
            String error = e.getMessage();
             response.setStatus(400,error); //search failed 
        }
    }

}
