/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.domain;

/**
 *
 * @author Andrés Gutiérrez
 */
public class Coordenada {
    
    double X;
    double Y;

    public Coordenada(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    public Coordenada() {
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public void setX(double X) {
        this.X = X;
    }

    public void setY(double Y) {
        this.Y = Y;
    }    
}
