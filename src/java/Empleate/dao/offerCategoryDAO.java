/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.dao;

import Empleate.domain.Company;
import Empleate.domain.Offercategory;
import Empleate.domain.Offerer;
import Empleate.utils.HibernateUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Addiel
 */
public class offerCategoryDAO extends HibernateUtil implements IBaseDAO<Offercategory, Integer> {

    @Override
    public void add(Offercategory o) {
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
    public Offercategory merge(Offercategory o) {
        try {
            operationStart();
            o = (Offercategory) getSesion().merge(o);
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
    public void delete(Offercategory o) {
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
    public Offercategory findById(Integer id) {
        Offercategory oc = null;
        try {
            operationStart();
            oc = (Offercategory) getSesion().get(Offercategory.class, id);
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return oc;
    }

    @Override
    public List<Offercategory> findAll() {
        List<Offercategory> listOC = new ArrayList();
        try {
            operationStart();
            listOC = getSesion().createQuery("from offerCategory").list();
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return listOC;
    }

    public void insertarOfferCategory(int id, int cat, int por) {
        try {
            String sql;
            sql = "insert into offerCategory (offer, cat, percentage)values("+id+","+cat+","+por+");";
            operationStart();
            getSesion().createSQLQuery(sql).executeUpdate();
            getTransac().commit();
        } catch (HibernateException he) {
            handleException(he);
            throw he;
        } finally {
            getSesion().close();
        }
    }
}
