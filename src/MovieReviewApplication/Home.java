package MovieReviewApplication;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {

	private static JFrame frmBootflixReviewApp;

	public static void home() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frmBootflixReviewApp = new JFrame();
					frmBootflixReviewApp.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gowtham\\Desktop\\Bootathonimg\\bootflix.png"));
					frmBootflixReviewApp.setTitle("BOOTFLIX REVIEW APP");
					frmBootflixReviewApp.getContentPane().setBackground(Color.BLACK);
					frmBootflixReviewApp.getContentPane().setForeground(Color.BLACK);
					frmBootflixReviewApp.setBounds(100, 100, 600, 600);
					frmBootflixReviewApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frmBootflixReviewApp.getContentPane().setLayout(null);
					
					JButton btnAdminLogin = new JButton("Admin Login");
					btnAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
					btnAdminLogin.setBackground(Color.BLACK);
					btnAdminLogin.setForeground(Color.RED);
					btnAdminLogin.setBounds(66, 409, 220, 37);
					frmBootflixReviewApp.getContentPane().add(btnAdminLogin);
					
					btnAdminLogin.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							new AdminLogin();
							frmBootflixReviewApp.dispose();
						}
					});
					
					JButton btnSkipLogin = new JButton("Skip Login");
					btnSkipLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
					btnSkipLogin.setBackground(Color.BLACK);
					btnSkipLogin.setForeground(Color.RED);
					btnSkipLogin.setBounds(190, 507, 200, 30);
					frmBootflixReviewApp.getContentPane().add(btnSkipLogin);
					btnSkipLogin.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							new SkipLogin();
							
						}
					});
					
					JButton btnNewButton = new JButton("User Login");
					btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
					btnNewButton.setBackground(Color.BLACK);
					btnNewButton.setForeground(Color.RED);
					btnNewButton.setBounds(317, 409, 202, 37);
					frmBootflixReviewApp.getContentPane().add(btnNewButton);
					
					btnNewButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							LoginPage.loginpage();
							frmBootflixReviewApp.dispose();
						}
					});
					
					JLabel label = new JLabel("");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					label.setIcon(new ImageIcon("C:\\Users\\Gowtham\\Desktop\\Bootathonimg\\bootflix.png"));
					label.setBounds(-11, 147, 610, 118);
					frmBootflixReviewApp.getContentPane().add(label);
					
					int x,y;
			        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			        x  = (int) ((screenSize.getWidth() - frmBootflixReviewApp.getWidth()) / 2);
			        y = (int) ((screenSize.getHeight() - frmBootflixReviewApp.getHeight()) / 2);
			        frmBootflixReviewApp.setLocation(x, y);
				
					
					frmBootflixReviewApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		home();
	}
	}
