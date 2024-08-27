package JDBC;

import java.sql.*;

public class DeletingValues {

	static Connection connect;
	static Statement stat;
	static
	{
		 try
	     {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         //Creating the Connection
	         connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
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
	
	public static void updateTable() throws SQLException
	{ 
		stat = connect.createStatement(); 
		String val = "update student set pin = 508215 where name='manoj Kumar'";
		stat.executeQuery(val);
	}
	
	public static void deleteRow() throws SQLException
	{ 
		stat = connect.createStatement(); 
		//String val = "delete from  student where name='manoj Kumar'";
		String val = "delete from  student ";
		stat.executeQuery(val);
//		String delete = "delete from student where pin IN(123,1090)";
//		state.executeQuery(delete);
	}
	
	public static void main(String[] args) throws SQLException
	{
		//updateTable();
		deleteRow();
		
		
	}

}
