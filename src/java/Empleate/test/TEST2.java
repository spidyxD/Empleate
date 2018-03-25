/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleate.test;

import Empleate.domain.Job;
import Empleate.logica.JobModel;
import java.util.ArrayList;

/**
 *
 * @author Andrés Gutiérrez
 */
public class TEST2 {
    public static void main(String[] arg) throws Exception{
        JobModel jM = new JobModel();
        ArrayList<Job> js = (ArrayList<Job>) jM.top5();
        for (int i = 0; i < js.size(); i++) {
            System.out.println(js.get(i).getNameJob());
        }     
               
    }
    
}
