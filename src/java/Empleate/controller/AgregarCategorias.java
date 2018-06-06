/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.controller;

import Empleate.domain.Category;
import Empleate.domain.Company;
import Empleate.domain.Job;
import Empleate.domain.Jobcategory;
import Empleate.domain.Manager;
import Empleate.domain.Offerer;
import Empleate.logica.CategoryModel;
import Empleate.logica.JobModel;
import Empleate.logica.jobCategoryModel;
import Empleate.logica.offerCategoryModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrés Gutiérrez
 */
@WebServlet(name = "AgregarCategorias", urlPatterns = {"/agregarAdmin", "/redireccionar", "/agregarHabilidades", "/agregarPuestos"})
public class AgregarCategorias extends HttpServlet {

    ArrayList<Category> categories = CategoryModel.instance().findAllCategories();
    ArrayList<Category> sinRoots = new ArrayList();

    String error = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sinRoots = new ArrayList();
        categories.stream().filter((u) -> (u.getIsRoot() != 1 || u.getIsDad() != 1)).forEachOrdered((u) -> {
            sinRoots.add(u);
        });
        switch (request.getServletPath()) {
            case "/agregarAdmin":
                this.doAgregarCatAdmin(request, response);
                break;
            case "/redireccionar":
                this.doRedireccionar(request, response);
                break;
            case "/agregarHabilidades":
                this.doAgregarHabilidades(request, response);
                break;
            case "/redireccionarHabilidades":
                this.doRedireccionarHabilidades(request, response);
                break;
            case "/agregarPuestos":
                this.doAgregarPuestos(request, response);
                break;
            case "/redireccionarPuestos":
                this.doRedireccionarPuestos(request, response);
                break;
        }

    }

    private void doAgregarCatAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession s = request.getSession(true);
            request.setAttribute("categories", categories);

            request.setAttribute("error", error);
            request.getRequestDispatcher("AgregarCategorias.jsp").forward(request, response);
        } catch (Exception e) {
            String error = e.getMessage();
            response.setStatus(401); //add successfull
        }
    }

    private void doAgregarHabilidades(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession s = request.getSession(true);
            request.setAttribute("categories", sinRoots);

            request.setAttribute("error", error);
            request.getRequestDispatcher("AgregarHabilidades.jsp").forward(request, response);
        } catch (Exception e) {
            String error = e.getMessage();
            response.setStatus(401); //add successfull
        }
    }

    private void doAgregarPuestos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession s = request.getSession(true);
            request.setAttribute("categories", sinRoots);

            request.setAttribute("error", error);
            request.getRequestDispatcher("AgregarPuestos.jsp").forward(request, response);
        } catch (Exception e) {
            String error = e.getMessage();
            response.setStatus(401); //add successfull
        }
    }

    private void doRedireccionar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession s = request.getSession(true);
            Category ct = new Category();
            String nomb = request.getParameter("nombre");
            String scod = request.getParameter("codCat");
            int cod = 0;
            if (scod.equals("ND")) {
                cod = Integer.parseInt(scod);
            }
            //verificar que esa categoria no sea repetida x el nombre
            for (Category c : categories) {
                if (c.getNameCategory().toLowerCase().equals(nomb.toLowerCase())) {
                    throw new Exception("Nombre repetido");
                }
            }

            //insertar            
            CategoryModel.instance().insertarCategory(nomb, cod);//

            request.setAttribute("categories", categories);
            Manager m = (Manager) s.getAttribute("manager");
            request.getRequestDispatcher("visMan?idMan=" + m.getLogin()).forward(request, response);
        } catch (Exception e) {
            String error1 = e.getMessage();
            request.setAttribute("error", error1);
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("AgregarCategorias.jsp").forward(request, response);
        }
    }

    private void doRedireccionarHabilidades(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession s = request.getSession(true);
            Category ct = new Category();
            Offerer o = (Offerer) s.getAttribute("offerer");

            String scod = request.getParameter("codCat");
            String per = request.getParameter("porcHab");
            int cod = Integer.parseInt(scod);
            int pern = Integer.parseInt(per);
            //insertar            
            offerCategoryModel.instance().insertarOfferCategory(o.getIdOfferer(), cod, pern);// todos paramentros enteros

            request.setAttribute("categories", sinRoots);
            request.getRequestDispatcher("visPubOff?idOf=" + o.getIdOfferer()).forward(request, response);
        } catch (Exception e) {
            String error1 = e.getMessage();
            request.setAttribute("error", error1);
            request.setAttribute("categories", sinRoots);
            request.getRequestDispatcher("AgregarCategorias.jsp").forward(request, response);
        }
    }

    //
    private void doRedireccionarPuestos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession s = request.getSession(true);
            Category ct = new Category();
            Company c = (Company) s.getAttribute("company");
            Job j = new Job();
            List<String> recive = new ArrayList();
            Jobcategory jc = new Jobcategory();
            String scod = request.getParameter("codCat");
            recive.add(scod);
            String per = request.getParameter("porcHab");
            recive.add(per);
            String xnombre = request.getParameter("nomb");
            recive.add(xnombre);
            String xdecrip = request.getParameter("descr");
            recive.add(xdecrip);
            String xsalario = request.getParameter("sal");
            recive.add(xsalario);
            String tipo = request.getParameter("tip");
            recive.add(tipo);
            
            //String xtipo = request.getParameter("tip");
            int cod = Integer.parseInt(scod);
            int pern = Integer.parseInt(per);
            int xsal = Integer.parseInt(xsalario);

            j.setCompany(c);
            j.setDescriptionJob(xdecrip);
            j.setNameJob(xnombre);
            j.setSalary(xsal);
            j.setStatusJob(1);
            j.setTypeJob(tipo);

            JobModel.instance().addJob(j);
            int idJ = 0;
            ArrayList<Job> js = (ArrayList<Job>) JobModel.instance().findAllJobsByCompany(c.getIdCompany());
            for (int i = 0; i < js.size(); i++) {
                if (js.get(i).getNameJob().equals(xnombre)) {
                    idJ = js.get(i).getIdJob();
                }
            }
            jobCategoryModel.instance().insertarJobCategory(idJ, cod, pern);

            request.setAttribute("categories", sinRoots);
            request.getRequestDispatcher("visPubCom?idCom=" + c.getIdCompany()).forward(request, response);
            sinRoots = new ArrayList();
        } catch (Exception e) {
            String error1 = e.getMessage();
            request.setAttribute("error", error1);
            request.setAttribute("categories", sinRoots);
            request.getRequestDispatcher("AgregarCategorias.jsp").forward(request, response);
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
