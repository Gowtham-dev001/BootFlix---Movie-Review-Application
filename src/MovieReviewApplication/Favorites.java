package MovieReviewApplication;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Favorites extends WindowAdapter{

    static Frame f=new Frame();

    public static void favorites(String s)
    {
		Font font_1=new Font("Calibri",Font.PLAIN,14);
        f.setTitle("Favorites-->");
        
        List list_fav=new List(25);
        list_fav.setBackground(Color.BLACK);
        list_fav.setForeground(Color.red);
        Button b_ok=new Button("Ok");
        b_ok.setBackground(Color.BLACK);
        b_ok.setForeground(Color.red);
        Label l_msg=new Label("");
        l_msg.setBackground(Color.BLACK);
        l_msg.setForeground(Color.red);
        
        try
        {
            Connection c=GetConnection.getconnection();
            String q="select * from "+s;
            PreparedStatement p=c.prepareStatement(q);
            ResultSet r=p.executeQuery();
            int set=0;
            while(r.next())
            {
                if(r.getString("Favo").equals("yes"))
                {
                    set++;
                    list_fav.add("-> "+r.getString("Name"));
                }
            }
            if(set!=0)
            {
                list_fav.setBounds(80,50, 150,250);
                l_msg.setText("Your favorites : ");
            }
            else
            {
                l_msg.setBounds(30,40,150,10);
                f.add(l_msg);
            }
        }
        catch(Exception e1)
        {
            System.out.print("-->"+e1);
        }
        
        b_ok.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                
            }
        });
        
        f.setVisible(true);
        f.setLayout(null);
        f.setSize(300,400);

        f.addWindowListener(new Favorites());
        b_ok.setBounds(110,335,75,30);
        list_fav.setBounds(70,40,150,290);
        f.setBackground(Color.BLACK);
        list_fav.setFont(font_1);
        b_ok.setFont(font_1);
        f.add(list_fav);
        f.add(b_ok);
        
        int x,y;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        x  = (int) ((screenSize.getWidth() - f.getWidth()) / 2);
        y = (int) ((screenSize.getHeight() - f.getHeight()) / 2);
        f.setLocation(x, y);
    }
    
    public void windowClosing(WindowEvent e)
    {
        f.dispose();
    }
    
    public static void main(String args[])
    {
        favorites("Gowtham");
    }
}

