/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.dao;

import Empleate.domain.Jobcategory;
import Empleate.utils.HibernateUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Addiel
 */
public class jobCategoryDAO extends HibernateUtil implements IBaseDAO <Jobcategory, Integer> {

    @Override
    public void add(Jobcategory o) {
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
    public Jobcategory merge(Jobcategory o) {
        try{
            operationStart();
            o = (Jobcategory)getSesion().merge(o);
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
    public void delete(Jobcategory o) {
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
    public Jobcategory findById(Integer id) {
          Jobcategory jc = null;
         try{
            operationStart();
            jc = (Jobcategory)getSesion().get(Jobcategory.class,id);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
         return jc;
    }

    @Override
    public List<Jobcategory> findAll() {
         List<Jobcategory> listJC = new ArrayList();
         try{
            operationStart();
            listJC = getSesion().createQuery("from jobCategory").list();
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
    return listJC;
    }
    
}
