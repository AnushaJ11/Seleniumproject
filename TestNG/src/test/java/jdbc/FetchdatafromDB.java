package jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;



import com.mysql.jdbc.Driver;

public class FetchdatafromDB {

	public static void main(String[] args) throws Throwable  {
		// TODO Auto-generated method stub
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","anusha11J@");
		Statement state = conn.createStatement();
		String query = "Select * from qspiders";
		ResultSet result = state.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
			
		}
		conn.close();
	}

}
