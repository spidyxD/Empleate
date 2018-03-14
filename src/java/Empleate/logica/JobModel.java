/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;
import Empleate.dao.categoryDAO;
import Empleate.dao.jobDAO;
/**
 *
 * @author Addiel
 */
public class JobModel {
    private jobDAO jDAO;
     private static JobModel uniqueInstance;
    public static JobModel instance(){
        if (uniqueInstance == null){
            uniqueInstance = new JobModel();
        }
        return uniqueInstance;
    }
    private JobModel(){
        jDAO = new jobDAO();
    }
    
    
}
