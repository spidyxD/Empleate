/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.dao;

import Empleate.domain.Company;
import Empleate.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Addiel
 */
public class companyDAO extends HibernateUtil implements IBaseDAO<Company, Integer> {

    @Override
    public void add(Company o) {
        try {
            operationStart();
            getSesion().save(o);
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
    }

    @Override
    public Company merge(Company o) {
        try {
            operationStart();
            o = (Company) getSesion().merge(o);
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return o;
    }

    @Override
    public void delete(Company o) {
        try {
            operationStart();
            getSesion().delete(o);
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
    }

    @Override
    public Company findById(Integer id) {
        Company company = null;
        try {
            operationStart();
            company = (Company) getSesion().get(Company.class, id);
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return company;
    }

    @Override
    public List<Company> findAll() {
        List<Company> listCompanies = new ArrayList();
        try {
            operationStart();
            listCompanies = getSesion().createQuery("from Company").list();
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return listCompanies;
    }

    public Company findByLocation(String location) {
        Company c = null;
        try {
            operationStart();
            c = (Company) getSesion().byId(location);
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return c;
    }

    public Company findByIdLogin(String idLogin) {
        Company c = null;
        List<Company> cl = new ArrayList();
        try {
            operationStart();
            String sql = "select *from company where login=" + "'" + idLogin + "';";
            cl = getSesion().createSQLQuery(sql).addEntity(Company.class).list();
            c = cl.get(0);
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return c;
    }

    public List<Company> listActive() {
        List<Company> listCom = new ArrayList<>();
        String sql = "select idCompany,name_company, description, "
                + "address,email,phone,active,location_X,location_Y,login"
                + " from company where "
                + "company.active = " + 1 + ";";
        try {
            operationStart();
            listCom = getSesion().createSQLQuery(sql).addEntity(Company.class).list();
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return listCom;
    }

    public List<Company> listNOActive() {
        List<Company> listCom = new ArrayList<>();
        String sql = "select idCompany,name_company, description, "
        +"address,email, phone,active,location_X,location_Y,login from company where "+
                   " company.active =" +0+" or company.active = null";
        try {
            operationStart();
            listCom = getSesion().createSQLQuery(sql).addEntity(Company.class).list();
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return listCom;
    }
}
