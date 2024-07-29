/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Student;

/**
 *
 * @author HP
 */
public class Test {
    public static void main(String[] args) {
        
        
        Studentdao s  = new Studentdao();
        Student sd = new Student();
        sd.setRno(29);
        sd.setName("jasdfk");
        sd.setChem(31);
        sd.setMaths(31);
        sd.setPhy(31);
        
        s.insertStudent(sd);
    }
    
}
