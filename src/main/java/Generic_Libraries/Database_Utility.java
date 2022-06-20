package Generic_Libraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database_Utility 
{

	Connection conn;
	ResultSet rs;
	public void connectDatabase() throws SQLException
	{
		try
		{
			com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void closeDatabase() throws SQLException
	{
		try
		{
			conn.close();
		}
		catch(Exception e)
		{

		}
	}

	public ResultSet executeQuery(String query) throws SQLException
	{
		rs = conn.createStatement().executeQuery(query);
		return rs;
	}

	public int executeUpdate(String query) throws SQLException
	{
		int rs = conn.createStatement().executeUpdate(query);
		return rs;
	}

	/**
	 * This method will execute query based on query and it will verify the data. 
	 * @arun query
	 * @arun columnName
	 * @arun expectedData
	 * @return
	 * @throws Throwable
	 */
	public boolean executeQueryAndVerify(String query,int cloumnIndex,String expectedData) throws Throwable
	{
		boolean flag=false;
		rs=conn.createStatement().executeQuery(query);
		while(rs.next())
		{
			if(rs.getString(cloumnIndex).equals(expectedData)) 
			{
				flag=true;
				break;
			}
		}
		if(flag) 
		{
			System.out.println(expectedData+"==>Data is verified in the data base table");
			return flag;
		}
		else 
		{
			System.out.println(expectedData+"==>data is not verified in the database");
			return flag;
		}

	}



}








