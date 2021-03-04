package MovieReviewApplication;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditUser {

	public static void edituser()
	{
		JFrame f=new JFrame("Edit users");
		f.getContentPane().setBackground(Color.BLACK);
		f.getContentPane().setForeground(Color.BLACK);
		f.setSize(350,350);
		f.setLayout(null);
		JLabel l_name=new JLabel("User name");
		l_name.setBackground(Color.BLACK);
		l_name.setForeground(Color.RED);
		JLabel l_pass=new JLabel("Password");
		l_pass.setBackground(Color.BLACK);
		l_pass.setForeground(Color.RED);
		JLabel l_phno=new JLabel("Phone no");
		l_phno.setBackground(Color.BLACK);
		l_phno.setForeground(Color.RED);
		JLabel l_mail=new JLabel("Mail id");
		l_mail.setBackground(Color.BLACK);
		l_mail.setForeground(Color.RED);
		JLabel l_msg=new JLabel();
		l_msg.setBackground(Color.BLACK);
		l_msg.setForeground(Color.RED);
		JButton b_update=new JButton("Update");
		b_update.setBackground(Color.BLACK);
		b_update.setForeground(Color.RED);
		JTextField t_name=new JTextField();
		JTextField t_pass=new JTextField();
		JTextField t_phno=new JTextField();
		JTextField t_mail=new JTextField();
		
		JButton close=new JButton("Close");
	    close.setBackground(Color.BLACK);
	    close.setForeground(Color.RED);
		
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new UserDatabase();
				
			}
		});
		
		b_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int set=0;
				String s1=t_name.getText(),s2=t_pass.getText(),s3=t_pass.getText(),s5=t_phno.getText();
                String s4=t_mail.getText();
                String v=Validation.validate(s1,s2,s3,s4,s5);
                if(v.equals("okay"))
                {
				try
				{
					long phno=Long.parseLong(s5);
					Connection c=GetConnection.getconnection();
					String q1="select * from register";
					PreparedStatement p=c.prepareStatement(q1);
					ResultSet r=p.executeQuery(q1);
					set=0;
					while(r.next())
					{
						if(r.getString("Username").equalsIgnoreCase(t_name.getText()))
						{
							String q="update register set Username = ?,Password=?,Ph_num =?,Mail_id=? where Username = ?";
							PreparedStatement p1=c.prepareStatement(q);
							p1.setString(1, t_name.getText());
							p1.setString(2, t_pass.getText());
							p1.setLong(3, phno);
							p1.setString(4, t_mail.getText());
							p1.setString(5, r.getString("Username"));
							p1.executeUpdate();
							set++;
							break;
						}
						
					}
					
				}
				catch(Exception e1)
				{
					System.out.print("-->"+e1);
				}
				if(set==0)
				{
					l_msg.setText("No user found");
				}
				else
				{
					l_msg.setText("Successfully updated");
				}
                }
                else
                {
                	l_msg.setText(v);
                }
				
			}
		});
		
		l_name.setBounds(50,30,100,30);
		t_name.setBounds(160,30,140,30);
		l_pass.setBounds(50,70,100,30);
		t_pass.setBounds(160,70,140,30);
		l_phno.setBounds(50,110,100,30);
		t_phno.setBounds(160,110,140,30);
		l_mail.setBounds(50,150,100,30);
		t_mail.setBounds(160,150,140,30);
		b_update.setBounds(110,220,80,30);
		l_msg.setBounds(90,190,300,30);
		close.setBounds(110,260,80,30);
		
		f.add(l_name);
		f.add(l_pass);
		f.add(l_phno);
		f.add(l_mail);
		f.add(t_name);
		f.add(t_pass);
		f.add(t_phno);
		f.add(t_mail);
		f.add(b_update);
		f.add(l_msg);
		f.add(close);
		
		f.setVisible(true);
		
		int x,y;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        x  = (int) ((screenSize.getWidth() - f.getWidth()) / 2);
        y = (int) ((screenSize.getHeight() - f.getHeight()) / 2);
        f.setLocation(x, y);
		
	}
	public static void main(String args[])
	{
		edituser();
	}
}
