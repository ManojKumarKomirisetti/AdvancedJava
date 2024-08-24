package JDBC;
import java.sql.*;
import java.util.*;
class InsertingValueIntoBank
{
    static Connection con;

    public static Connection getConnection() 
    {
            //Registering the driver
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                //Creating the Connection
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
                
            }
            catch(ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            
            	return con;
    }
    public static void insertValue(String name, String accountNumber, double balance)
    {
    		try
    		{
    			Connection connect = getConnection();
        		Statement state = connect.createStatement();
        		String detailsUpdate = "insert into ByteCode_Bank values('"+name+"','"+accountNumber+"',"+balance+")";
        		state.executeUpdate(detailsUpdate);
        		System.out.println("Added Successfully!");
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    		}
    }
    public static void main(String args[]) 
    {
        
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Customer Name:");
        String name = sc.nextLine();
        
        System.out.println("Enter Customer AccountNumber:");
        String accountNumber = sc.nextLine();
        
        System.out.println("Enter Customer Initial Balance:");
        double balance = sc.nextDouble();
        
        
        sc.close();
        
        insertValue( name, accountNumber,  balance);
    }
}