/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;

import Empleate.dao.companyDAO;
import Empleate.domain.Company;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author Addiel
 */
public class CompanyModel {

    private companyDAO compDAO;
    private static CompanyModel uniqueInstance;

    public static CompanyModel instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new CompanyModel();
        }
        return uniqueInstance;
    }

    public CompanyModel() {
        compDAO = new companyDAO();
    }

    public void addCompany(Company c) throws Exception {
        try {
            compDAO.add(c);
        } catch (Exception e) {
        }

    }

    public void updateCompany(Company c) throws Exception {
        try {
            compDAO.doUpdate(c);
        } catch (Exception e) {
        }

    }

    void deleteCompany(Company c) throws Exception {
        try {
            compDAO.delete(c);
        } catch (Exception e) {
        }
    }

    public Company findCompanyByID(int id) throws Exception {
        try {
            return compDAO.findById(id);
        } catch (Exception e) {
        }
        return null;
    }

    public Company findCompanyByIdLogin(String id) throws Exception {
        try {
            return compDAO.findByIdLogin(id);
        } catch (Exception e) {
        }
        return null;
    }

    public List<Company> findAllCompanies() throws Exception {
        try {
            return compDAO.findAll();
        } catch (Exception e) {
        }
        return null;
    }

    public List<Company> findActive() throws Exception {
        try {
            return compDAO.listActive();
        } catch (Exception e) {
        }
        return null;
    }

    public List<Company> findNOActive() throws Exception {
        try {
            return compDAO.listNOActive();
        } catch (Exception e) {
        }
        return null;
    }

    public boolean findByLogin(int idL) {
        return compDAO.findByIdLogin(idL);
    }
     public void updateOfferer(String email){
        compDAO.doUpdateState(email);
    }
}
