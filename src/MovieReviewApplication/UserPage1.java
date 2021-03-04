package MovieReviewApplication;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserPage1{
    
    public static void userpage1(String s)
    {
        Font font_1=new Font("Calibri",Font.PLAIN,16);
        Font font_2=new Font("SanSerif",Font.BOLD,16);

        JFrame f=new JFrame();
        f.setTitle("User-->");
        JLabel l_review=new JLabel("Add your reviews on");
        l_review.setBackground(Color.BLACK);
        l_review.setForeground(Color.red);
        JLabel l_hello=new JLabel("Hello "+s);
        l_hello.setBackground(Color.BLACK);
        l_hello.setForeground(Color.red);
        JLabel l_fav=new JLabel("View Favorites?");
        l_fav.setBackground(Color.BLACK);
        l_fav.setForeground(Color.red);
        JLabel l_records=new JLabel("View your records?");
        l_records.setBackground(Color.BLACK);
        l_records.setForeground(Color.red);
        JButton b_movie=new JButton("Movies");
        b_movie.setBackground(Color.BLACK);
        b_movie.setForeground(Color.red);
        JButton b_series=new JButton("Series");
        b_series.setBackground(Color.BLACK);
        b_series.setForeground(Color.red);
        JButton b_yes=new JButton("Yes");
        b_yes.setBackground(Color.BLACK);
        b_yes.setForeground(Color.red);
        JButton b_yes1=new JButton("Yes");
        b_yes1.setBackground(Color.BLACK);
        b_yes1.setForeground(Color.red);
        JButton b_sug=new JButton("Add Suggestions");
        b_sug.setBackground(Color.BLACK);
        b_sug.setForeground(Color.red);
        
        l_review.setFont(font_1);
        l_hello.setFont(font_2);
        l_fav.setFont(font_1);
        l_records.setFont(font_1);
        b_movie.setFont(font_1);
        b_series.setFont(font_1);
        b_yes.setFont(font_1);
        b_yes1.setFont(font_1);
        b_sug.setFont(font_1);
        
        b_movie.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MoviesImg.page1(s);
            }
        });
        b_series.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                SeriesImg.page1(s);
                
            }
        });
        
        b_yes.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Favorites.favorites(s);
                
            }
        });
        
        b_yes1.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                UserRecords.userrecords(s);
                
            }
        });
        
        b_sug.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Suggestions.suggestions();
				
			}
		});
        
        l_hello.setBounds(170, 20, 200,30);
        l_review.setBounds(140,80,150,30);
        b_movie.setBounds(50,120,150,40);
        b_series.setBounds(200,120,150,40);
        l_fav.setBounds(50,210,130,30);
        b_yes.setBounds(190,210,80,30);
        l_records.setBounds(50,250,140,30);
        b_yes1.setBounds(190,250,80,30);
        b_sug.setBounds(48,300,150,30);
        
        f.setVisible(true);
        f.setLayout(null);
        f.setSize(400,400);
        
        f.add(l_review);
        f.add(l_hello);
        f.add(b_movie);
        f.add(b_series);
        f.add(l_fav);
        f.add(b_yes);
        f.add(b_yes1);
        f.add(l_records);
        f.add(b_sug);
        
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
        userpage1("hani");
    }

}
