package Empleate.domain;
// Generated 12/03/2018 12:06:18 AM by Hibernate Tools 4.3.1

import com.google.gson.annotations.Expose;
import java.util.HashSet;
import java.util.Set;

/**
 * Company generated by hbm2java
 */
public class Company implements java.io.Serializable {

    @Expose
     int idCompany;
    @Expose
     String nameCompany;
    @Expose
     String email;
    @Expose
     String phone;
    @Expose
     String description;
    private double location_X;
    private double location_Y;
    @Expose
     String address;
    private int login;
    private int active;// nuevo
    private Set<Job> jobs = new HashSet<Job>(0);
    private Set<Login> logins = new HashSet<Login>(0);

    public Company() {
        idCompany = -1;
        nameCompany = "";
        email = "";
        phone = "";
        description = "";
        location_X = 0;
        location_Y = 0;
        address = "";
        login = -1;
        active = 0;
        jobs = new HashSet<Job>(0);
        logins = new HashSet<Login>(0);
    }

    public Company(int idCompany) {
        this.idCompany = idCompany;
    }

    public Company(int idCompany, String nameCompany, String email, String phone, String description, String address) {
        this.idCompany = idCompany;
        this.nameCompany = nameCompany;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.address = address;
    }

    public Company(int idCompany, String nameCompany, String email, String phone, String description, double location_X, double location_Y, String address, int login, Set<Job> jobs, Set<Login> logins) {
        this.idCompany = idCompany;
        this.nameCompany = nameCompany;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.location_X = location_X;
        this.location_Y = location_Y;
        this.address = address;
        this.jobs = jobs;
        this.logins = logins;
        this.login = login;
    }

    public Company(int idCompany, String nameCompany, String email, String phone, String description, double location_X, double location_Y, String address, int login) {
        this.idCompany = idCompany;
        this.nameCompany = nameCompany;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.location_X = location_X;
        this.location_Y = location_Y;
        this.address = address;
        this.login = login;
    }

    public int getIdCompany() {
        return this.idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getNameCompany() {
        return this.nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLocation_X() {
        return location_X;
    }

    public void setLocation_X(double location_X) {
        this.location_X = location_X;
    }

    public double getLocation_Y() {
        return location_Y;
    }

    public void setLocation_Y(double location_Y) {
        this.location_Y = location_Y;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Job> getJobs() {
        return this.jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
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
