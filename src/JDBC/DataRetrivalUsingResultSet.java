package JDBC;
import java.sql.*;
import java.util.*;
class DataRetrivalUsingResultSet
{
    static Connection connect;
    static Statement state;
    static Scanner sc = new Scanner(System.in);
    static PreparedStatement pst;
     static  
    {
            //Registering the driver
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                //Creating the Connection
                connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
                state = connect.createStatement();
            }
            catch(ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            
            
    }
     public static void getdata() throws SQLException
     {
    	 ResultSet Rs = null;
    	  //String Query = "Select * from Student";
    	 String Query = "Select * from Student where pin= 500208";
    	  pst = connect.prepareStatement(Query);
    	  Rs = pst.executeQuery();
    	  while(Rs.next()) 
    	  {
    		  System.out.print(Rs.getString(1) + "    ");
    		  System.out.print(Rs.getString(2) + "    ");
    		  System.out.print(Rs.getString(3) + "    ");
    		  System.out.print(Rs.getInt(4) + "\n");
    	  }
    	  
     }
    
    public static void main(String args[]) throws SQLException
    {
    	getdata();
    }
}