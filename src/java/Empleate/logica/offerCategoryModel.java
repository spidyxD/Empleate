/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;
import Empleate.dao.offerCategoryDAO;
/**
 *
 * @author Addiel
 */
public class offerCategoryModel {
   private offerCategoryDAO ocD;
   private static offerCategoryModel uniqueInstance;
    public static offerCategoryModel instance(){
        if (uniqueInstance == null){
            uniqueInstance = new offerCategoryModel();
        }
        return uniqueInstance;
    }
    private offerCategoryModel(){
        ocD = new offerCategoryDAO();
    }
    
  
}
