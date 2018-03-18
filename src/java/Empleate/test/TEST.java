/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.test;

import Empleate.dao.offererDAO;
import Empleate.domain.Login;
import Empleate.domain.Offercategory;
import Empleate.domain.Offerer;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Addiel
 */
public class TEST {
    public static void main(String[] arg){
    offererDAO offD = new offererDAO();
    Set<Offercategory> offercategories = new HashSet<>(0);
    Set<Login> logins = new HashSet<>(0);
    Offerer off = new Offerer(555,"GEORGE","ALFARO","costarricense","gA@gmail.com","506 5616515","MONTE VERDE");   
    offD.add(off);
    System.out.println(offD.findAll().size());
    
    }
}
