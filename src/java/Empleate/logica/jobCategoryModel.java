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
public class jobCategoryModel {
    private int percentage;
    private JobModel j;
    private CategoryModel cat;

    public jobCategoryModel() {
    }

    public jobCategoryModel(int percentage, JobModel j, CategoryModel cat) {
        this.percentage = percentage;
        this.j = j;
        this.cat = cat;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public JobModel getJ() {
        return j;
    }

    public void setJ(JobModel j) {
        this.j = j;
    }

    public CategoryModel getCat() {
        return cat;
    }

    public void setCat(CategoryModel cat) {
        this.cat = cat;
    }
    
}
