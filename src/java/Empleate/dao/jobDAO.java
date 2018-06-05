/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.dao;

import Empleate.domain.Company;
import Empleate.domain.Job;
import Empleate.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Addiel
 */
public class jobDAO extends HibernateUtil implements IBaseDAO<Job, Integer> {

    @Override
    public void add(Job o) {
        try {
            operationStart();
            getSesion().save(o);
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
    }

    @Override
    public Job merge(Job o) {
        try {
            operationStart();
            o = (Job) getSesion().merge(o);
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return o;
    }

    @Override
    public void delete(Job o) {
        try {
            operationStart();
            getSesion().delete(o);
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
    }

    @Override
    public Job findById(Integer id) {
        Job job = null;
        try {
            operationStart();
            job = (Job) getSesion().get(Job.class, id);
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return job;
    }

    @Override
    public List<Job> findAll() {
        List<Job> listJobs = new ArrayList();
        try {
            operationStart();
            listJobs = getSesion().createQuery("from Job").list();
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return listJobs;
    }

    public ArrayList<Job> findByCategory(String cat, String p) {
        ArrayList<Job> jobs = new ArrayList();
        try {
            operationStart();
            int percent = Integer.parseInt(p);
            if (percent != 0) {
                String sql = "select job.idJob,job.name_job,job.description_job,salary,type_job,job.comp,job.status_job from job,jobCategory,category where job.idJob=jobCategory.j and jobCategory.cat = category.idCategory and Job.type_Job= 0 and category.name_category=" + "'" + cat + "'and jobCategory.percentage=" + String.valueOf(percent) + ";";
                getSesion().createSQLQuery(sql).addEntity(Job.class).list();
                getTransac().commit();
            } else {
                String sql = "select job.idJob,job.name_job,job.description_job,salary,type_job,job.comp,job.status_job from job,jobCategory,category where job.idJob=jobCategory.j and jobCategory.cat = category.idCategory and Job.type_Job= 0 and category.name_category=" + "'" + cat + "';";
                getSesion().createSQLQuery(sql).addEntity(Job.class).list();
                getTransac().commit();
            }

        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return jobs;
    }

    //busqueda privada
    public List<Job> findGeneralByCategory(List<Double> cat, List<String> p,double x, double y) {
        List<Job> jobs = new ArrayList();
        try {
            operationStart();                    
             String sql = "select job.idJob,job.name_job,job.description_job,salary,type_job,job.comp,job.status_job from "
                        + "company,job,jobCategory,category where company.idCompany=job.comp and job.idJob=jobCategory.j and jobCategory.cat = category.idCategory";
                         //"company.location_X <=" + x + " and company.location_Y <= "+ y;
                        for(int i=0;i<cat.size();i++){
             sql = sql + " and jobCategory.cat="        
                        + cat.get(i).intValue() +" and jobCategory.percentage=" + Integer.valueOf(p.get(i));
                        }
             sql = sql + ";";           
                String sql2 = "select *from job;";
                jobs = getSesion().createSQLQuery(sql).addEntity(Job.class).list();
                getTransac().commit();
           

        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return jobs;//retorno la lista con objetos completos
    }
    
    

    public List<Job> giveTop5() {
        List<Job> top = new ArrayList();
        try {
            operationStart();
            top = getSesion().createSQLQuery("select *from job where type_Job = 'public' and status_Job = 1 order by idJob DESC limit 5;").addEntity(Job.class).list();
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return top;
    }
    
    
    
    //busqueda publica
    
    public List<Job> findPublicByCategory(List<Double> cat, List<String> p,double x, double y) {
        List<Job> jobs = new ArrayList();
        try {
            operationStart();
            
         
             String sql = "select job.idJob,job.name_job,job.description_job,salary,type_job,job.comp,job.status_job from "
                        + "company,job,jobCategory,category where company.idCompany=job.comp and job.idJob=jobCategory.j and jobCategory.cat = category.idCategory "; 
                        // "company.location_X <=" + x + " and company.location_Y <= "+ y;
                        for(int i=0;i<cat.size();i++){
             sql = sql + " and jobCategory.cat="        
                        + cat.get(i).intValue() +" and jobCategory.percentage=" + Integer.valueOf(p.get(i));
                        }
             sql= sql+" and job.type_Job = 'public'"+";";
                String sql2 = "select *from job;";
                jobs = getSesion().createSQLQuery(sql).addEntity(Job.class).list();
                getTransac().commit();
           

        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return jobs;//retorno la lista con objetos completos
    }
    

    //NUEVA PROPIEDAD PARA LA FUNCIONALIDAD DE BUSQUEDA DE COMPAÑIA POR PUESTO
    public Job giveJobComplete(int idJob) {
        Job job = new Job();
        List<Job> jl = new ArrayList();
        try {
            operationStart();
            String sql = "select *from job j inner join company c on j.comp = c.idCompany where j.idJob like " + idJob + ";";
            jl = getSesion().createSQLQuery(sql).addEntity(Job.class).list();
            job = jl.get(0);
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return job;
    }
    public List<Job> findAllJobsByCompany(int idCompany) {// por borrar, no se ocupa, lo dejo por si acaso
        List<Job> listJob = new ArrayList();
        try {
            operationStart();
            String sql = "select * from job, company "
                    + "where job.comp = company.idCompany and company.idCompany =" + "'" + idCompany + "'";
            listJob = getSesion().createSQLQuery(sql).addEntity(Job.class).list();
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return listJob;
    }
}
