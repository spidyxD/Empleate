package Empleate.domain;
// Generated 12/03/2018 12:06:18 AM by Hibernate Tools 4.3.1



/**
 * Jobcategory generated by hbm2java
 */
public class Jobcategory  implements java.io.Serializable {


     private JobcategoryId id;
     private Category category;
     private Job job;
     private Integer percentage;

    public Jobcategory() {
    }

	
    public Jobcategory(JobcategoryId id, Category category, Job job) {
        this.id = id;
        this.category = category;
        this.job = job;
    }
    public Jobcategory(JobcategoryId id, Category category, Job job, Integer percentage) {
       this.id = id;
       this.category = category;
       this.job = job;
       this.percentage = percentage;
    }
   
    public JobcategoryId getId() {
        return this.id;
    }
    
    public void setId(JobcategoryId id) {
        this.id = id;
    }
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    public Job getJob() {
        return this.job;
    }
    
    public void setJob(Job job) {
        this.job = job;
    }
    public Integer getPercentage() {
        return this.percentage;
    }
    
    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }




}

