/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;
import Empleate.dao.categoryDAO;
/**
 *
 * @author Addiel
 */
public class CategoryModel {
   private categoryDAO catD;
   private static CategoryModel uniqueInstance;
    public static CategoryModel instance(){
        if (uniqueInstance == null){
            uniqueInstance = new CategoryModel();
        }
        return uniqueInstance;
    }
    private CategoryModel(){
        catD = new categoryDAO();
    }

   
   
}
