/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.controller;

import Empleate.domain.Company;
import Empleate.domain.Job;
import Empleate.domain.Login;
import Empleate.domain.Offerer;
import Empleate.logica.CompanyModel;
import Empleate.logica.LoginModel;
import Empleate.logica.OffererModel;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
@WebServlet(name = "Register", urlPatterns = {"/Register", "/RegistCompany", "/RegistOffer"})
public class Register extends HttpServlet {

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
        switch (request.getServletPath()) {
            case "Register":
                this.goToRegister(request, response);
                break;
            case "/RegistCompany":
                this.doRegisterCompany(request, response);
                break;
            case "/RegistOffer":
                this.doRegisterOfferer(request, response);
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

    private void goToRegister(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doRegisterCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> param = new ArrayList<String>();
        try {
            HttpSession s = request.getSession(true);

            Company c = new Company();
            Login l = new Login();

            CompanyModel cm = new CompanyModel();
            LoginModel lm = new LoginModel();

            String name = request.getParameter("nombreEmpresa");
            param.add(name);
            String phone = request.getParameter("telefono");
            param.add(phone);
            String email = request.getParameter("website");
            param.add(email);
            String addres = request.getParameter("direccion");
            param.add(addres);
            String descript = request.getParameter("descripcion");
            param.add(descript);
            String user = request.getParameter("username");
            param.add(user);
            String key = request.getParameter("password");
             
            double locateX = Double.parseDouble(request.getParameter("localeX"));
            
            double locateY = Double.parseDouble(request.getParameter("localeY"));
            
            l.setIdLogin(0);
            l.setUsername(user);
            l.setPassword(key);
            l.setEnable(1);
            l.setType_log("company");
            if (lm.findLoginByUserName(user) != null) {
                throw new Exception("Nombre de usuario repetido");
            }
            lm.addLogin(l);

            Thread.sleep(1000);

            c.setNameCompany(name);
            c.setEmail(email);
            c.setDescription(descript);
            c.setPhone(phone);
            c.setAddress(addres);
            c.setLocation_X(locateX);
            c.setLocation_Y(locateY);
            c.setIdCompany(0);
            Set<Login> logins = new HashSet<Login>();
            logins.add(new Login());
            c.setLogins(logins);
            Set<Job> jobs = new HashSet<Job>();
            jobs.add(new Job());
            c.setJobs(jobs);
            c.setLogin(lm.findLoginByData(user, key).getIdLogin());
            l.setIdLogin(lm.findLoginByData(user, key).getIdLogin());

            cm.addCompany(c);

            request.setAttribute("login", l);
            request.setAttribute("company", c);
            response.setStatus(200); //si la long y la lat estableciada llega correctamente
            request.getRequestDispatcher("Home").forward(request, response);
        } catch (Exception e) {
            String error = e.getMessage();
            request.setAttribute("error", error);
            request.setAttribute("param", param);
            response.setStatus(400); //si hay un error en el envio de la ubicacion
            request.getRequestDispatcher("registCompany.jsp").forward(request, response);
        }
    }

    private void doRegisterOfferer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> param = new ArrayList<String>();
        try {
            HttpSession s = request.getSession(true);

            Offerer o = new Offerer();
            Login l = new Login();

            OffererModel om = new OffererModel();
            LoginModel lm = new LoginModel();

            String name = request.getParameter("nombre");
            param.add(name);
            String ape = request.getParameter("apellido");
            param.add(ape);
            String naciona = request.getParameter("nacionalidad");
            param.add(naciona);
            String phone = request.getParameter("telefono");
            param.add(phone);
            String address = request.getParameter("residencia");
            param.add(address);
            String email = request.getParameter("email");
            param.add(email);            
            String user = request.getParameter("username");
            param.add(user);
            String key = request.getParameter("password");           

            l.setIdLogin(0);
            l.setUsername(user);
            l.setPassword(key);
            l.setEnable(1);
            l.setType_log("offerer");
            if (lm.findLoginByUserName(user) != null) {
                throw new Exception("Nombre de usuario repetido");
            }
            lm.addLogin(l);

            Thread.sleep(1000);

            o.setNameOfferer(name);
            o.setEmail(email);
            o.setLastname(ape);
            o.setPhone(phone);
            o.setResidence(address);
            o.setIdOfferer(0);
            Set<Login> logins = new HashSet<Login>();
            logins.add(new Login());
            o.setLogin(lm.findLoginByData(user, key).getIdLogin());
            l.setIdLogin(lm.findLoginByData(user, key).getIdLogin());

            om.addOfferer(o);

            request.setAttribute("login", l);
            request.setAttribute("offerer", o);
            request.getRequestDispatcher("Home").forward(request, response);

        } catch (Exception e) {
            String error = e.getMessage();
            request.setAttribute("error", error);
            request.setAttribute("param", param);
            request.getRequestDispatcher("registOfferer.jsp").forward(request, response);
        }
    }
}
