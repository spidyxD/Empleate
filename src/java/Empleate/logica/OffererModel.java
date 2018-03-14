/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;
import Empleate.dao.categoryDAO;
import Empleate.dao.offererDAO;
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
    private OffererModel(){
        offDAO = new offererDAO();
    }
}
