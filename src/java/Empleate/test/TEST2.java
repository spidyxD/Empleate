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
       ArrayList<Offerer> ls = (ArrayList<Offerer>) OffererModel.instance().findActive();
       for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i).getNameOfferer());
        }
    }
    
}
