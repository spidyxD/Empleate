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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 *
 * @author Addiel
 */
public class TESTMYOWN {
    public static void main(String[] arg) throws Exception{
    List<Category> c= CategoryModel.instance().giveChilds(1);
        
       for(Category ct:c){
           System.out.println(ct.getNameCategory());
       } 
        
    }
}
