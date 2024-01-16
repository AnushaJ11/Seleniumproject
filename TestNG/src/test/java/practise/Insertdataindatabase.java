package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Insertdataindatabase {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","anusha11J@");
		Statement state = conn.createStatement();
		String query = "insert into qspiders(first_name,last_name,address)values('khanna','Nag','Sweety')";
		int result = state.executeUpdate(query);
		if(result==1)
		{
			System.out.println("data is updated");
		}
		else
		{
			System.out.println("data is not updated");
		}
	}

}
