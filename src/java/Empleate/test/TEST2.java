/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.test;

import Empleate.domain.Company;
import Empleate.logica.CompanyModel;
import Empleate.logica.LoginModel;
import java.util.ArrayList;


/**
 *
 * @author Andrés Gutiérrez
 */
public class TEST2 {
    public static void main(String[] arg) throws Exception{
        System.out.println(LoginModel.instance().findLoginByUserName("andres_G1") ==null);
    }
    
}
