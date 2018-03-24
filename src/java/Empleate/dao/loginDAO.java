/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.dao;

import Empleate.domain.Job;
import Empleate.domain.Login;
import Empleate.utils.HibernateUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Addiel
 */
public class loginDAO extends HibernateUtil implements IBaseDAO <Login,Integer> {

    @Override
    public void add(Login o) {
          try{
            operationStart();
            getSesion().save(o);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
    }

    @Override
    public Login merge(Login o) {
        try{
            operationStart();
            o = (Login)getSesion().merge(o);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
         return o;
    }

    @Override
    public void delete(Login o) {
         try{
            operationStart();
            getSesion().delete(o);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
    }

    @Override
    public Login findById(Integer id) {
         Login log = null;
         try{
            operationStart();
            log = (Login)getSesion().get(Login.class,id);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
         return log;
    }
     public Login findByPassword(String key) {
         Login log = null;
         String sql = "Select *from login where password =" + "'" + key + "'";
         try{
            operationStart();
            log = (Login)getSesion().createSQLQuery(sql);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
         return log;
    }

    @Override
    public List<Login> findAll() {
          List<Login> listLogin = new ArrayList();
         try{
            operationStart();
            listLogin = getSesion().createQuery("from Login").list();
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
    return listLogin;
    }
    
}
