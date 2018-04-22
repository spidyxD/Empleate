/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.dao;

import Empleate.domain.Category;
import Empleate.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Addiel
 */
public class categoryDAO extends HibernateUtil implements IBaseDAO <Category, Integer> {

    @Override
    public void add(Category o) {
        try{
            operationStart();
            getSesion().save(o);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
    }

    @Override
    public Category merge(Category o) {
         try{
            operationStart();
            o = (Category)getSesion().merge(o);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
         return o;
    }

    @Override
    public void delete(Category o) {
        try{
            operationStart();
            getSesion().delete(o);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
    }

    @Override
    public Category findById(Integer id) {
         Category category = null;
         try{
            operationStart();
            category = (Category)getSesion().get(Category.class,id);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
         return category;
    }

    @Override
    public List<Category> findAll() {
        List<Category> listCategories = new ArrayList();
         try{
            operationStart();
            listCategories = getSesion().createQuery("from Category").list();
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
    return listCategories;
    }
    public List<Category> giveParentRoots(){
      List<Category> cl = new ArrayList();
      String sql = "select *from category where parentCategory IS NULL ;";
        try{
            operationStart();
            cl = getSesion().createSQLQuery(sql).addEntity(Category.class).list();
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
      return cl;
  }
  /*public List<Category> giveParentCategories(){
      List<Category> cl = new ArrayList();
      String sql = "select *from category where categ IS NULL OR parentCategory = idCategory;";
        try{
            operationStart();
            cl = getSesion().createSQLQuery(sql).addEntity(Category.class).list();
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
      return cl;
  }*/
 
  public List<Category> giveChildCategory(int idParent){
      List<Category> cl = new ArrayList();
      String sql = "select  idCategory,\n" +
        " name_Category,\n" +
        " parentCategory \n" +
        " from category\n" +
        "where category.parentCategory="+"'"+idParent+"'";
        try{
            operationStart();
            cl = getSesion().createSQLQuery(sql).addEntity(Category.class).list();
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
      return cl;
  }
  

}
