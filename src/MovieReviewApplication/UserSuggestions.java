package MovieReviewApplication;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;

public class UserSuggestions {

	 private static Dialog d;
	public static void usersuggestions()
	{
		Font font_1=new Font("Calibri",Font.PLAIN,14);
        JFrame f= new JFrame();
        d = new Dialog(f , "MOVIE DATABASE", true);
        d.setBackground(Color.BLACK);
		d.setForeground(Color.RED);
		d.setSize(300,400);
		d.setLayout(null);
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
            String q="select * from suggestions";
            PreparedStatement p=c.prepareStatement(q);
            ResultSet r=p.executeQuery();
            while(r.next())
            {
                    list_fav.add("-> "+r.getString("Name"));
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
                new UserDatabase();
                
            }
        });
        
        b_ok.setBounds(110,335,75,30);
        list_fav.setBounds(50,40,180,290);
        list_fav.setFont(font_1);
        b_ok.setFont(font_1);
        d.add(list_fav);
        d.add(b_ok);
        
        int x,y;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        x  = (int) ((screenSize.getWidth() - d.getWidth()) / 2);
        y = (int) ((screenSize.getHeight() - d.getHeight()) / 2);
        d.setLocation(x, y);
        d.setVisible(true);
	}
	public static void main(String args[])
	{
		usersuggestions();
	}
}
