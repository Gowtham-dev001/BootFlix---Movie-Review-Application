package MovieReviewApplication;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {

	public static Connection getconnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/bootathon","Gowtham","123456");
		}
		catch(Exception e)
		{
			System.out.print("-->"+e);
		}
		return con;
	}
}
