package MovieReviewApplication;

import java.awt.*;  
import javax.swing.JFrame;  
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;  
public class UserDatabase {  
    private static Dialog d;  
    UserDatabase() {  
    	Font font_1=new Font("Calibri",Font.PLAIN,16);
        JFrame f= new JFrame();  
        f.getContentPane().setBackground(Color.BLACK);
		f.getContentPane().setForeground(Color.BLACK);
        d = new Dialog(f , "USER DATABASE", true);
        d.setBackground(Color.BLACK);
		d.setForeground(Color.RED);
        d.setLayout(null);  
        Button b1 = new Button ("->");  
        b1.setBackground(Color.BLACK);
		b1.setForeground(Color.RED);
		b1.setBounds(300,110,50,25);
        Button b2 = new Button ("->");
        b2.setBounds(300,160,50,25);
        b2.setBackground(Color.BLACK);
		b2.setForeground(Color.RED);
		Button b3 = new Button ("->");
        b3.setBounds(300,210,50,25);
        b3.setBackground(Color.BLACK);
		b3.setForeground(Color.RED);
		
		Button close=new Button("Close");
		close.setBounds(160,300,90,30);
	    close.setBackground(Color.BLACK);
	    close.setForeground(Color.RED);
		close.setFont(font_1);
		
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserDatabase.d.setVisible(false);
				new AdminHomePage();
				
			}
		});
        b1.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
            	UserDatabase.d.setVisible(false);
            	EditUser.edituser();
            }  
        });  
        b2.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
            	UserDatabase.d.setVisible(false);  
            	DeleteUser.deleteuser();
            }  
        });  
        b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UserDatabase.d.setVisible(false);  
				UserSuggestions.usersuggestions();
				
			}
		});
        Label l1=new Label ("Edit user details in Database");
        l1.setBounds(70,100,210,50);
        l1.setBackground(Color.BLACK);
		l1.setForeground(Color.RED);
        d.add(l1);
        d.add(b1);
        Label l2=new Label ("Delete a user from Database");
        l2.setBounds(70,150,210,50);
        l2.setBackground(Color.BLACK);
		l2.setForeground(Color.RED);
        d.add(l2);
        d.add(b2);
        Label l3=new Label ("User Suggestions");
        l3.setBounds(70,200,150,50);
        l3.setBackground(Color.BLACK);
		l3.setForeground(Color.RED);
        d.add(l3);
        d.add(b3);
        d.add(close);
        d.setSize(400,400);  
        l1.setFont(font_1);
		l2.setFont(font_1);
		l3.setFont(font_1);
		b1.setFont(font_1);
		b2.setFont(font_1);
		b3.setFont(font_1);
        int x,y;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        x  = (int) ((screenSize.getWidth() - d.getWidth()) / 2);
        y = (int) ((screenSize.getHeight() - d.getHeight()) / 2);
        d.setLocation(x, y);
        d.setVisible(true);  
    }  
    public static void main(String args[])  
    {  
        new UserDatabase();  
    }  
} 