package myconnection;
import java.sql.*;
public class OnlineConnection {
    
        static{
            try{
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("driver load done");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        public static Connection getConnection()
        {
           
            Connection con=null;
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online1","root","root");
                System.out.println("Connection done");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            return con;
        }
    
}
