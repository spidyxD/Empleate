/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.domain;

import com.google.gson.annotations.Expose;

/**
 *
 * @author Andrés Gutiérrez
 */
public class categorySimple {
    @Expose int id;
    @Expose String nombre;
    @Expose int padre;    

    public categorySimple() {
    }

    public categorySimple(int id, String nombre, int padre) {
        this.id = id;
        this.nombre = nombre;
        this.padre = padre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPadre() {
        return padre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }
        
}
