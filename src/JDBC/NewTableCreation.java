package JDBC;
import java.sql.*;
//import java.util.Scanner;
public class NewTableCreation {
static Connection connect;

static
{
	 try
     {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         //Creating the Connection
         connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ManojKumarOracle","123");
             System.out.println("Connection Created:"+connect);
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

	public static void  createTable() throws SQLException
	{
		Statement stat = connect.createStatement(); 
		String Query = "create table student(Name varchar(20), RollNumber varchar(25), City varchar(15), Pin number(6))";
		stat.execute(Query);
	}

	public static void main(String[] args) throws SQLException
	
	{
		createTable();
	}

}
