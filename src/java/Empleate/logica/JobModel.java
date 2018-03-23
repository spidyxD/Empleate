/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;
import Empleate.dao.jobDAO;
import Empleate.domain.Job;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Addiel
 */
public class JobModel {
    private jobDAO jDAO;
     private static JobModel uniqueInstance;
    public static JobModel instance(){
        if (uniqueInstance == null){
            uniqueInstance = new JobModel();
        }
        return uniqueInstance;
    }
    public JobModel(){
        jDAO = new jobDAO();
    }
    public void addJob(Job j) throws Exception{
         try{
         jDAO.add(j);
         }catch(Exception e){}
    
     }
    public void updateJob(Job j) throws Exception{
        try{
        jDAO.merge(j);
        }catch(Exception e){}
    }
    public void deleteCompany(Job j) throws Exception{
        try{
        jDAO.delete(j);
        }catch(Exception e){}
    
    }
    public Job findJobByID(int id) throws Exception{
        try{
        return jDAO.findById(id);
        }catch(Exception e ){}
        return null;
    }
    
    public List<Job> findAllJobs() throws Exception{
        try{
        return jDAO.findAll();
        }catch(Exception e){}
        return null;
    }
     public List<Job> top5() throws Exception{//para el carusel
        List<Job> ls = (this.findAllJobs());
        ArrayList<Job> ls2 = new ArrayList<Job>();
        if(ls.size()<=5){
            for (int i = 1; i <= 5; i++) {
                ls2.add(ls.get(ls.size()-i));
            }
        }else{
            return ls;
        }
        return ls2;  
    }
}
