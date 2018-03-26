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
        
        JobModel jm = new JobModel();
        CategoryModel cm = new CategoryModel();
        jobCategoryModel jcm = new jobCategoryModel();
        Jobcategory jc = new Jobcategory((Job)jm.findJobByID(1),(Category)cm.findCategoryById(2),75);
        Jobcategory jc2 = new Jobcategory((Job)jm.findJobByID(2),(Category)cm.findCategoryById(1));
        jcm.addJobCategoy(jc);
        jcm.deleteJobCategory(jc2);
    }
}
