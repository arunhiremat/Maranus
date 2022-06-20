package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC_Select_Query_Test 
{
	public static void main(String[] args) throws Throwable
	{
		Connection conn=null;
		try 
		{
		Driver driverref=new Driver();
		
		//register to the database
		DriverManager.registerDriver(driverref);
		
		//get the connection
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		//create the queries
		Statement stat = conn.createStatement();
		String query="select *from students_info";
		
		//execute the queries
		ResultSet resultset = stat.executeQuery(query);
		while(resultset.next())
		{
			System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
		}
		}
		catch(Exception e )
		{
		}
		finally
		{
			//close the connection
			conn.close();
		}
	}
}

		
		
