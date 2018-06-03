/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;
import Empleate.dao.offererDAO;
import Empleate.domain.Offerer;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Addiel
 */
public class OffererModel {
    private offererDAO offDAO;
    private static OffererModel uniqueInstance;
    public static OffererModel instance(){
        if (uniqueInstance == null){
            uniqueInstance = new OffererModel();
        }
        return uniqueInstance;
    }
    public OffererModel(){
        offDAO = new offererDAO();
    }
    
    public void addOfferer(Offerer offerer){
        offDAO.add(offerer);
    }
    
    public void updateOfferer(Offerer offerer){
        offDAO.doUpdate(offerer);
    }
    
    public void deleteOfferer(Offerer offerer){
        offDAO.delete(offerer);
    }
    
    public Offerer findById(int id){
        return offDAO.findById(id);
    }
    
     public ArrayList<Offerer> findAll() {
         ArrayList<Offerer> listOfferer = new ArrayList<Offerer>(offDAO.findAll());
         return listOfferer;
     }
    public Offerer findByIdLogin(int idLogin){
        return offDAO.findByIdLogin(String.valueOf(idLogin));
    }
    
    public boolean findByLogin(int idL){
        return offDAO.findByIdLogin(idL);
    }
      public List<Offerer> findActive() throws Exception {
        try {
            return offDAO.listActive();
        } catch (Exception e) {
        }
        return null;
    }

    public List<Offerer> findNOActive() throws Exception {
        try {
            return offDAO.listNOActive();
        } catch (Exception e) {
        }
        return null;
    }
    
    public void updateOfferer(String email){
        offDAO.doUpdateState(email);
    }
}//fin clase

