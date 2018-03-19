/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;
import Empleate.dao.loginDAO;
import Empleate.dao.offererDAO;
import Empleate.domain.Job;
import Empleate.domain.Login;
import java.math.BigInteger;
import java.util.List;

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
      void addLogin(Login l) throws Exception{
          try{
          logD.add(l);
          }catch(Exception e){}
    }
    void updateLogin(Login l) throws Exception{
        try{
        logD.merge(l);
        }catch(Exception e){}
    }
    void deleteLogin(Login l) throws Exception{
        try{
        logD.delete(l);
        }catch(Exception e){}
    }
    Login findLoginByID(int id) throws Exception{
        try{
        return logD.findById(BigInteger.valueOf(id));
        }catch(Exception e){}
        return null;
    }
    
    List<Login> findAllLogin() throws Exception{
        try{
        return logD.findAll();
        }catch(Exception e){}
        return null;
    }
    
}
