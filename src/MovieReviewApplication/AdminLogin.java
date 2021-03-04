package MovieReviewApplication;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;


	public class AdminLogin extends JFrame implements ActionListener{
	    JFrame frame;
	    JLabel luser,lpass,lbg;
	    JTextArea tuser;
	    JTextField pass;
	    JButton bhome,bin;
	    public AdminLogin(){
	        frame = new JFrame("Admin Portal");
	        frame.getContentPane().setBackground(Color.BLACK);
			frame.getContentPane().setForeground(Color.BLACK);
	        luser = new JLabel("User ID:");
	        luser.setBackground(Color.BLACK);
	        luser.setForeground(Color.RED);
	        frame.add(luser);	        
	        luser.setFont(new Font("Times New Roman",Font.BOLD,17));
	        luser.setBounds(60,90,80,30);
	        
	        tuser = new JTextArea();
	        frame.add(tuser);
	        tuser.setBounds(170,90,150,30);
	        
	        lpass = new JLabel("Password:");
	        lpass.setBackground(Color.BLACK);
	        lpass.setForeground(Color.RED);
	        frame.add(lpass);
	        lpass.setFont(new Font("Times New Roman",Font.BOLD,17));
	        lpass.setBounds(60,130,83,30);
	        
	        pass = new JTextField();
	        frame.add(pass);
	        pass.setBounds(170,130,150,30);
	        
	        bin = new JButton("LOGIN");
	        bin.setBackground(Color.BLACK);
	        bin.setForeground(Color.RED);
	        frame.add(bin);
	        bin.setBounds(150,200,80,25);
	        bin.addActionListener(this);
	        
	        String url1="C:\\\\Users\\\\Gowtham\\\\Desktop\\\\Bootathonimg\\\\home.jpg";
	        ImageIcon img1 = new ImageIcon(new ImageIcon(url1).getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT)); 
			JButton b_home=new JButton(img1);
	        
	        b_home.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
					Home.home();
					
				}
			});
	   
	    	b_home.setBounds(10,10,30,30);
	    	frame.add(b_home);
	        
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400,400);
	        frame.setLocationRelativeTo(null);
	        frame.setLayout(null);
	        frame.setVisible(true);
	    }
	    public boolean checkpass(String user,String pass){
	        if(user.equals("Admin")&&pass.equals("Admin")){
	            return true;
	        }
	        else
	            return false;
	    }
	    public void checkfail(){
	        
	        JLabel msg = new JLabel("Please try again");
	        msg.setBackground(Color.BLACK);
	        msg.setForeground(Color.RED);
	        frame.add(msg);
	        msg.setFont(new Font("Boulder",Font.BOLD,17));
	        msg.setBounds(130,240,150,50);
	        
	    }
	    @Override
	    public void actionPerformed(ActionEvent e){
	        String username = tuser.getText();
	        String password = pass.getText();
	        if(e.getSource().equals(bin)){
	            if(checkpass(username,password)){
	                frame.dispose();
	                new AdminHomePage();
	            }
	            else
	                checkfail();
	        }
	        else if(e.getSource().equals(bhome)){
	            new Home();
	            
	        }
	        
	    }
	    public static void main(String a[]){
	        new AdminLogin();
	    }
	    
	}