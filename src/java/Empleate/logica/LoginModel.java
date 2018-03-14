/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;


/**
 *
 * @author Addiel
 */
public class LoginModel {
    private int idLogin;
    private String username;
    private String password_log;
    private String type_log;
    private ManagerModel manag;
    private CompanyModel comp;
    private OffererModel offer;

    public LoginModel() {
    }

    public LoginModel(int idLogin, String username, String password_log, String type_log, ManagerModel manag, CompanyModel comp, OffererModel offer) {
        this.idLogin = idLogin;
        this.username = username;
        this.password_log = password_log;
        this.type_log = type_log;
        this.manag = manag;
        this.comp = comp;
        this.offer = offer;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_log() {
        return password_log;
    }

    public void setPassword_log(String password_log) {
        this.password_log = password_log;
    }

    public String getType_log() {
        return type_log;
    }

    public void setType_log(String type_log) {
        this.type_log = type_log;
    }

    public ManagerModel getManag() {
        return manag;
    }

    public void setManag(ManagerModel manag) {
        this.manag = manag;
    }

    public CompanyModel getComp() {
        return comp;
    }

    public void setComp(CompanyModel comp) {
        this.comp = comp;
    }

    public OffererModel getOffer() {
        return offer;
    }

    public void setOffer(OffererModel offer) {
        this.offer = offer;
    }
    
    
}
