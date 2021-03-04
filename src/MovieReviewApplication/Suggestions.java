package MovieReviewApplication;

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

public class Suggestions{

    static int set=0;
    public static void suggestions()
    {
        Font font_1=new Font("Calibri",Font.PLAIN,16);
        JFrame f=new JFrame();
        f.getContentPane().setBackground(Color.BLACK);
        f.getContentPane().setForeground(Color.BLACK);
        f.setTitle("User Suggestion-->");
        
        JTextField t_review=new JTextField();
        JLabel l_name=new JLabel("Name : ");
        l_name.setBackground(Color.BLACK);
        l_name.setForeground(Color.RED);
        JLabel l_type=new JLabel("Type : ");
        l_type.setBackground(Color.BLACK);
        l_type.setForeground(Color.RED);
        JButton b_add=new JButton("Add");
        b_add.setBackground(Color.BLACK);
        b_add.setForeground(Color.RED);
        JLabel l_msg=new JLabel();
        l_msg.setBackground(Color.BLACK);
        l_msg.setForeground(Color.RED);
        JTextField l_type1=new JTextField();
        
        
        l_name.setFont(font_1);
        l_type.setFont(font_1);
        l_msg.setFont(font_1);
        l_type1.setFont(font_1);
        b_add.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
    
                String s1=l_type1.getText(),s2=t_review.getText();
                if(s1.length()==0 || s2.length()==0)
                {
                    l_msg.setText("All fields should be filled");
                }
                else
                {
                    set++;
                    try
                    {
                        Connection con=GetConnection.getconnection();
                        String q1="select * from suggestions";
                        PreparedStatement p1=con.prepareStatement(q1);
                        ResultSet r=p1.executeQuery(q1);
                        int set1=0;
                        while(r.next())
                        {
                            if(r.getString("Name").equals(s2) && r.getString("Type").equals(s1))
                            {
                                set1++;
                                l_msg.setText(s2+" is already suggested");
                            }
                        }
                      
                        String q2="select * from "+s1;
                        PreparedStatement p2=con.prepareStatement(q1);
                        ResultSet r2=p2.executeQuery(q2);
                        int set2=0;
                        while(r2.next())
                        {
                            if(r2.getString("Name").equals(s2))
                            {
                                set2++;
                                l_msg.setText("Already in Database");
                            }
                        }
                        if(set1==0 && set2==0)
                        {
                        String q="insert into suggestions values(?,?)";
                        PreparedStatement p=con.prepareStatement(q);
                        p.setString(1,s2);
                        p.setString(2,s1);
                        p.executeUpdate();
                        l_msg.setText("Thankyou for the suggesstion");
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.print("-->"+e);
                    }
                    
                }
                }
                
        });
        f.setVisible(true);
        f.setLayout(null);
        f.setSize(300,300);
        
        l_name.setBounds(50,50,70,30);
        l_type.setBounds(50,110,70,30);
        t_review.setBounds(140,50, 100, 30);
        l_type1.setBounds(140,110,100,30);
        b_add.setBounds(110,180,70,30);
        l_msg.setBounds(80,150,200,30);
        
        f.add(b_add);
        f.add(l_name);
        f.add(l_type);
        f.add(l_msg);
        f.add(t_review);
        f.add(l_type1);
             
        int x,y;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        x  = (int) ((screenSize.getWidth() - f.getWidth()) / 2);
        y = (int) ((screenSize.getHeight() - f.getHeight()) / 2);
        f.setLocation(x, y);
    }
    public static void main(String args[])
    {
        suggestions();
    }
}
