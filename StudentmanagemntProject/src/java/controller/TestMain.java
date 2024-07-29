/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Student;
import dao.Studentdao;

/**
 *
 * @author HP
 */
public class TestMain {
    public static void main(String[] args) {
        Student S=new Student();
        S.setRno(1601);
        S.setName("A");
        S.setPhy(90);
        S.setChem(20);
        S.setMaths(40);
        Studentdao sd= new Studentdao();
        if(sd.insertStudent(S))
            System.out.println("save");
        else
       System.out.println("not save");
    }
}
