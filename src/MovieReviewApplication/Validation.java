package MovieReviewApplication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validation {
	public static String CommonUser(String s)
	{
		int set = 0;
		try
		{
			Connection c=GetConnection.getconnection();
			String q="select * from Register";
			PreparedStatement p=c.prepareStatement(q);
			ResultSet r=p.executeQuery();
			while(r.next())
			{
				if(r.getString("Username").equals(s))
				{
					set++;
				}
			}
					
		}
		catch(Exception e)
		{
			System.out.print("-->"+e);
		}
		if(set!=0)
		{
			return "Username already taken";
		}
		else
		{
			return "okay";	
		}
	}
	static boolean equal(String s1,String s2)
	{
		if(s1.equals(s2))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static String validate(String s,String s1,String s2,String s3,String s4)
	{
		if(s2.equals("none"))
		{
			if(s.length()==0 || s1.length()==0)
			{
				return "All fields should be entered";
			}
			else
			{
				return "okay";
			}
		}
		if(s.length()==0 || s1.length()==0 || s2.length()==0 || s3.length()==0 || s4.length()==0)
		{
			return "All fields should be entered";
		}
		else if((s1.length()<8 || s1.length()>16) &&(s2.length()<8 || s2.length()>16))
		{
			return "Password should be in the range 8-16 characters";
		}
		else if(equal(s1,s2))
		{
			return "Passwords doesnt match";
		}
		else if(!s1.matches(".*[0-9].*"))
		{
			if(!s1.matches(".*[a-z].*"))
			{
				if(!s1.matches(".*[A-Z].*"))
				{
					return "pass";
				}
				return "pass";
			}
			return "pass";
		}
		else if (!s4.matches("\\d{10}"))
		{
			return "Invalid Phone number";
		}
		else
		{
			return "okay";
		}
		
		
	}

}
