package MovieReviewApplication;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Add_Movie implements ActionListener{
     JFrame Mframe;
     JLabel LName,LDes,LRun,LCast,LRat,LTra,LDate;
     JTextArea TName,TDes,TRun,TCast,TRat,TTra,TDate;
     JScrollPane PCast,PDes;
     JButton BUpload,BBack;

    public Add_Movie() {
     Mframe = new JFrame("ADD MOVIE");
     
     LName = new JLabel("MOVIE :");
     LName.setBackground(Color.BLACK);
		LName.setForeground(Color.RED);
     Mframe.add(LName);
     LName.setBounds(10, 10, 50, 30);
     
     TName = new JTextArea();
     Mframe.add(TName);
     TName.setBounds(95, 10, 300, 30);
     
     
     
     
     LRat = new JLabel("RATING : ");
     LRat.setBackground(Color.BLACK);
	LRat.setForeground(Color.RED);
     Mframe.add(LRat);
     LRat.setBounds(10,50 , 70, 30);
     
     TRat = new JTextArea();
     Mframe.add(TRat);
     TRat.setBounds(95, 50, 50, 30);
     
     
     
     
     LTra = new JLabel("Trailer :");
     LTra.setBackground(Color.BLACK);
		LTra.setForeground(Color.RED);
     Mframe.add(LTra);
     LTra.setBounds(10, 90, 80, 30);
     
     TTra = new JTextArea();
     Mframe.add(TTra);
     TTra.setBounds(95, 90, 450, 30);
     
     
     
     LRun = new JLabel("Runtime :");
     LRun.setBackground(Color.BLACK);
	LRun.setForeground(Color.RED);
     Mframe.add(LRun);
     LRun.setBounds(10, 130, 80, 30);
     
      TRun = new JTextArea();
     Mframe.add(TRun);
     TRun.setBounds(95, 130, 160, 30);
     
     
     
     LCast = new JLabel("Cast :");
     LCast.setBackground(Color.BLACK);
	 LCast.setForeground(Color.RED);
     Mframe.add(LCast);
     LCast.setBounds(10,170, 50, 30);
     
      TCast = new JTextArea();
      PCast = new JScrollPane(TCast,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
      PCast.setBackground(Color.BLACK);
	  PCast.setForeground(Color.RED);
      Mframe.add(PCast);
      PCast.setBounds(95, 170, 700, 100);
     
     LDes = new JLabel("Description :");
     LDes.setBackground(Color.BLACK);
	 LDes.setForeground(Color.RED);
     Mframe.add(LDes);
     LDes.setBounds(10, 280, 80, 30);
     
      TDes = new JTextArea();
      PDes = new JScrollPane(TDes,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
      PDes.setBackground(Color.BLACK);
	  PDes.setForeground(Color.RED);
      Mframe.add(PDes);
      PDes.setBounds(95, 280, 700, 200);
      
      
      LDate = new JLabel("Release Date :");
      LDate.setBackground(Color.BLACK);
	  LDate.setForeground(Color.RED);
      Mframe.add(LDate);
      LDate.setBounds(10, 500, 90, 30);
      
      TDate = new JTextArea();
      Mframe.add(TDate);
      TDate.setBounds(95,500, 120, 30);
      
      
      BUpload = new JButton("UPLOAD");
      BUpload.setBackground(Color.BLACK);
	  BUpload.setForeground(Color.RED);
      Mframe.add(BUpload);
      BUpload.setBounds(450,600 ,100 , 40);
      BUpload.addActionListener(this);
      
      BBack = new JButton("BACK");
      BBack.setBackground(Color.BLACK);
      BBack.setForeground(Color.RED);
      Mframe.add(BBack);
      BBack.setBounds(10, 600, 100, 40);
      BBack.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Mframe.setVisible(false);
			new MovieDataBase();
			
		}
	});
     
     Mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     Mframe.getContentPane().setBackground(Color.black);
     Mframe.setSize(1000,800);
     Mframe.setLocationRelativeTo(null);
     Mframe.setLayout(null);
     Mframe.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String Name = TName.getText();
        String Des = TDes.getText();
        String Run = TRun.getText();
        String Cast = TCast.getText();
        String Rat = TRat.getText();
        String Tra = TTra.getText();
        String Date = TDate.getText();
        float FRat = Float.parseFloat(Rat);
        int users=1;
   
        float ratin=FRat;
        
        if(e.getSource().equals(BUpload)){
          try
          {
             Connection c=GetConnection.getconnection();
             String query="insert into movies values(?,?,?,?,?,?,?,?,?);";
             PreparedStatement p = c.prepareStatement(query);
             p.setString(1,Name);
             p.setFloat(2,FRat);
             p.setInt(3, users);
             p.setFloat(4,ratin);
             p.setString(5,Cast);
             p.setString(6,Des);
             p.setString(8,Tra);
             p.setString(7,Run);
             p.setString(9,Date);
             p.executeUpdate();
             c.close();
             JOptionPane.showMessageDialog(BUpload, "New Movie added", "Success", JOptionPane.INFORMATION_MESSAGE);
             
             
             
          
          }
          catch(Exception e1){
              System.out.print("--->"+e1);
          }
        }
        
 
    }
    public static void main(String args[])
    {
    	new Add_Movie();
    }
}
