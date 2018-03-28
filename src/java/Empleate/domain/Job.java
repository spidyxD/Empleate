package Empleate.domain;
// Generated 12/03/2018 12:06:18 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Job generated by hbm2java
 */
public class Job  implements java.io.Serializable {


     private int idJob;
     private Company company;
     private String nameJob;
     private String descriptionJob;
     private Integer salary;
     private String typeJob;
     private Integer statusJob;
     private Set<Jobcategory> jobcategories = new HashSet<Jobcategory>(0);

    public Job() {
        idJob=-1;
        company = new Company();
        nameJob="";
        descriptionJob="";
        salary=0;
        typeJob="";
        statusJob=-1;
        jobcategories = new HashSet<Jobcategory>(0);
    }

    public Job(int idJob, Company company, String nameJob, String descriptionJob, Integer salary, String typeJob, Integer statusJob) {
        this.idJob = idJob;
        this.company = company;
        this.nameJob = nameJob;
        this.descriptionJob = descriptionJob;
        this.salary = salary;
        this.typeJob = typeJob;
        this.statusJob = statusJob;
    }

	
    public Job(int idJob, Company company) {
        this.idJob = idJob;
        this.company = company;
    }
    public Job(int idJob, Company company, String nameJob, String descriptionJob, Integer salary, String typeJob, Integer statusJob, Set<Jobcategory> jobcategories) {
       this.idJob = idJob;
       this.company = company;
       this.nameJob = nameJob;
       this.descriptionJob = descriptionJob;
       this.salary = salary;
       this.typeJob = typeJob;
       this.statusJob = statusJob;
       this.jobcategories = jobcategories;
    }
   
    public int getIdJob() {
        return this.idJob;
    }
    
    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }
    public Company getCompany() {
        return this.company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }
    public String getNameJob() {
        return this.nameJob;
    }
    
    public void setNameJob(String nameJob) {
        this.nameJob = nameJob;
    }
    public String getDescriptionJob() {
        return this.descriptionJob;
    }
    
    public void setDescriptionJob(String descriptionJob) {
        this.descriptionJob = descriptionJob;
    }
    public Integer getSalary() {
        return this.salary;
    }
    
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    public String getTypeJob() {
        return this.typeJob;
    }
    
    public void setTypeJob(String typeJob) {
        this.typeJob = typeJob;
    }
    public Integer getStatusJob() {
        return this.statusJob;
    }
    
    public void setStatusJob(Integer statusJob) {
        this.statusJob = statusJob;
    }
    public Set<Jobcategory> getJobcategories() {
        return this.jobcategories;
    }
    
    public void setJobcategories(Set<Jobcategory> jobcategories) {
        this.jobcategories = jobcategories;
    }




}


