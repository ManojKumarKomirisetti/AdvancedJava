package JDBC;
import java.sql.*;
class JdbcTableCreation
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
                   // System.out.println("Connection Created:"+con);

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
    public static void createTable()
    {
    		try
    		{
    			Connection connect = getConnection();
        		Statement state = connect.createStatement();
        		String createTbl = "create table ByteCode_Bank( Name varchar2(25),AccountNumber varchar2(15), Balance number )";
        		state.execute(createTbl);
        		
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    		}
    }
    public static void main(String args[]) 
    {
       createTable();
    }
}