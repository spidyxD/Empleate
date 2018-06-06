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
import java.util.List;
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
   public CategoryModel(){
        catDAO = new categoryDAO();
    }

   public void addCategory(Category cat){
        catDAO.add(cat);
    }
    
    public void updateCategory(Category cat){
        catDAO.merge(cat);
    }
    
    public void deleteCategory(Category cat){
        catDAO.delete(cat);
    }
    
    public Category findCategoryById(int id){
        return catDAO.findById(id);
    }
    
    public ArrayList<Category> findAllCategories() {
         ArrayList<Category> listCategory = new ArrayList<Category>(catDAO.findAll());
         return listCategory;
     }
    
   /* METODOS NECESARIOS PARA EL Arbol MYSQL  */ 
   public List<Category> giveRootParents(){
        return catDAO.giveParentRoots();
   }
   public List<Category> giveChilds(int parent){
        return catDAO.giveChildCategory(parent);
   }
    public List<Category> findAllCategoriesOfferer(int idOfferer){
       return catDAO.findAllCategoriesOfferer(idOfferer);
   }
    
   public void insertarCategory(String nom, int padre){
       catDAO.insertarCategory(nom, padre);
   }
        
}//fin clase
