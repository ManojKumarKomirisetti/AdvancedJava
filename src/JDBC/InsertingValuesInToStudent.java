package JDBC;

import java.sql.*;

public class InsertingValuesInToStudent {

	static Connection connect;
	static Statement stat;
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
	public static void insertion() throws SQLException
	{
		stat = connect.createStatement(); 
		String val = "insert into student values ('Manoj Kumar','1090','Hyderabad',508213)";
		stat.executeQuery(val);
	}
	public static void updateTable() throws SQLException
	{ 
		stat = connect.createStatement(); 
		String val = "update student set pin = 508209 where rollnumber=1263";
		stat.executeQuery(val);
	}
	
	public static void main(String[] args) throws SQLException
	{
		//insertion();
		updateTable();
		
	}

}
