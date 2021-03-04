package MovieReviewApplication;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

public class DeleteUser {

	public static void deleteuser()
	{
    	Font font_1=new Font("Calibri",Font.PLAIN,16);
		JFrame f=new JFrame("Delete Users");
		f.getContentPane().setBackground(Color.BLACK);
		f.getContentPane().setForeground(Color.BLACK);
		f.setSize(300, 250);
		f.setLayout(null);
		JLabel l_name=new JLabel("User name");
		l_name.setBackground(Color.BLACK);
		l_name.setForeground(Color.RED);
		JButton b_delete=new JButton("Delete");
		b_delete.setBackground(Color.BLACK);
		b_delete.setForeground(Color.RED);
		JTextField t_name=new JTextField();
		JLabel l_msg=new JLabel();
		l_msg.setBackground(Color.BLACK);
		l_msg.setForeground(Color.RED);
		
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
		
		b_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(t_name.getText().length()==0)
				{
					l_msg.setText("Enter username");
				}
				else
				{
				try
				{
					Connection c=GetConnection.getconnection();
					String q1="select * from register";
					PreparedStatement p=c.prepareStatement(q1);
					ResultSet r=p.executeQuery(q1);
					int set=0;
					while(r.next())
					{
						if(r.getString("Username").equalsIgnoreCase(t_name.getText()))
						{
							String q="delete from register where Username = ?";
							PreparedStatement p1=c.prepareStatement(q);
							p1.setString(1, t_name.getText());
							p1.executeUpdate();
							set++;
							q="drop table "+r.getString("Username");
							p1=c.prepareStatement(q);
							p1.executeUpdate();
							break;
						}
						
					}
					if(set==0)
					{
						l_msg.setText("No user found");
					}
					else
					{
						l_msg.setText("Successfully deleted");
					}
				}
				catch(Exception e1)
				{
					System.out.print("--->"+e1);
				}
				}
			}
		});
		
		l_name.setBounds(50,30,100,30);
		t_name.setBounds(160,30,100,30);
		l_msg.setBounds(90,80,200,30);
		b_delete.setBounds(110,125,100,30);
		close.setBounds(110,170,100,30);
		
		f.add(l_name);
		f.add(l_msg);
		f.add(t_name);
		f.add(b_delete);
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
		deleteuser();
	}
}