/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Student;
import dao.Studentdao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class Insertdata1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        PrintWriter out=response.getWriter();
        int rno,phy,chem,maths;
        String name;
        rno=Integer.parseInt(request.getParameter("txtrno"));
        name=request.getParameter("txtname");
        phy=Integer.parseInt(request.getParameter("txtphy"));
        chem=Integer.parseInt(request.getParameter("txtchem"));
        maths=Integer.parseInt(request.getParameter("txtmaths"));
        
        Student S=new Student();
        Studentdao sd=new Studentdao();
        S.setRno(rno);
        S.setName(name);
        S.setPhy(phy);
        S.setChem(chem);
        S.setMaths(maths);
//        if(sd.insertStudent(S))
//            out.println("record inserted");
//        else
//            out.println("your record is not inserted..");
         if(sd.insertStudent(S))
             response.sendRedirect("RecordYes.html");
         else
             response.sendRedirect("RecordNo.html");
    }

}
