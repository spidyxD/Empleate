package Empleate.domain;
// Generated 12/03/2018 12:06:18 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Manager generated by hbm2java
 */
public class Manager  implements java.io.Serializable {


     private int idManager;
     private String username;
     private String password;
     private Set<Login> logins = new HashSet<Login>(0);

    public Manager() {
    }

    public Manager(int idManager, String email,String passw) {
        this.idManager = idManager;
        this.username = email;
        this.password = passw;
    }

	
    public Manager(int idManager) {
        this.idManager = idManager;
    }
    public Manager(int idManager, String email,String passw, Set<Login> logins) {
       this.idManager = idManager;
       this.username = email;
       this.password = passw;
       this.logins = logins;
    }
   
    public int getIdManager() {
        return this.idManager;
    }
    
    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<Login> getLogins() {
        return this.logins;
    }
    
    public void setLogins(Set<Login> logins) {
        this.logins = logins;
    }




}


