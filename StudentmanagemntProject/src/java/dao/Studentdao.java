package dao;
import java.sql.*;
import Model.Student;
import java.util.*;
import myconnection.OnlineConnection;
public class Studentdao //ye class database se deal kregi
{
    public int auto()
    {
        int n=-1;
      try
      {      
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        con=OnlineConnection.getConnection();
        String sql;
        sql="select max(rollnum) from student";
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        if(rs.next())
            n=rs.getInt(1);
            n=n+1;
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
    return(n);
    
    }
    public boolean updateStudent(Student s)
      {
          try{
              Connection con=null;
              PreparedStatement ps=null;
              con=OnlineConnection.getConnection();
              String sql;
              sql="update student set name=?,physics=?,chemistry=?,maths=? where rollnum=?";
              ps=con.prepareStatement(sql);
              ps.setInt(5, s.getRno());
              ps.setString(1, s.getName());
              ps.setInt(2, s.getPhy());
              ps.setInt(3, s.getChem());
              ps.setInt(4, s.getMaths());
              int n;
              n = ps.executeUpdate();
              if(n>0)
                  return true;
                   
              
          }
          catch(Exception e)
          {
              System.out.println(e);
           }  
          return false;

      }

      public boolean insertStudent(Student s)
      {
          try{
              Connection con=null;
              PreparedStatement ps=null;
              con=OnlineConnection.getConnection();
              String sql;
              sql="insert into student values(?,?,?,?,?)";
              ps=con.prepareStatement(sql);
              ps.setInt(1, s.getRno());
              ps.setString(2, s.getName());
              ps.setInt(3, s.getPhy());
              ps.setInt(4, s.getChem());
              ps.setInt(5, s.getMaths());
              int n;
              n = ps.executeUpdate();
              if(n>0)
                  return true;
                   
              
          }
          catch(Exception e)
          {
              System.out.println(e);
           }  
          return false;

      }

//    public boolean insertStudent(Student s)
//    {
//        int n;
//        try{
//        Connection con=null;
//        con=OnlineConnection.getConnection();
////        System.out.println(s.getRno());
////        System.out.println(s.getName());
////        System.out.println(s.getPhy());
////        System.out.println(s.getChem());
////        System.out.println(s.getMaths());
//         PreparedStatement ps=null;
//         String sql;
//         sql="insert into student values(?,?,?,?,?)";
//         ps=con.prepareStatement(sql);
//         ps.setInt(1,s.getRno());
//         ps.setString(2,s.getName());
//         ps.setInt(3,s.getPhy());
//         ps.setInt(4,s.getChem());
//         ps.setInt(5,s.getMaths());
//         n=ps.executeUpdate();
//         if(n>0)
//            return true;
//        }
//        catch(Exception e )
//        {
//            System.out.println(e);
//        }
//        return false; 
//    }
    public Student searchByRno(int rno)
 {
      int n=0;
      Student S=new Student();
      try
      {      
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        con=OnlineConnection.getConnection();
        String sql;
        sql="select * from student where rollnum=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1, rno);
        rs=ps.executeQuery();
        
        if(rs.next())
        {
              S.setRno(rs.getInt(1));
              S.setName(rs.getString(2));
              S.setPhy(rs.getInt(3));
              S.setChem(rs.getInt(4));
              S.setMaths(rs.getInt(5));
        }
       else
            S=null;
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
     return (S);  
 }
 
     public boolean deleteStudent(int rno)
    {
       int n=0;
      try
      {      
        Connection con=null;
        PreparedStatement ps=null;
        con=OnlineConnection.getConnection();
        String sql;
        sql="delete from student where rollnum=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1, rno);
        n=ps.executeUpdate();
          if(n>0)
              return true;
          
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
      return false;
    }

    public boolean checkLogin(String user, String pass) {
        try{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        con=OnlineConnection.getConnection();
        String sql;
        sql="select * from login where username=? and password=?";
        ps=con.prepareStatement(sql);
        ps.setString(1, user);
        ps.setString(2, pass);
        rs=ps.executeQuery();
        if(rs.next())
           return true;
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

   return false;
    }

    public List<Student> searchAlldata() {
        List<Student> mylist=new ArrayList<Student>();
        try{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        con=OnlineConnection.getConnection();
        String sql;
        sql="select * from student";
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next())
        {
            Student s=new Student();
            s.setRno(rs.getInt(1));
            s.setName(rs.getString(2));
            s.setPhy(rs.getInt(3));
            s.setChem(rs.getInt(4));
            s.setMaths(rs.getInt(5));
            mylist.add(s);
            s=null;
            
        }
       
        }
        catch(Exception e)
        {
            System.out.println(e); 
        }
        return mylist;
    }
}