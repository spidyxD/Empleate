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
@WebServlet(name = "Register", urlPatterns = {"/Register", "/RegistroCompany", "/RegistroOffer","/uploadPDF"})
@MultipartConfig
public class Register extends HttpServlet {
    public boolean isDigitPositive(String number){
         if(Integer.valueOf(number)>0)
             return true;
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
            case "Register":
                this.goToRegister(request, response);
                break;
            case "/RegistroCompany":
                this.doRegisterCompany(request, response);
                break;
            case "/RegistroOffer":
                this.doRegisterOfferer(request, response);
                break;
            case "/uploadPDF":
                this.doUploadPdf(request,response);
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
        try {
            HttpSession s = request.getSession(true);
            BufferedReader readerCompany = new BufferedReader(new InputStreamReader(request.getPart("company").getInputStream()));
            BufferedReader readerLog = new BufferedReader(new InputStreamReader(request.getPart("login").getInputStream()));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            
            Company c = gson.fromJson(readerCompany, Company.class);           
            System.out.println(c.getNameCompany());
           
             CompanyModel.instance().addCompany(c);
           
             
            Login l = gson.fromJson(readerLog, Login.class);
            System.out.println(l.getUsername());
            
            l.setIdLogin(0);
            l.setType_log("company");
            l.setEnable(0);
             if (LoginModel.instance().findLoginByUserName(l.getUsername()) != null) {      
                out.write(gson.toJson("nombre de usurario ya existente"));
                response.setStatus(400); // error with content
            }
            
            LoginModel.instance().addLogin(l);
            l = LoginModel.instance().findLoginByData(l.getUsername(), l.getPassword());
            
            c.setLogin(LoginModel.instance().findLoginByData(l.getUsername(), l.getPassword()).getIdLogin());
            CompanyModel.instance().addCompany(c);
            if(CompanyModel.instance().findByLogin(l.getIdLogin())){
                response.setContentType("application/json; charset=UTF-8");
                out.write(gson.toJson(c));
                response.setStatus(200); //add successfull
            }else{
                 LoginModel.instance().deleteLogin(l);
                 response.setStatus(401); //add successfull
            }
            
          
           
        } catch (Exception e) {
            String error = e.getMessage();
            request.setAttribute("error", error);
             response.setStatus(401); //add successfull
        }
    }

    private void doRegisterOfferer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            HttpSession s = request.getSession(true);
            boolean trouble = false;        
            Reader offererReader = new BufferedReader(new InputStreamReader(request.getPart("offerer").getInputStream()));
            Gson gson = new Gson();
            PrintWriter out = response.getWriter();            
            Reader loginReader = new BufferedReader(new InputStreamReader(request.getPart("login").getInputStream()));
            
            Login login = gson.fromJson(loginReader, Login.class);
            System.out.println(login.getUsername());                       
            
            Offerer offerer = gson.fromJson(offererReader, Offerer.class);
            System.out.println(offerer.getNameOfferer());
            if(OffererModel.instance().findByLogin(login.getIdLogin())){
                response.setContentType("application/json; charset=UTF-8");
                out.write(gson.toJson(offerer));
                response.setStatus(200); //add successfull
            }else{
                 LoginModel.instance().deleteLogin(login);
                 response.setStatus(401); //add successfull
            } 
                       
            login.setIdLogin(0);
            login.setEnable(1);       
            login.setType_log("offerer");
            if (LoginModel.instance().findLoginByUserName(login.getUsername()) != null) {      
                out.write(gson.toJson("nombre de usurario ya existente"));
                response.setStatus(400); // error with content
            }
            LoginModel.instance().addLogin(login);
            offerer.setLogin(LoginModel.instance().findLoginByData(login.getUsername(), login.getPassword()).getIdLogin());           
            OffererModel.instance().addOfferer(offerer);

            
            
            Part filePart = request.getPart("pdf"); // Obtiene el archivo
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            String path=getServletContext().getRealPath("/")+"docs/";
            File uploads = new File(path); //Carpeta donde se guardan los archivos
            uploads.mkdirs(); //Crea los directorios necesarios
            File file = File.createTempFile("cod"+login.getIdLogin()+"-", "-"+fileName, uploads); //Evita que hayan dos archivos con el mismo nombre

            try (InputStream input = filePart.getInputStream()){
                Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } 
           response.setContentType("application/json; charset=UTF-8");
           out.write(gson.toJson(offerer));  
           response.setStatus(200); // ok with content

        } catch (Exception e) {
            String error = e.getMessage();
            request.setAttribute("error", error);
            response.setStatus(401); // error with content
        }
    }

    private void doUploadPdf(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException, ServletException {
       
    }
}
