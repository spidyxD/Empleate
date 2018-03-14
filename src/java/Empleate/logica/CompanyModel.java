/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;
import Empleate.dao.companyDAO;
/**
 *
 * @author Addiel
 */
public class CompanyModel {
   private companyDAO compDAO;
    private static CompanyModel uniqueInstance;
    public static CompanyModel instance(){
        if (uniqueInstance == null){
            uniqueInstance = new CompanyModel();
        }
        return uniqueInstance;
    }
    private CompanyModel(){
        compDAO = new companyDAO();
    }
}
