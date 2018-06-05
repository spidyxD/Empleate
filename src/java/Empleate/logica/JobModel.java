/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;

import Empleate.dao.jobDAO;
import Empleate.domain.Job;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Addiel
 */
public class JobModel {

    private final jobDAO jDAO;
    private static JobModel uniqueInstance;

    public static JobModel instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new JobModel();
        }
        return uniqueInstance;
    }

    public JobModel() {
        jDAO = new jobDAO();
    }

    public void addJob(Job j) throws Exception {
        try {
            jDAO.add(j);
        } catch (Exception e) {
        }

    }

    public void updateJob(Job j) throws Exception {
        try {
            jDAO.merge(j);
        } catch (Exception e) {
        }
    }

    public void deleteCompany(Job j) throws Exception {
        try {
            jDAO.delete(j);
        } catch (Exception e) {
        }

    }

    public Job findJobByID(int id) throws Exception {
        try {
            return jDAO.findById(id);
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList findJobByCategory(String c, String id) throws Exception {
        try {
            return jDAO.findByCategory(c, id);
        } catch (Exception e) {
        }
        return null;
    }

    //Busca las categorias con nombre c (tiene pinta de ser el que busca privadamente)
    public List findGeneralJobByCategory(List<Double> c, List<String> p,double x,double y) throws Exception {
        List<Job> jobs = jDAO.findGeneralByCategory(c, p, x, y);
        List<Job> njobs = new ArrayList();//
        try {
            for (int i = 0; i < jobs.size(); i++) {
                int idJ = jobs.get(i).getIdJob();
                Job nj = this.giveJobComplete(idJ);//metodo que retorna category con company
                njobs.add(nj);
            }
            return njobs;
        } catch (Exception e) {
        }
        return null;
    }
    
    //Busca las categorias con nombre c (tiene pinta de ser el que busca publicamente)
    public List findPublicJobByCategory(List<Double> c, List<String> p,double x,double y) throws Exception {
        try{
        List<Job> jobs = jDAO.findPublicByCategory(c,p,x,y);
            return jobs;
        } catch (Exception e) {
        }
        return null;
    }

    

    public List<Job> findAllJobs() throws Exception {
        try {
            return jDAO.findAll();
        } catch (Exception e) {
        }
        return null;
    }

    public List<Job> top5() throws Exception {//para el carusel
        return jDAO.giveTop5();
    }

    public Job giveJobComplete(int id) {
        return jDAO.giveJobComplete(id);
    }
    public List<Job> findAllJobsByCompany(int idCompany){
        return jDAO.findAllJobsByCompany(idCompany);
    }
}
