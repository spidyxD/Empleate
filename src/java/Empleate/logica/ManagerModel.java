/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;
import Empleate.dao.managerDAO;
import Empleate.domain.Manager;
import java.math.BigInteger;
import java.util.ArrayList;
/**
 *
 * @author Addiel
 */
public class ManagerModel {
     private managerDAO managerDAO;
    private static ManagerModel uniqueInstance;
    public static ManagerModel instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ManagerModel();
        }
        return uniqueInstance;
    }
    private ManagerModel(){
        managerDAO = new managerDAO();
    }
    
    public void addOfferer(Manager man){
        managerDAO.add(man);
    }
    
    public void updateOfferer(Manager man){
        managerDAO.merge(man);
    }
    
    public void deleteOfferer(Manager man){
        managerDAO.delete(man);
    }
    
    public Manager findById(int id){
        return managerDAO.findById(id);
    }
    
     public ArrayList<Manager> findAll() {
         ArrayList<Manager> listManager = new ArrayList<Manager>(managerDAO.findAll());
         return listManager;
     }

    public Manager findByIdLogin(int idLogin) {
        return managerDAO.findByIdLogin(idLogin);
    }
    
}// Fin de la clase
