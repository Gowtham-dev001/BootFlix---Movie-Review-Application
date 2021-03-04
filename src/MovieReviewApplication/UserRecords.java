package MovieReviewApplication;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserRecords{

    
    public static void userrecords(String uname)
    {
        Font font_1=new Font("Calibri",Font.PLAIN,16);
        JFrame f=new JFrame();
        
        f.getContentPane().setBackground(Color.BLACK);
        f.getContentPane().setForeground(Color.BLACK);
        
        Choice choice=new Choice();
        choice.setBackground(Color.BLACK);
        choice.setForeground(Color.RED);
       
        JButton b_go=new JButton("Go");
        b_go.setBackground(Color.BLACK);
        b_go.setForeground(Color.RED);
       
        JLabel l_select=new JLabel("Select-->");
        l_select.setBackground(Color.BLACK);
        l_select.setForeground(Color.RED);
       
        JButton b_ok=new JButton("Ok");
        b_ok.setBackground(Color.BLACK);
        b_ok.setForeground(Color.RED);
       
        f.setTitle(uname+"'s Records-->");
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(400,400);
        int set=0;
        try
        {
            Connection c=GetConnection.getconnection();
            String q="select * from "+uname;
            PreparedStatement p=c.prepareStatement(q);
            ResultSet r=p.executeQuery();
            
            while(r.next())
            {
                set++;
                choice.add(r.getString("Name"));
            }
        }
        catch(Exception e)
        {
            System.out.print("-->"+e);
        }
        
        if(set!=0)
        {
        b_go.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
            	String sel=choice.getSelectedItem().toString();
                Label l1=new Label("Name :");
                l1.setBackground(Color.BLACK);
                l1.setForeground(Color.RED);
                Label l2=new Label("Rating :");
                l2.setBackground(Color.BLACK);
                l2.setForeground(Color.RED);
                Label l3=new Label("Review :");
                l3.setBackground(Color.BLACK);
                l3.setForeground(Color.RED);
                Label l4=new Label("Favorite :");
                l4.setBackground(Color.BLACK);
                l4.setForeground(Color.RED);
                Label l5=new Label();
                l5.setBackground(Color.BLACK);
                l5.setForeground(Color.RED);
                Label l6=new Label();
                l6.setBackground(Color.BLACK);
                l6.setForeground(Color.RED);
                Label l7=new Label();
                l7.setBackground(Color.BLACK);
                l7.setForeground(Color.RED);
                Label l8=new Label();
                l8.setBackground(Color.BLACK);
                l8.setForeground(Color.RED);
                
                try
                {
                    Connection c=GetConnection.getconnection();
                    String q="select * from "+uname;
                    PreparedStatement p=c.prepareStatement(q);
                    ResultSet r=p.executeQuery();
                    int set=0;
                    while(r.next())
                    {
                        if(r.getString("name").equals(sel))
                        {
                            set++;
                            l5.setText(r.getString("Name"));
                            l6.setText(r.getString("Rating"));
                            l7.setText(r.getString("Review"));
                            l8.setText(r.getString("Favo"));
                            
                        }
                        
                    }
                    if(set==0)
                    {
                        l1.setText("No records found");
                        l1.setBounds(160,120,100,30);
                        l1.setBackground(Color.LIGHT_GRAY);
                        f.add(l1);
                    }
                    else
                    {
                        l1.setBounds(70,130,100,30);
                        l2.setBounds(70,160,100,30);
                        l3.setBounds(70,190,100,30);
                        l4.setBounds(70,220,100,30);
                        l5.setBounds(180,130,200,30);
                        l6.setBounds(180,160,200,30);
                        l7.setBounds(180,190,200,30);
                        l8.setBounds(180,220,200,30);
                        
                        f.add(l1);
                        f.add(l2);
                        f.add(l3);
                        f.add(l4);
                        f.add(l5);
                        f.add(l6);
                        f.add(l7);
                        f.add(l8);

                    }
                }
                catch(Exception e1)
                {
                    System.out.print("-->"+e1);
                }
                }
            });
        
        f.add(l_select);
        f.add(choice);
        f.add(b_go);
        
        l_select.setBounds(110,40,90,30);
        l_select.setFont(font_1);
        choice.setBounds(210, 45, 100,30);
        b_go.setBounds(190,80,50,30);
        
        
        }
        b_ok.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                
            }
        });
        
        
        b_ok.setBounds(160,310,80,30);
        f.add(b_ok);
        
        int x,y;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        x  = (int) ((screenSize.getWidth() - f.getWidth()) / 2);
        y = (int) ((screenSize.getHeight() - f.getHeight()) / 2);
        f.setLocation(x, y);
        
        
    }
    
    public static void main(String args[])
    {
        userrecords("t");
    }
    
}

