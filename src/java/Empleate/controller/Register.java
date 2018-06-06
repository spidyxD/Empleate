/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.controller;

import Empleate.domain.Company;
import Empleate.domain.Login;
import Empleate.domain.Offerer;
import Empleate.logica.CompanyModel;
import Empleate.logica.LoginModel;
import Empleate.logica.OffererModel;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Addiel
 */
@WebServlet(name = "Register", urlPatterns = {"/Register", "/RegistroCompany", "/RegistroOffer"})
@MultipartConfig
public class Register extends HttpServlet {

    String regex = "\\d+";

    public boolean isDigitPositive(String number) {
        if (Integer.valueOf(number) > 0) {
            return true;
        }
        return false;
    }

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
            case "/RegistroCompany":
                this.doRegisterCompany(request, response);
                break;
            case "/RegistroOffer":
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

    private void doRegisterCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession s = request.getSession(true);
            BufferedReader readerCompany = new BufferedReader(new InputStreamReader(request.getPart("company").getInputStream()));
            BufferedReader readerLog = new BufferedReader(new InputStreamReader(request.getPart("login").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();

            Company c = gson.fromJson(readerCompany, Company.class);
            System.out.println(c.getNameCompany());

            Login l = gson.fromJson(readerLog, Login.class);
            System.out.println(l.getUsername());

            l.setIdLogin(0);
            l.setType_log("company");
            l.setEnable(0);
            if (LoginModel.instance().findLoginByUserName(l.getUsername()) != null || !c.getPhone().matches(regex)) {
                throw new Exception("USUARIO YA EXISTE o EL TELEFONO DEBE SER SOLO NUMEROS");
            } else {

                LoginModel.instance().addLogin(l);
                l = LoginModel.instance().findLoginByData(l.getUsername(), l.getPassword());

                c.setLogin(LoginModel.instance().findLoginByData(l.getUsername(), l.getPassword()).getIdLogin());
                c.setActive(0);
                CompanyModel.instance().addCompany(c);
                if (CompanyModel.instance().findByLogin(LoginModel.instance().findLoginByData(l.getUsername(), l.getPassword()).getIdLogin())) {
                    response.setContentType("application/json; charset=UTF-8");
                    out.write(gson.toJson(c));
                    response.setStatus(200); //add successfull
                } else {
                    LoginModel.instance().deleteLogin(l);
                    response.setStatus(401); //add successfull
                }
            }
        } catch (Exception e) {
            String error = e.getMessage();
            request.setAttribute("error", error);
            response.setStatus(401,error); //add successfull
        }
    }

    private void doRegisterOfferer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            HttpSession s = request.getSession(true);
            Reader offererReader = new BufferedReader(new InputStreamReader(request.getPart("offerer").getInputStream()));
            Gson gson = new Gson();
            PrintWriter out = response.getWriter();
            Reader loginReader = new BufferedReader(new InputStreamReader(request.getPart("login").getInputStream()));
            
            Offerer offerer = gson.fromJson(offererReader, Offerer.class);
            System.out.println(offerer.getNameOfferer());
            
            Login login = gson.fromJson(loginReader, Login.class);
            System.out.println(login.getUsername());

            login.setIdLogin(0);
            login.setEnable(1);
            login.setType_log("offerer");
            if (LoginModel.instance().findLoginByUserName(login.getUsername()) != null
                    || !offerer.getPhone().matches(regex)) {
                throw new Exception("USUARIO YA EXISTE o EL TELEFONO DEBE SER SOLO NUMEROS");
            } else {
                LoginModel.instance().addLogin(login);
                login.setIdLogin(LoginModel.instance().findLoginByData(login.getUsername(), login.getPassword()).getIdLogin());

                offerer.setLogin(LoginModel.instance().findLoginByData(login.getUsername(), login.getPassword()).getIdLogin());
                offerer.setActive(0);
                OffererModel.instance().addOfferer(offerer);

                if (OffererModel.instance().findByLogin(LoginModel.instance().findLoginByData(login.getUsername(), login.getPassword()).getIdLogin())) {
                    out.write(gson.toJson(offerer));
                    Part filePart = request.getPart("pdf"); // Obtiene el archivo
                    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
                    String path = getServletContext().getRealPath("/") + "../../";
                    File uploads = new File(path); //Carpeta donde se guardan los archivos
                    uploads.mkdirs(); //Crea los directorios necesarios
                    File file = File.createTempFile("cod" + login.getIdLogin() + "-", "-" + fileName, uploads); //Evita que hayan dos archivos con el mismo nombre

                    try (InputStream input = filePart.getInputStream()) {
                        Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                    response.setContentType("application/json; charset=UTF-8");
                    response.setStatus(200); // ok with content

                } else {
                    LoginModel.instance().deleteLogin(login);
                    response.setStatus(401); //add error
                }

            }

        } catch (Exception e) {
            String error = e.getMessage();
            request.setAttribute("error", error);
            response.setStatus(401,error); // error with content
        }
    }

}
