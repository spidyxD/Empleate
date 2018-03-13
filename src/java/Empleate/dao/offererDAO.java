/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.dao;

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
public class offererDAO extends HibernateUtil implements IBaseDAO <Offerer, java.math.BigInteger> {

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
    public Offerer findById(BigInteger id) {
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
    
}
