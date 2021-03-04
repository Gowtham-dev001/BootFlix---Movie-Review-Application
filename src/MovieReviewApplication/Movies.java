package MovieReviewApplication;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Movies{
    
	static int setin=0;
    public static void movies(String uname,String movi)
    {
        Font font_1=new Font("Calibri",Font.PLAIN,16);
        JFrame f=new JFrame();
        f.setTitle("Movies-->");
        f.setVisible(true);
        f.setLayout(null);
        f.setSize(600,500);

                String s=movi;
                JLabel lm=new JLabel();
                lm.setBackground(Color.BLACK);
                lm.setForeground(Color.red);
                
                JLabel la=new JLabel();
                la.setBackground(Color.BLACK);
                la.setForeground(Color.red);
                
                JLabel ldes=new JLabel();
                ldes.setBackground(Color.BLACK);
                ldes.setForeground(Color.red);
                
                JLabel ld =new JLabel();
                ld.setBackground(Color.BLACK);
                ld.setForeground(Color.red);
                
                JLabel lt=new JLabel();
                lt.setBackground(Color.BLACK);
                lt.setForeground(Color.red);
                
                JLabel lr=new JLabel();
                lr.setBackground(Color.BLACK);
                lr.setForeground(Color.red);
                
                JLabel lrun=new JLabel();
                lrun.setBackground(Color.BLACK);
                lrun.setForeground(Color.red);
                
                JButton b = new JButton("Watch");
                b.setBackground(Color.BLACK);
                b.setForeground(Color.red);
                
                JButton b1=new JButton("Rate the movie?");
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.red);
                
                JButton b2=new JButton("Ok");
                b2.setBackground(Color.BLACK);
                b2.setForeground(Color.red);
                
                JTextArea td=new JTextArea();
                td.setBackground(Color.BLACK);
                td.setForeground(Color.red);
                
                try
                {
                    Connection c=GetConnection.getconnection();
                    String q="select * from movies";
                    PreparedStatement p=c.prepareStatement(q);
                    ResultSet r=p.executeQuery();
                    while(r.next())
                    {
                        if(r.getString("Name").equals(s))
                        {
                            
                            lm.setText("Movie name : "+r.getString("Name"));
                            la.setText("Crew : "+r.getString("crew"));
                            ldes.setText("About :");
                            td.setText(r.getString("Description"));
                            ld.setText("Year : "+r.getString("Year"));
                            lrun.setText("Run time : "+r.getString("Runtime")+" mins");
                            
                            td.setLineWrap(true);
                            td.setWrapStyleWord(true);
                            
                            b.addActionListener(new ActionListener() {
                                
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                     try {
                                         String bs=r.getString("Trailer");
                                        Desktop.getDesktop().browse(new URL(bs).toURI());
                                    }
                                     catch(Exception e2)
                                     {
                                        System.out.print("-->"+e);
                                    }
                                    
                                }
                            });
                            lt=new JLabel("Missed the trailer...Find here:");
                            lt.setBackground(Color.BLACK);
                            lt.setForeground(Color.red);
                            
                            if(r.getString("Rating").equals("0"))
                            {
                                lr=new JLabel("Ratings yet : Nil");
                            }
                            else
                            {
                                if(r.getString("Ratingyet").length()>2)
                                {
                                    lr=new JLabel("Ratings yet : "+r.getString("Ratingyet").subSequence(0, 3));
                                }
                                else
                                {
                                lr=new JLabel("Ratings yet : "+r.getString("Ratingyet"));
                                }
                            }
                           lr.setBackground(Color.BLACK);
                           lr.setForeground(Color.red);
                          
                           
                           b1.addActionListener(new ActionListener() {
                                
                                @Override
                                public void actionPerformed(ActionEvent arg0) {
                                    
                                    try
                                    {
                                        Connection c=GetConnection.getconnection();
                                        String q="select * from "+uname;
                                        PreparedStatement p=c.prepareStatement(q);
                                        ResultSet r=p.executeQuery();
                                        int set=0;
                                        while(r.next())
                                        {
                                            if(r.getString("Name").equals(s))
                                                {
                                                    set++;
                                                    break;
                                                }
                                        }
                                        if(set!=0)
                                        {
                                        	setin++;
                                            Label lrn = new Label("You have already reviewed this movie");
                                            lrn.setBounds(200,400,250,30);
                                            f.add(lrn);
                                        }
                                        else
                                        {
                                            Rater.rater(uname,s,"Movies");
                                        }
                                    }
                                    catch(Exception e)
                                    {
                                        System.out.print("-->"+e);
                                    }
                                    
                                    
                                }
                            });
                            break;
                        }
                    }
                    
                    lm.setBounds(70,20,500,30);
                    la.setBounds(70,55,500,30);
                    ldes.setBounds(70,90,70,30);
                    td.setBounds(90,125,500, 60);
                    ld.setBounds(70,190,200,30);
                    lt.setBounds(70,225,200,30);
                    lr.setBounds(70,260,200,30);
                    lrun.setBounds(70,300,300,30);
                    b.setBounds(290,225,110,30);
                    b1.setBounds(70,340,140,30);
                    b2.setBounds(240,380,130,30);
                    
                    
                    f.add(lm);
                    f.add(la);
                    f.add(ldes);
                    f.add(td);
                    f.add(ld);
                    f.add(lt);
                    f.add(lr);    
                    f.add(b);
                    f.add(b1);
                    f.add(b2);
                    f.add(lrun);
                    
                    lm.setFont(font_1);
                    la.setFont(font_1);
                    ldes.setFont(font_1);
                    td.setFont(font_1);
                    ld.setFont(font_1);
                    lt.setFont(font_1);
                    lr.setFont(font_1);
                    lrun.setFont(font_1);
                    
                    
                }
                catch(Exception e1)
                {
                    System.out.print("-->"+e1);
                }    
        b2.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                
            }
        });
        
        f.getContentPane().setBackground(Color.BLACK);
        f.getContentPane().setForeground(Color.BLACK);
        
        int x,y;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        x  = (int) ((screenSize.getWidth() - f.getWidth()) / 2);
        y = (int) ((screenSize.getHeight() - f.getHeight()) / 2);
        f.setLocation(x, y);
    
    }
    
    public static void main(String args[])
    {
        movies("t","Guardians of the Galaxy Vol. 2 ");
    }

}
