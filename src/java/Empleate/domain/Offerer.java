package Empleate.domain;
// Generated 12/03/2018 12:06:18 AM by Hibernate Tools 4.3.1


import com.google.gson.annotations.Expose;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Offerer generated by hbm2java
 */
@XmlRootElement
public class Offerer  implements java.io.Serializable {


@Expose private int idOfferer;
@Expose private String nameOfferer;
@Expose private String lastname;
@Expose private String nationality;
@Expose private String email;
@Expose private String phone;
     private double location_X;
     private double location_Y;
@Expose private String residence;
     private int login;
     private Set<Offercategory> offercategories = new HashSet<Offercategory>(0);
     private Set<Login> logins = new HashSet<Login>(0);

    public Offerer() {
    }

    public double getLocation_X() {
        return location_X;
    }

    public void setLocation_X(double location_X) {
        this.location_X = location_X;
    }

    public void setLocation_Y(double location_Y) {
        this.location_Y = location_Y;
    }

    public double getLocation_Y() {
        return location_Y;
    }

	
    public Offerer(int idOfferer) {
        this.idOfferer = idOfferer;
    }
    public Offerer(int idOfferer, String nameOfferer, String lastname, String nationality, String email, String phone, 
            String residence,Set<Offercategory> offercategories, Set<Login> logins,int login) {
        
       this.idOfferer = idOfferer;
       this.nameOfferer = nameOfferer;
       this.lastname = lastname;
       this.nationality = nationality;
       this.email = email;
       this.phone = phone;
       this.residence = residence;
       this.offercategories = offercategories;
       this.logins = logins;
       this.login = login;
    }

    public Offerer(int idOfferer, String nameOfferer, String lastname, 
            String nationality, String email, String phone, String residence,int login) {
        this.idOfferer = idOfferer;
        this.nameOfferer = nameOfferer;
        this.lastname = lastname;
        this.nationality = nationality;
        this.email = email;
        this.phone = phone;
        this.residence = residence;
        this.login = login;
    }
   
    public int getIdOfferer() {
        return this.idOfferer;
    }
    
    public void setIdOfferer(int idOfferer) {
        this.idOfferer = idOfferer;
    }
    public String getNameOfferer() {
        return this.nameOfferer;
    }
    
    public void setNameOfferer(String nameOfferer) {
        this.nameOfferer = nameOfferer;
    }
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getNationality() {
        return this.nationality;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getResidence() {
        return this.residence;
    }
    
    public void setResidence(String residence) {
        this.residence = residence;
    }
    public Set<Offercategory> getOffercategories() {
        return this.offercategories;
    }
    
    public void setOffercategories(Set<Offercategory> offercategories) {
        this.offercategories = offercategories;
    }

    
    public Set<Login> getLogins() {
        return this.logins;
    }
    
    public void setLogins(Set<Login> logins) {
        this.logins = logins;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }
}


