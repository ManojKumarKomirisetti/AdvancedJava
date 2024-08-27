package JDBC;
import java.sql.*;
import java.util.*;
class PreparedStatementsEx
{
    static Connection connect;
    static Statement state;
    static Scanner sc = new Scanner(System.in);

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
    public static void prepareStatUsage() throws SQLException
    {
    	String Query = "insert into student values"+"(?,?,?,?)";
    	PreparedStatement pst = connect.prepareStatement(Query);
        		
    	
    	for(int j =0; j<3;j++)
    	{
    		 
    	        
    	        System.out.println("Enter Customer Name:");
    	        String name = sc.nextLine();
    	        
    	        System.out.println("Enter Customer RollNumber:");
    	        String RollNumber = sc.nextLine();
    	        
    	        System.out.println("Enter Customer City:");
    	        String city = sc.nextLine();
    	        
    	        System.out.println("Enter Customer Pin:");
    	        int pin = sc.nextInt();
    	        sc.nextLine();
    	        
    	        pst.setString(1, name);
    	        pst.setString(2, RollNumber);
    	        pst.setString(3, city);
    	        pst.setInt(4, pin);
    	        int i = pst.executeUpdate();
        		System.out.println("Added Successfully! and Records Updated::"+i);
    	        
    	}
    	sc.close();
    	
        	
    		
    		
    }
    public static void main(String args[]) throws SQLException
    {
    	prepareStatUsage();
    }
}