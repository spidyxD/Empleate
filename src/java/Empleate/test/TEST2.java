/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.test;

import Empleate.domain.Company;
import Empleate.domain.Offerer;
import Empleate.logica.CompanyModel;
import Empleate.logica.OffererModel;
import java.util.ArrayList;


/**
 *
 * @author Andrés Gutiérrez
 */
public class TEST2 {
    public static void main(String[] arg) throws Exception{
       Offerer  off = new Offerer();
       off.setIdOfferer(2);
       off.setLogin(9);
       off.setPhone("85732292");
        OffererModel.instance().updateOfferer(off);
    }
    
}
