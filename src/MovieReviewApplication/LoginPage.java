package MovieReviewApplication;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginPage{
	public static void loginpage()
	{
		Font font_1=new Font("Calibri",Font.PLAIN,16);
		Font font_2=new Font("SansSerif",Font.BOLD,26);
		JFrame f=new JFrame();
		f.setTitle("Login Window");
		f.setBackground(Color.black);
		f.getContentPane().setBackground(Color.BLACK);
		f.getContentPane().setForeground(Color.BLACK);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel l_wel=new JLabel("Welcome");
		l_wel.setBackground(Color.BLACK);
		l_wel.setForeground(Color.red);
		
		JLabel l_user=new JLabel("Username");
		l_user.setBackground(Color.BLACK);
		l_user.setForeground(Color.red);
		
		JLabel l_pass=new JLabel("Password");
		l_pass.setBackground(Color.BLACK);
		l_pass.setForeground(Color.red);
		
		JLabel l_msg=new JLabel();

		JTextField t_user=new JTextField();
		JTextField t_pass=new JTextField();
		
		JButton b_newuser=new JButton("New User?");
		b_newuser.setBackground(Color.BLACK);
		b_newuser.setForeground(Color.red);
		
		String url1="C:\\\\Users\\\\Gowtham\\\\Desktop\\\\Bootathonimg\\\\home.jpg";
        ImageIcon img1 = new ImageIcon(new ImageIcon(url1).getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT)); 
		JButton b_home=new JButton(img1);
		
		JButton b_login=new JButton("Login");
		b_login.setBackground(Color.BLACK);
		b_login.setForeground(Color.red);
		
		b_home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				Home.home();
				
			}
		});
		
		b_newuser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				RegistrationPage.register();
			}
		});
		b_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s=t_user.getText();
				String s1=t_pass.getText();
				String v=Validation.validate(s,s1,"none","","");
			    if(v.equals("okay"))
			    {
				try
				{
				Connection c=GetConnection.getconnection();
				String q="select * from Register";
				PreparedStatement p=c.prepareStatement(q);
				ResultSet r=p.executeQuery();
				int set=0;
				while(r.next())
				{
					if(s.equals(r.getString("Username")) && s1.equals(r.getString("Password")))
						{
							set++;
							break;
						}
				}
				if(set!=0)
				{
					l_msg.setText("Logged in");
					UserPage1.userpage1(s);
					f.dispose();
				}
				else
				{
					l_msg.setText("Username or Password not matched");
				}
				}
				catch(SQLException e)
				{
					System.out.print("--->"+e);
				}
			    }
			    else
			    {
			    	l_msg.setText(v);
			    }
			}
		});	
				
		f.setVisible(true);
		f.setSize(600,600);
		f.setLayout(null);
		
		l_wel.setBounds(240,90,150,30);
		l_user.setBounds(140,160,100,30);
		l_pass.setBounds(140,210,100,30);
		l_msg.setBounds(200,250,220,30);
		l_msg.setBackground(Color.BLACK);
		l_msg.setForeground(Color.red);
		l_user.setFont(font_1);
		l_pass.setFont(font_1);
		l_msg.setFont(font_1);
		l_wel.setFont(font_2);

		b_newuser.setBounds(240,330,110,30);
		b_login.setBounds(240,280,110,30);
		b_home.setBounds(10,10,30,30);
		b_newuser.setFont(font_1);
		b_login.setFont(font_1);
		
		t_user.setBounds(270,160,200,30);
		t_pass.setBounds(270,210,200,30);
		t_user.setFont(font_1);
		l_pass.setFont(font_1);

		f.add(b_home);
		f.add(b_newuser);
		f.add(l_wel);
		f.add(l_user);
		f.add(l_pass);
		f.add(t_user);
		f.add(t_pass);
		f.add(l_msg);
		f.add(b_login);
		
		int x,y;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        x  = (int) ((screenSize.getWidth() - f.getWidth()) / 2);
        y = (int) ((screenSize.getHeight() - f.getHeight()) / 2);
        f.setLocation(x, y);
        
	}
	public static void main(String args[])
	{
		loginpage();
	}

}
