package MovieReviewApplication;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Rater{

    static int set=0;
    public static void rater(String uname,String movi,String type)
    {
        JFrame f=new JFrame();
        f.getContentPane().setBackground(Color.BLACK);
        f.getContentPane().setForeground(Color.BLACK);
        f.setTitle("Add reviews-->");

        JLabel l_name=new JLabel("Name : "+movi);
        l_name.setBackground(Color.BLACK);
        l_name.setForeground(Color.RED);
        JLabel l_rate=new JLabel("Your Rating : ");
        l_rate.setBackground(Color.BLACK);
        l_rate.setForeground(Color.RED);
        JLabel l_review=new JLabel("Add review : ");
        l_review.setBackground(Color.BLACK);
        l_review.setForeground(Color.RED);
        JButton b_rate=new JButton("Rate");
        b_rate.setBackground(Color.BLACK);
        b_rate.setForeground(Color.RED);
        JTextArea t_area=new JTextArea();
        Label l_msg=new Label();
        l_msg.setBackground(Color.BLACK);
        l_msg.setForeground(Color.RED);
        CheckboxGroup cbg=new CheckboxGroup();
        Checkbox c_1=new Checkbox("1", cbg,false);
        c_1.setBackground(Color.BLACK);
        c_1.setForeground(Color.RED);
        Checkbox c_2=new Checkbox("2", cbg,false);
        c_2.setBackground(Color.BLACK);
        c_2.setForeground(Color.RED);
        Checkbox c_3=new Checkbox("3", cbg,false);
        c_3.setBackground(Color.BLACK);
        c_3.setForeground(Color.RED);
        Checkbox c_4=new Checkbox("4", cbg,false);
        c_4.setBackground(Color.BLACK);
        c_4.setForeground(Color.RED);
        Checkbox c_5=new Checkbox("5", cbg,false);
        c_5.setBackground(Color.BLACK);
        c_5.setForeground(Color.RED);
        Checkbox cfav=new Checkbox("Liked this?");
        cfav.setBackground(Color.BLACK);
        cfav.setForeground(Color.RED);
        
        
        b_rate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String s1,s2,s3="no";
                if(set==0)
                {
                if((c_1.getState() || c_2.getState() || c_3.getState() || c_4.getState() || c_5.getState()))
                {
                    s1=cbg.getSelectedCheckbox().getLabel();
                    set++;
                }
                else
                {
                    s1="null";
                }
                s2=t_area.getText();
                
                if(cfav.getState())
                {
                    s3="yes";
                }
                
                if(s1.equals("null"))
                {
                    l_msg.setText("Add your rating");
                }
                else
                {

                    try
                    {
                    Connection c=GetConnection.getconnection();
                    String q="insert into "+uname+" values(?,?,?,?)";
                    PreparedStatement p=c.prepareStatement(q);
                    p.setString(1,movi);
                    p.setString(2,s1);
                    p.setString(3,s2);
                    p.setString(4,s3);
                    p.executeUpdate();
                    
                    double ratin=Integer.parseInt(s1);
                    if(type.equals("Movies"))
                    {
                    q="select * from movies";
                    }
                    else
                    {
                        q="select * from series";
                    }
                    p=c.prepareStatement(q);
                    ResultSet r=p.executeQuery();
                    while(r.next())
                    {
                        if(r.getString("Name").equals(movi))
                        {
                            int ratetill=Integer.parseInt(r.getString("Rating"));
                            int rateuser=Integer.parseInt(r.getString("Users"));
                            rateuser++;
                            ratetill+=ratin;
                            ratin=(float)ratetill/rateuser;
                            q="update movies set Rating=?, Users=?,Ratingyet=? where Name=?";
                            p=c.prepareStatement(q);

                            p.setInt(1, ratetill);
                            p.setInt(2, rateuser);
                            p.setDouble(3,ratin);
                            p.setString(4, movi);
                            p.executeUpdate();
                        }
                    }
                    }
                    catch(Exception e)
                    {
                        System.out.print("-->"+e);
                    }
                    l_msg.setText("Review added");
                    
                }
                }
                else
                {
                    l_msg.setText("Review already added");
                }
                
            }
        });
        
        f.setVisible(true);
        f.setLayout(null);
        f.setSize(400,300);
        
        l_name.setBounds(60, 20, 100,30);
        cfav.setBounds(190,20,100, 30);
        l_rate.setBounds(60, 60, 100,30);
        l_review.setBounds(60, 100, 100,30);
        t_area.setBounds(190, 100, 150,70);
        b_rate.setBounds(140, 210,100,30);
        l_msg.setBounds(140,180, 150,30);
        c_1.setBounds(190, 60,30,30);
        c_2.setBounds(220, 60, 30,30);
        c_3.setBounds(250, 60, 30,30);
        c_4.setBounds(280, 60, 30,30);
        c_5.setBounds(310, 60, 30,30);
        
        f.add(l_msg);
        f.add(l_name);
        f.add(l_rate);
        f.add(l_review);
        f.add(t_area);
        f.add(b_rate);
        f.add(c_1);
        f.add(c_2);
        f.add(c_3);
        f.add(c_4);
        f.add(c_5);
        f.add(cfav);
        
        
        
        int x,y;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        x  = (int) ((screenSize.getWidth() - f.getWidth()) / 2);
        y = (int) ((screenSize.getHeight() - f.getHeight()) / 2);
        f.setLocation(x, y);
        
    }
    
    public static void main(String args[])
    {
        rater("gowtham","theri","Movies");
    }
}

