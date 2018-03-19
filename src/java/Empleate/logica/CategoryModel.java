/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;
import Empleate.dao.categoryDAO;
import Empleate.domain.Category;
import java.math.BigInteger;
import java.util.ArrayList;
/**
 *
 * @author Addiel
 */
public class CategoryModel {
   private categoryDAO catDAO;
   private static CategoryModel uniqueInstance;
    public static CategoryModel instance(){
        if (uniqueInstance == null){
            uniqueInstance = new CategoryModel();
        }
        return uniqueInstance;
    }
    private CategoryModel(){
        catDAO = new categoryDAO();
    }

   public void addOfferer(Category cat){
        catDAO.add(cat);
    }
    
    public void updateOfferer(Category cat){
        catDAO.merge(cat);
    }
    
    public void deleteOfferer(Category cat){
        catDAO.delete(cat);
    }
    
    public Category findById(BigInteger id){
        return catDAO.findById(id);
    }
    
     public ArrayList<Category> findAll() {
         ArrayList<Category> listCategory = new ArrayList<Category>(catDAO.findAll());
         return listCategory;
     }
   
    
}//fin clase
