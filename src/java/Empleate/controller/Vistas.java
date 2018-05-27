/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.controller;

import Empleate.domain.Category;
import Empleate.domain.Company;
import Empleate.domain.Coordenada;
import Empleate.domain.Job;
import Empleate.domain.Login;
import Empleate.domain.Manager;
import Empleate.domain.Offerer;
import Empleate.domain.Opcion;
import Empleate.logica.CategoryModel;
import Empleate.logica.CompanyModel;
import Empleate.logica.JobModel;
import Empleate.logica.ManagerModel;
import Empleate.logica.OffererModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrés Gutiérrez
 */
@WebServlet(name = "Vistas", urlPatterns = {"/listarOferentes", "/visPubOff", "/visPubCom", "/vistMan", "/localizar"})
@MultipartConfig
public class Vistas extends HttpServlet {

    int id = 1;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            switch (request.getServletPath()) {
                case "/listarOferentes":
                    this.doListarOferentes(request, response);
                    break;
                case "/visPubOff":
                    this.doVistaPublicaOfferer(request, response);
                    break;
                case "/visPubCom":
                    this.doVistaPublicaCompany(request, response);
                    break;
                case "/visMan":
                    this.doVistaManager(request, response);
                    break;
                case "/localizar":
                    this.doLocalizarMapa(request, response);
                    break;
                case "/ListarEmpr":
                    this.doListarEmpresa(request, response);
                    break;
            }
        }
    }

    public void doListarOferentes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Offerer> oferentesLs = OffererModel.instance().findAll();
            List<Company> companyLs = CompanyModel.instance().findAllCompanies();
            request.setAttribute("oferentesLS", oferentesLs);
            request.setAttribute("companyLs", companyLs);
            request.getRequestDispatcher("listarOfferers.jsp").forward(request, response);
        } catch (Exception e) {
            String error = e.getMessage();
            request.setAttribute("error", error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    public void doVistaPublicaOfferer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession s = request.getSession(true);
            String idOf = request.getParameter("idOf");
            int id = Integer.parseInt(idOf);
            Offerer of = OffererModel.instance().findById(id);
            ArrayList<Category> cats = (ArrayList<Category>) CategoryModel.instance().findAllCategoriesOfferer(id);
            Login l = (Login) s.getAttribute("login");

            request.setAttribute("idOf", of);
            request.setAttribute("cats", cats);
            request.getRequestDispatcher("vistaOfferer.jsp").forward(request, response);
        } catch (Exception e) {
            String error = e.getMessage();
            request.setAttribute("error", error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    public void doVistaPublicaCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idCom = request.getParameter("idCom");
            id = Integer.parseInt(idCom);
            Company comp = CompanyModel.instance().findCompanyByID(id);
            ArrayList<Job> jobs = (ArrayList<Job>) JobModel.instance().findAllJobsByCompany(id);

            request.setAttribute("comp", comp);
            request.setAttribute("jobs", jobs);
            request.getRequestDispatcher("vistaCompany.jsp").forward(request, response);
        } catch (Exception e) {
            String error = e.getMessage();
            request.setAttribute("error", error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    public void doVistaManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idMan = request.getParameter("idMan");
            id = Integer.parseInt(idMan);
            Manager man = ManagerModel.instance().findById(id);
            request.setAttribute("man", man);
            request.getRequestDispatcher("vistaAdmin.jsp").forward(request, response);
        } catch (Exception e) {
            String error = e.getMessage();
            request.setAttribute("error", error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    public void doLocalizarMapa(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            BufferedReader reader = request.getReader();
            Gson gson = new Gson();
            Coordenada coo = new Coordenada();/// = gson.fromJson(reader, Coordenada.class);
            PrintWriter out = response.getWriter();
            Company company = CompanyModel.instance().findCompanyByID(id);//company.getIdCompany()
            response.setContentType("application/json; charset=UTF-8");
            coo.setX(company.getLocation_X());
            coo.setY(company.getLocation_Y());
            out.write(gson.toJson(coo, Coordenada.class));
            response.setStatus(200); // ok with content
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.setStatus(401); //Bad request
        }
    }

    public void doListarEmpresa(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            Reader opcionReader = new BufferedReader(new InputStreamReader(request.getPart("opcion").getInputStream()));
            Gson gson2 = new Gson();
            Opcion op = gson2.fromJson(opcionReader, Opcion.class);
            System.out.println("vamos funcioneee" + op.getRespuesta());
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
            PrintWriter out = response.getWriter();
            ArrayList<Company> ls = new ArrayList<>();
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Company>>() {
            }.getType();
            if (true) { //listar empresas activas
                ls = (ArrayList<Company>) CompanyModel.instance().findAllCompanies();
            } else {
                ls = (ArrayList<Company>) CompanyModel.instance().findAllCompanies();
            }
            response.setContentType("application/json; charset=UTF-8");
            out.write(gson.toJson(ls, listType));
            response.setStatus(200); // ok with content
        } catch (Exception e) {
            response.setStatus(401); //Bad request
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
