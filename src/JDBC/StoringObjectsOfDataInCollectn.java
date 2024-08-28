package JDBC;
import java.sql.*;
import java.util.*;
class Student
{
	String Name; String Roll; String City; int Pin;
	Student(String Name, String Roll, String City, int Pin)
	{
		this.Name = Name;
		this.Roll = Roll;
		this.City = City;
		this.Pin = Pin;
	}
	
}
class StoringObjectsOfDataInCollectn 
{
    static Connection connect;
    static Statement state;
    static PreparedStatement pst;
    static HashSet<Student> hs = new HashSet<Student>();

     static                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    {
            //Registering the driver
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                //Creating the Connection
                connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
                
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
   	  String Query = "Select * from Student";
   	  pst = connect.prepareStatement(Query);
   	  Rs = pst.executeQuery();
   	  
   	while(Rs.next()) 
	  {
   		Student obj = new Student(Rs.getString(1) ,Rs.getString(2) ,Rs.getString(3) ,Rs.getInt(4));
		  hs.add(obj);
	  }
    }
    public static void main(String args[]) throws SQLException
    {
        // Arrays.sort(arr, Collections.reverseOrder());
       getdata();
       ArrayList<Student> al = new ArrayList<Student>(hs);
       al.sort(Comparator.comparing(Student->Student.Pin));
      // Collections.reverse(al);
       
       for(Student i : al) 
       {
    	   System.out.print(i.Name+" ");
	       System.out.print(i.Roll+" ");
	       System.out.print(i.City+" ");
	       System.out.println(i.Pin);
    	   
       }
    }
}