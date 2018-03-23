/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.dao;

import Empleate.domain.Category;
import Empleate.domain.Company;
import Empleate.domain.Job;
import Empleate.utils.HibernateUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Addiel
 */
public class jobDAO extends HibernateUtil implements IBaseDAO <Job, Integer> {

    @Override
    public void add(Job o) {
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
    public Job merge(Job o) {
         try{
            operationStart();
            o = (Job)getSesion().merge(o);
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
    public void delete(Job o) {
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
    public Job findById(Integer id) {
         Job job = null;
         try{
            operationStart();
            job = (Job)getSesion().get(Job.class,id);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
         return job;
    }

    @Override
    public List<Job> findAll() {
         List<Job> listJobs = new ArrayList();
         try{
            operationStart();
            listJobs = getSesion().createQuery("from Job").list();
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
    return listJobs;
    }
    public ArrayList<Job> findByCategory(Category cat){
        ArrayList<Job> jobs = new ArrayList();
        try{
           operationStart();
           String sql = " ";
           getSesion().createQuery(sql);
           getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
        return jobs;
    }
    public ArrayList<Job> giveTop5(){
        ArrayList<Job> top = new ArrayList();
        try{
           operationStart();
           String sql = " ";
           getSesion().createQuery(sql);
           getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
        return top;
    }
}