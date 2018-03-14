/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;
import Empleate.dao.loginDAO;
import Empleate.dao.offererDAO;

/**
 *
 * @author Addiel
 */
public class LoginModel {
  private loginDAO logD;
    private static LoginModel uniqueInstance;
    public static LoginModel instance(){
        if (uniqueInstance == null){
            uniqueInstance = new LoginModel();
        }
        return uniqueInstance;
    }
    private LoginModel(){
        logD = new loginDAO();
    } 
}
