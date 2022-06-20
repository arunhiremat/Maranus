package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Unit_Testing 
{
	public static void main(String[] args) throws SQLException 
	{
		String firstname="arun";
		Connection conn=null;
		try
		{
			Driver d=new Driver();
			DriverManager.registerDriver(d);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			Statement stat = conn.createStatement();
			String query="select* from students_info";
			ResultSet rs = stat.executeQuery(query);
			while(rs.next())
			{
				String actfirstname = rs.getString(2);
				if(actfirstname.equals(firstname))
				{
					System.out.println("it is matching");
				}
				 else
				{
					System.out.println("it is not matching");
				}
				
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			conn.close();
		}
	}
}
				
			
