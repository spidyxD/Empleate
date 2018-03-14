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
public class offerCategoryModel {
   private int percentage;
    private OffererModel off;
    private CategoryModel cat;

    public offerCategoryModel() {
    }

    public offerCategoryModel(int percentage, OffererModel off, CategoryModel cat) {
        this.percentage = percentage;
        this.off = off;
        this.cat = cat;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public OffererModel getOff() {
        return off;
    }

    public void setOff(OffererModel off) {
        this.off = off;
    }

    public CategoryModel getCat() {
        return cat;
    }

    public void setCat(CategoryModel cat) {
        this.cat = cat;
    }
    
    
  
}
