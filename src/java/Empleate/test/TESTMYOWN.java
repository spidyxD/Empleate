/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.test;

import Empleate.domain.Category;
import Empleate.domain.Job;
import Empleate.domain.Jobcategory;
import Empleate.logica.JobModel;
import Empleate.logica.jobCategoryModel;
import Empleate.logica.CategoryModel;
/**
 *
 * @author Addiel
 */
public class TESTMYOWN {
    public static void main(String[] arg) throws Exception{
    /*offererDAO offD = new offererDAO();
    Set<Offercategory> offercategories = new HashSet<>(0);
    Set<Login> logins = new HashSet<>(0);
    Offerer off = new Offerer(666,"KATE","ALFARO","costarricense","KA@gmail.com","506 561956","MONTE VERDE");   
    offD.add(off);
    System.out.println(offD.findAll().size());
    Company c = new Company(7,"INTACO","intaco.ac.cr","506 22142536","we are a tecnoly company",36,32,"moravia, san jose, CR");*/
    JobModel jm = new JobModel();
    //(Category)cm.findCategoryById(BigInteger.valueOf(506)),(Job)jm.findJobByID(124),75)
    CategoryModel cm = new CategoryModel();
    jobCategoryModel jcm = new jobCategoryModel();
    Jobcategory jc = new Jobcategory((Job)jm.findJobByID(1),(Category)cm.findCategoryById(2),75);
    Jobcategory jc2 = new Jobcategory((Job)jm.findJobByID(2),(Category)cm.findCategoryById(1));
    jcm.addJobCategoy(jc);
    jcm.deleteJobCategory(jc2);
    }
}
