package MovieReviewApplication;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class RegistrationPage{
    
    public static void register()
    {
        Font font_1=new Font("Calibri",Font.PLAIN,16);
        Font font_2=new Font("SanSerif",Font.BOLD,20);
        JFrame f=new JFrame(); 
        f.getContentPane().setBackground(Color.BLACK);
        f.getContentPane().setForeground(Color.BLACK);
        f.setTitle("Registrartion form");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel l_reg=new JLabel("Registration Form");
        l_reg.setBackground(Color.BLACK);
        l_reg.setForeground(Color.red);
        JLabel l_user=new JLabel("Username");
        l_user.setBackground(Color.BLACK);
        l_user.setForeground(Color.red);
        JLabel l_pass=new JLabel("Password");
        l_pass.setBackground(Color.BLACK);
        l_pass.setForeground(Color.red);
        JLabel l_retype=new JLabel("Re-type Password");
        l_retype.setBackground(Color.BLACK);
        l_retype.setForeground(Color.red);
        JLabel l_phno=new JLabel("Ph.no");
        l_phno.setBackground(Color.BLACK);
        l_phno.setForeground(Color.red);
        JLabel l_mail=new JLabel("Mail id");
        l_mail.setBackground(Color.BLACK);
        l_mail.setForeground(Color.red);
        JLabel l_msg=new JLabel();
        
        JTextField t_user=new JTextField();
        JTextField t_pass=new JTextField();
        JTextField t_retype=new JTextField();
        JTextField t_phno=new JTextField();
        JTextField t_mail=new JTextField();
        
        JButton b_reg=new JButton("Register");
        b_reg.setBackground(Color.BLACK);
        b_reg.setForeground(Color.red);
        
        JButton close=new JButton("Close");
	    close.setBackground(Color.BLACK);
	    close.setForeground(Color.RED);
		
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				LoginPage.loginpage();
				
			}
		});
        
        b_reg.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                    String s1=t_user.getText(),s2=t_pass.getText(),s3=t_retype.getText(),s5=t_phno.getText();
                    String s4=t_mail.getText();
                    String v=Validation.validate(s1,s2,s3,s4,s5);
                    String v1=Validation.CommonUser(s1);
                    if(v1.equals("okay"))
                    {
                        if(v.equals("okay"))
                        {
                        try
                        {
                        long phno=Long.parseLong(s5);
                        Connection c=GetConnection.getconnection();
                        String q="insert into register values(?,?,?,?)";
                        PreparedStatement p=c.prepareStatement(q);
                        p.setString(1,s1);
                        p.setString(2,s2);
                        p.setLong(3,phno);
                        p.setString(4,s4);
                        p.executeUpdate();
                        
                        String q1="create table "+s1+"(Name varchar(100),Rating Integer,Review varchar(200),Favo varchar(200))";
                        p.execute(q1);
                        c.close();
                        l_msg.setText("Registered Successfully");
                        LoginPage.loginpage();
                        f.dispose();
                        }
                        catch(Exception e1)
                        {
                            System.out.print("--->"+e1);
                        }
                        }
                        else if(v.equals("pass"))
                        {
                            l_msg.setText("Password should be a combination of Uppercase,lowercase letters & numbers");
                            l_msg.setBounds(80,390,500,30);
                        }
                        else
                        {
                            l_msg.setBounds(185,400,270,30);
                            l_msg.setText(v);
                        }
                        }  
                else
                {
                    l_msg.setText(v1);
                }
            }
            
            
        });
        
        f.setSize(600, 600);
        f.setVisible(true);
        f.setLayout(null);
        
        l_reg.setBounds(210,80,200,30);
        l_user.setBounds(130,150,100,30);
        l_pass.setBounds(130,190,100,30);
        l_retype.setBounds(130, 230, 150, 30);
        l_phno.setBounds(130, 270, 100, 30);
        l_mail.setBounds(130, 310, 100, 30);
        l_msg.setBounds(165,400,270,30);
        l_msg.setBackground(Color.BLACK);
		l_msg.setForeground(Color.red);
		

        l_reg.setFont(font_2);
        l_user.setFont(font_1);
        l_pass.setFont(font_1);
        l_retype.setFont(font_1);
        l_phno.setFont(font_1);
        l_mail.setFont(font_1);
        l_msg.setFont(font_1);
        
        t_user.setBounds(290, 150, 200, 30);
        t_pass.setBounds(290, 190,200, 30);
        t_retype.setBounds(290, 230, 200, 30);
        t_phno.setBounds(290, 270, 200, 30);
        t_mail.setBounds(290,310,200,30);
        
        t_user.setFont(font_1);
        t_pass.setFont(font_1);
        t_retype.setFont(font_1);
        t_phno.setFont(font_1);
        t_mail.setFont(font_1);

        close.setBounds(230,415,100,30);
        b_reg.setBounds(230,370,100, 30);
        b_reg.setFont(font_1);
        
        f.add(l_reg);
        f.add(l_user);
        f.add(l_pass);
        f.add(l_retype);
        f.add(l_phno);
        f.add(l_mail);
        f.add(t_user);
        f.add(t_pass);
        f.add(t_retype);
        f.add(t_phno);
        f.add(t_mail);
        f.add(b_reg);
        f.add(l_msg);
        f.add(close);
        
        int x,y;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        x  = (int) ((screenSize.getWidth() - f.getWidth()) / 2);
        y = (int) ((screenSize.getHeight() - f.getHeight()) / 2);
        f.setLocation(x, y);
    }
    public static void main(String args[])
    {
        register();
    }
}
