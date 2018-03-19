/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;
import Empleate.dao.jobCategoryDAO;
import Empleate.domain.Jobcategory;
import java.math.BigInteger;
import java.util.List;
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
    
    public void addJobCategoy(Jobcategory j) throws Exception{
        try{
        jcD.add(j);
        }catch(Exception e){}
    }
    public void updateJobCategory(Jobcategory j) throws Exception{
        try{
        jcD.merge(j);
        }catch(Exception e){}
    }
    public void deleteJobCategory(Jobcategory j) throws Exception{
        try{
        jcD.delete(j);
        }catch(Exception e){}
    }
    public Jobcategory findJobCategoryByID(int id) throws Exception{
        try{
        return jcD.findById(BigInteger.valueOf(id));
        }catch(Exception e){}
        return null;
    }
    
    public List<Jobcategory> findAllJobCategory() throws Exception{
        try{
        return jcD.findAll();
        }catch(Exception e){}
        return null;
    }
    
}
