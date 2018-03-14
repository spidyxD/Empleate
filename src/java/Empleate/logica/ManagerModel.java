/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;
import Empleate.dao.managerDAO;
/**
 *
 * @author Addiel
 */
class ManagerModel {
     private managerDAO managDAO;
    private static ManagerModel uniqueInstance;
    public static ManagerModel instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ManagerModel();
        }
        return uniqueInstance;
    }
    private ManagerModel(){
        managDAO = new managerDAO();
    }
}
