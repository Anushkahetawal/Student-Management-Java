/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import myconnection.OnlineConnection;

/**
 *
 * @author HP
 */
public class Test1 
{
    
      public static boolean insertStudent(Student s) throws SQLException
      {
         
              Connection con=null;
              PreparedStatement ps=null;
              System.out.println(s.toString());
              con=OnlineConnection.getConnection();
              String sql;
              sql="insert into student values(?,?,?,?,?) ";
              ps=con.prepareStatement(sql);
              ps.setInt(1, s.getRno());
              ps.setString(2, s.getName());
              ps.setInt(3, s.getPhy());
              ps.setInt(4, s.getChem());
              ps.setInt(5, s.getMaths());
              if(ps.executeUpdate()>0)
                  return true;
              else
                  return false;
                   
      }
          
}
