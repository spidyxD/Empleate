/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;
import Empleate.dao.loginDAO;
import Empleate.domain.Login;
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
    public LoginModel(){
        logD = new loginDAO();
    } 
    public void addLogin(Login l) throws Exception{
          try{
          logD.add(l);
          }catch(Exception e){}
    }
    public void updateLogin(Login l) throws Exception{
        try{
        logD.doUpdate(l);
        }catch(Exception e){}
    }
    public void deleteLogin(Login l) throws Exception{
        try{
        logD.delete(l);
        }catch(Exception e){}
    }
    public Login findLoginByID(int id) throws Exception{
        try{
        return logD.findById(id);
        }catch(Exception e){}
        return null;
    }
    public Login findLoginByPassword(String key) throws Exception{
        try{
        return logD.findByPassword(key);
        }catch(Exception e){}
        return null;
    }
    public List<Login> findAllLogin() throws Exception{
        try{
        return logD.findAll();
        }catch(Exception e){}
        return null;
    }

    public Login findLoginByData(String username, String password) {
        try{
        return logD.findByData(username,password);
        }catch(Exception e){}
        return null;
    }
    public Login findLoginByUserName(String username) {
        try{
        return logD.findByUsername(username);
        }catch(Exception e){}
        return null;
    }
}
