package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Non_Select_Query 
{
	public static void main(String[] args) throws Throwable
	{
		Connection conn=null;
		try
		{
			Driver d=new Driver();
			//step1:register to  database
			DriverManager.registerDriver(d);
			//step2: get connection with database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			//step3: create statement of query
			Statement stat = conn.createStatement();
			String query="insert into department values('30','PSI')";
			String query1="insert into department values('40','HOD')";
			//step4: execute the query
			stat.executeUpdate(query);
			stat.executeUpdate(query1);
		}
		catch(SQLException e)
		{
		}
		finally
		{
			//step5: close the connection
			conn.close();
		}
	}
}






