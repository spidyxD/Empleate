/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.test;

import Empleate.domain.Category;
import Empleate.domain.Job;
import Empleate.domain.Login;
import Empleate.logica.CategoryModel;
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
        ArrayList<Category> ls = (ArrayList<Category>) CategoryModel.instance().giveChilds(1);
        for(Category c : ls){
            System.out.println(c.getNameCategory());
        }
    }
    
}
