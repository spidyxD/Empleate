/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;
import Empleate.dao.jobCategoryDAO;
/**
 *
 * @author Addiel
 */
public class jobCategoryModel {
   private jobCategoryDAO jcD;
   private static jobCategoryModel uniqueInstance;
    public static jobCategoryModel instance(){
        if (uniqueInstance == null){
            uniqueInstance = new jobCategoryModel();
        }
        return uniqueInstance;
    }
    private jobCategoryModel(){
        jcD = new jobCategoryDAO();
    }
}
