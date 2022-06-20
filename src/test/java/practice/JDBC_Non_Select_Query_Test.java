package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC_Non_Select_Query_Test 
{

	public static void main(String[] args) throws Throwable 
	{
		Connection conn=null;
		int rs = 0;
		try
		{
			Driver d=new Driver();
			//step1:register to mysql database
			DriverManager.registerDriver(d);
			//step2: get connection with database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			//step3: create statement of query
			Statement stat = conn.createStatement();
			String query="insert into students_info values('6','gani','rasure','bidar')";
			//step4: execute the query
			rs=stat.executeUpdate(query);
		}
		catch(SQLException e)
		{
		}
		finally
		{
			//TODO: handle exception
			if(rs==1)
			{
				System.out.println("Row inserted succesfully");
			}
			else
			{
				System.out.println("Row is not inserted succesfully");
			}
			//step5: close the connection with database
			conn.close();
		}

	}

}
