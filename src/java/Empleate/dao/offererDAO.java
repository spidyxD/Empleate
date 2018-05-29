/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.dao;

import Empleate.domain.Company;
import Empleate.domain.Offerer;
import Empleate.utils.HibernateUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Addiel
 */
public class offererDAO extends HibernateUtil implements IBaseDAO <Offerer,Integer> {

    @Override
    public void add(Offerer o) {
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
    public Offerer merge(Offerer o) {
        try{
            operationStart();
            o = (Offerer)getSesion().merge(o);
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
    public void delete(Offerer o) {
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
    public Offerer findById(Integer id) {
         Offerer offerer = null;
         try{
            operationStart();
            offerer = (Offerer)getSesion().get(Offerer.class,id);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
         return offerer;
    }

    @Override
    public List<Offerer> findAll() {
         List<Offerer> listofferers = new ArrayList();
         try{
            operationStart();
            listofferers = getSesion().createQuery("from Offerer").list();
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
    return listofferers;
    }
    public Offerer findByIdLogin(String idLogin){
        Offerer o = null;
        List<Offerer> ol = new ArrayList();
        try{
            operationStart();
            String sql = "select *from offerer where login="+"'"+idLogin+"';";
            ol = getSesion().createSQLQuery(sql).addEntity(Offerer.class).list();
            o = ol.get(0);
            
        }catch(HibernateException he){
        handleException(he);
            throw he;
        }
         finally{
        getSesion().close();
        }
        return o;
    }
     public void doUpdate(Offerer o){
         List<Offerer> off = new ArrayList();
        try{
            operationStart();
            String sql = "update offerer set name_offerer = '"+o.getNameOfferer()+"'"+", lastname = '"+o.getLastname()+"'"+", nationality = '"+o.getNationality()+"'"+
                    ", email ='"+o.getEmail()+"'"+", phone = '"+o.getPhone()+"'"+", residence = '"+o.getResidence()+"'" + " where idOfferer = "+o.getIdOfferer()+";";
          getSesion().createSQLQuery(sql).executeUpdate();
           //Offerer of = off.get(0);          
            getTransac().commit();
            getSesion().flush();
        }catch(HibernateException he){
        handleException(he);
            throw he;
        }
         finally{
        getSesion().close();
        }
    }
     
      public boolean findByIdLogin(Integer id) {
        List<Offerer> offerer = new ArrayList();
         try{
            operationStart();
            String sql = "select *from offerer where login ="+id+";";
            offerer = getSesion().createSQLQuery(sql).addEntity(Offerer.class).list();
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
         return !offerer.isEmpty();
    }
}
