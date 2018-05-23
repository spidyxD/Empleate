/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.test;

import Empleate.domain.Category;
import Empleate.domain.Company;
import Empleate.domain.Job;
import Empleate.domain.Login;
import Empleate.logica.CategoryModel;
import Empleate.logica.CompanyModel;
import Empleate.logica.JobModel;
import Empleate.logica.LoginModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés Gutiérrez
 */
public class TEST2 {
    public static void main(String[] arg) throws Exception{
       ArrayList<Category> roots = (ArrayList<Category>) CategoryModel.instance().giveRootParents();
       ArrayList<Category> cat = CategoryModel.instance().findAllCategories();
       System.out.println(roots.size() + "-" + cat.size());
       System.out.println(cat.get(6).getCategory().getNameCategory());
    }
    
}
