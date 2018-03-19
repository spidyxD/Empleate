/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.test;

import Empleate.dao.offererDAO;
import Empleate.domain.Company;
import Empleate.domain.Login;
import Empleate.domain.Offercategory;
import Empleate.domain.Offerer;
import Empleate.logica.CompanyModel;
import Empleate.logica.JobModel;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Addiel
 */
public class TESTMYOWN {
    public static void main(String[] arg) throws Exception{
    offererDAO offD = new offererDAO();
    Set<Offercategory> offercategories = new HashSet<>(0);
    Set<Login> logins = new HashSet<>(0);
    Offerer off = new Offerer(666,"KATE","ALFARO","costarricense","KA@gmail.com","506 561956","MONTE VERDE");   
    offD.add(off);
    System.out.println(offD.findAll().size());
    Company c = new Company(7,"INTACO","intaco.ac.cr","506 22142536","we are a tecnoly company",36,32,"moravia, san jose, CR");
    CompanyModel jm = new CompanyModel();
    jm.addCompany(c);
    }
}
