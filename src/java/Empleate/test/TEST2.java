/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.test;

import Empleate.domain.Category;
import Empleate.domain.Job;
import Empleate.logica.CategoryModel;
import Empleate.logica.JobModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés Gutiérrez
 */
public class TEST2 {
    public static void main(String[] arg) throws Exception{
        List<Category> ls =CategoryModel.instance().giveChilds(4);
        for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i).getNameCategory());
        }
               
    }
    
}
