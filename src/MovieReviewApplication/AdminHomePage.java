package MovieReviewApplication;

import java.awt.*;  
import javax.swing.JFrame;  
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AdminHomePage{  
    private static Dialog d;  
    AdminHomePage() {  
    	Font font_1=new Font("Calibri",Font.PLAIN,16);
    	JFrame f= new JFrame();
        f.getContentPane().setBackground(Color.BLACK);
		f.getContentPane().setForeground(Color.BLACK);
        d = new Dialog(f , "WELCOME ADMIN", true);  
        d.setBackground(Color.BLACK);
		d.setForeground(Color.RED);
        d.setLayout(null);  
        Button b1 = new Button ("->");  
        b1.setBackground(Color.BLACK);
		b1.setForeground(Color.RED);
        b1.setBounds(250,110,50,25);
        b1.setFont(font_1);
        Button b2 = new Button ("->");
        b2.setBounds(250,160,50,25);
        b2.setBackground(Color.BLACK);
		b2.setForeground(Color.RED);
		b2.setFont(font_1);
        Button b3 = new Button ("->");
        b3.setBounds(250,210,50,25);
        b3.setBackground(Color.BLACK);
		b3.setForeground(Color.RED);
		b3.setFont(font_1);
		
		Button close=new Button("Close");
		close.setBounds(160,300,90,30);
	    close.setBackground(Color.BLACK);
	    close.setForeground(Color.RED);
		close.setFont(font_1);
		
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminHomePage.d.setVisible(false); 
				new AdminLogin();
				
			}
		});
		
        b1.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
            	AdminHomePage.d.setVisible(false); 
            	MovieDataBase.main(null);
            }  
        });  
        b2.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
            	AdminHomePage.d.setVisible(false);  
            	SeriesDatabase.main(null);
            }  
        });  
        b3.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
            	AdminHomePage.d.setVisible(false);  
            	UserDatabase.main(null);
            }  
        });
        Label l1=new Label ("Movie Database");
        l1.setBounds(70,100,130,50);
        l1.setFont(font_1);
        l1.setBackground(Color.BLACK);
		l1.setForeground(Color.RED);
        Label l2=new Label ("Series Database");
        l2.setBounds(70,150,130,50);
        l2.setFont(font_1);
        l2.setBackground(Color.BLACK);
		l2.setForeground(Color.RED);
        Label l3=new Label ("User Database");
        l3.setBounds(70,200,130,50);
        l3.setFont(font_1);
        l3.setBackground(Color.BLACK);
		l3.setForeground(Color.RED);
        d.add(l1);  
        d.add(b1);   
        d.add(l2);
        d.add(b2);
        d.add(l3);
        d.add(b3);
        d.add(close);
        
        d.setSize(400,400);    
        int x,y;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        x  = (int) ((screenSize.getWidth() - d.getWidth()) / 2);
        y = (int) ((screenSize.getHeight() - d.getHeight()) / 2);
        d.setLocation(x, y);
        d.setVisible(true); 
        
    }  
    public static void main(String args[])  
    {  
        new AdminHomePage();  
    }  
} 

