/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.logica;

import Empleate.dao.offerCategoryDAO;
import Empleate.domain.Offercategory;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Addiel
 */
public class offerCategoryModel {

    private offerCategoryDAO ocDAO;
    private static offerCategoryModel uniqueInstance;

    public static offerCategoryModel instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new offerCategoryModel();
        }
        return uniqueInstance;
    }

    public offerCategoryModel() {
        ocDAO = new offerCategoryDAO();
    }
    
    public void addOffererCat(Offercategory offCat) {
        ocDAO.add(offCat);
    }
    
    public void updateOffererCat(Offercategory offCat) {
        ocDAO.merge(offCat);
    }
    
    public void deleteOffererCat(Offercategory offCat) {
        ocDAO.delete(offCat);
    }
    
    public Offercategory findById(int id) {
        return ocDAO.findById(id);
    }
    
    public ArrayList<Offercategory> findAll() {
        ArrayList<Offercategory> listOfferer = new ArrayList<Offercategory>(ocDAO.findAll());
        return listOfferer;
    }
    
    public void insertarOfferCategory(int id, int cat, int por) {
        ocDAO.insertarOfferCategory(id, cat, por);
    }
    
}
