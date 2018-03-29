/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.test;

import Empleate.domain.Category;
import Empleate.domain.Company;
import Empleate.domain.Job;
import Empleate.domain.Jobcategory;
import Empleate.domain.Login;
import Empleate.logica.JobModel;
import Empleate.logica.jobCategoryModel;
import Empleate.logica.CategoryModel;
import Empleate.logica.CompanyModel;
import Empleate.logica.LoginModel;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Addiel
 */
public class TESTMYOWN {
    public static void main(String[] arg) throws Exception{
        
        /*JobModel jm = new JobModel();
        CategoryModel cm = new CategoryModel();
        jobCategoryModel jcm = new jobCategoryModel();
        Jobcategory jc = new Jobcategory((Job)jm.findJobByID(1),(Category)cm.findCategoryById(2),75);
        Jobcategory jc2 = new Jobcategory((Job)jm.findJobByID(2),(Category)cm.findCategoryById(1));
        //jcm.addJobCategoy(jc);
        //jcm.deleteJobCategory(jc2);
        //String info = jm.top5().get(1).getNameJob();
        //System.out.println(info);*/
        Company c = new Company();
        Login l = new Login();
        
        CompanyModel cm = new CompanyModel();
        LoginModel lm = new LoginModel();
        
         l.setIdLogin(0);
        Set<Login> logins = new HashSet<Login>();
        logins.add(new Login());
        String user = "spidyxD";
        String key = "user002";
        
        l.setUsername(user);
        l.setPassword(key);
        l.setEnable(1);
        l.setType_log("company");
        lm.addLogin(l);
        
        String name = "amazon";
        String email = "amazon.com";
        String descript = "lol";
        String addres = "lagunilla";
        String phone = "506 52156";
        
       /* c.setNameCompany(name);
        c.setEmail(email);
        c.setDescription(descript);
        c.setPhone(phone);
        c.setAddress(addres);
        c.setLocation_X((float) 10.14);
        c.setLocation_Y((float) 156.425);
        c.setIdCompany(0);
        c.setLogin(lm.findLoginByData(user, key).getIdLogin());
        System.out.println(c.getLogin());
        c.setLogins(logins);
            Set<Job> jobs = new HashSet<Job>();
            jobs.add(new Job());
        c.setJobs(jobs);
       
        cm.addCompany(c);*/
       System.out.println(lm.findLoginByData(user, key).getUsername());
    }
}
