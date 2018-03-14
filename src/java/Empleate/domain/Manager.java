package Empleate.domain;
// Generated 12/03/2018 12:06:18 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Manager generated by hbm2java
 */
public class Manager  implements java.io.Serializable {


     private int idManager;
     private String email;
     private Set<Login> logins = new HashSet<Login>(0);

    public Manager() {
    }

    public Manager(int idManager, String email) {
        this.idManager = idManager;
        this.email = email;
    }

	
    public Manager(int idManager) {
        this.idManager = idManager;
    }
    public Manager(int idManager, String email, Set<Login> logins) {
       this.idManager = idManager;
       this.email = email;
       this.logins = logins;
    }
   
    public int getIdManager() {
        return this.idManager;
    }
    
    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set<Login> getLogins() {
        return this.logins;
    }
    
    public void setLogins(Set<Login> logins) {
        this.logins = logins;
    }




}


