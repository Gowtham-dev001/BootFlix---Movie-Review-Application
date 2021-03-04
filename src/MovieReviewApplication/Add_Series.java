package MovieReviewApplication;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
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



public class Add_Series implements ActionListener{
     JFrame Sframe;
     JLabel LName,LDes,LSea,LCast,LRat,LTra,LYear,LEpi;
     JTextArea TName,TDes,TSea,TCast,TRat,TTra,TYear,TEpi;
     JScrollPane PCast,PDes;
     JButton BUpload,BBack;
     
     
     public Add_Series(){
              Sframe = new JFrame("ADD SERIES");
    
        
     LName = new JLabel("SERIES :");
     LName.setBackground(Color.BLACK);
		LName.setForeground(Color.RED);
     Sframe.add(LName);
     LName.setBounds(10, 10, 50, 30);
     
     TName = new JTextArea();
     Sframe.add(TName);
     TName.setBounds(90, 10, 300, 30);
     
     
     
     
     LRat = new JLabel("RATING : ");
     LRat.setBackground(Color.BLACK);
 	LRat.setForeground(Color.RED);
     Sframe.add(LRat);
     LRat.setBounds(10,50 ,70 , 30);
     
     TRat = new JTextArea();
     Sframe.add(TRat);
     TRat.setBounds(90, 50, 50, 30);
     
     
     
     
     LTra = new JLabel("Trailer :");
     LTra.setBackground(Color.BLACK);
		LTra.setForeground(Color.RED);
     Sframe.add(LTra);
     LTra.setBounds(10, 90, 80, 30);
     
     TTra = new JTextArea();
     Sframe.add(TTra);
     TTra.setBounds(90, 90, 500, 30);
     
     
     
     LSea = new JLabel("Season :");
     LSea.setBackground(Color.BLACK);
 	LSea.setForeground(Color.RED);
     Sframe.add(LSea);
     LSea.setBounds(10, 130, 80, 30);
     
      TSea = new JTextArea();
     Sframe.add(TSea);
     TSea.setBounds(90, 130,50, 30);
     
     LEpi = new JLabel("Episode :");
     LEpi.setBackground(Color.BLACK);
 	LEpi.setForeground(Color.RED);
     Sframe.add(LEpi);
     LEpi.setBounds(10, 170, 70, 30);
     
     
     TEpi = new JTextArea();
     Sframe.add(TEpi);
     TEpi.setBounds(90,170, 50, 30);
     
     
    
     
     LCast = new JLabel("Cast :");
     LCast.setBackground(Color.BLACK);
	 LCast.setForeground(Color.RED);
     Sframe.add(LCast);
     LCast.setBounds(10,210, 50, 30);
     
      TCast = new JTextArea();
      PCast = new JScrollPane(TCast,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
      PCast.setBackground(Color.BLACK);
	  PCast.setForeground(Color.RED);
      Sframe.add(PCast);
      PCast.setBounds(90, 210, 700, 100);
     
     LDes = new JLabel("Description :");
     LDes.setBackground(Color.BLACK);
	 LDes.setForeground(Color.RED);
     Sframe.add(LDes);
     LDes.setBounds(10, 320, 80, 30);
     
      TDes = new JTextArea();
      PDes = new JScrollPane(TDes,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
      PDes.setBackground(Color.BLACK);
	  PDes.setForeground(Color.RED);
      Sframe.add(PDes);
      PDes.setBounds(90, 320, 700, 200);
      
      
      LYear = new JLabel("Year :");
      LYear.setBackground(Color.BLACK);
	  LYear.setForeground(Color.RED);
      Sframe.add(LYear);
      LYear.setBounds(10, 530, 90, 30);
      
      TYear = new JTextArea();
      Sframe.add(TYear);
      TYear.setBounds(110,530, 150, 30);
      
      
      BUpload = new JButton("UPLOAD");
      BUpload.setBackground(Color.BLACK);
	  BUpload.setForeground(Color.RED);
      Sframe.add(BUpload);
      BUpload.setBounds(400,630 ,100 , 40);
      BUpload.addActionListener(this);
      
       BBack = new JButton("BACK");
       BBack.setBackground(Color.BLACK);
       BBack.setForeground(Color.RED);
      Sframe.add(BBack);
      BBack.setBounds(10, 630, 100, 40);
      BBack.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Sframe.dispose();
			new SeriesDatabase();
			
		}
	});
     
     Sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     Sframe.getContentPane().setBackground(Color.black);
     Sframe.setSize(1000,800);
     Sframe.setLocationRelativeTo(null);
     Sframe.setLayout(null);
     Sframe.setVisible(true);
         
         
         
     }
     @Override
    public void actionPerformed(ActionEvent e){
        String Name = TName.getText();
        String Des = TDes.getText();
        String SSea = TSea.getText();
        String Cast = TCast.getText();
        String SRat = TRat.getText();
        String Tra = TTra.getText();
        String Year = TYear.getText();
        String SEpi = TEpi.getText();
        int IEpi =Integer.parseInt(SEpi);
        int ISea =Integer.parseInt(SSea);
        float FRat =Float.parseFloat(SRat);
        int users=1;
        float ratin=FRat;
    
        if(e.getSource().equals(BUpload)){
          try
          {
             Connection c=GetConnection.getconnection();
             String query="insert into series values(?,?,?,?,?,?,?,?,?,?);";
             PreparedStatement p = c.prepareStatement(query);
             p.setString(1,Name);
             p.setFloat(2,ratin);
             p.setFloat(3,FRat);
             p.setInt(4, users);
             p.setString(5,Year);
             p.setInt(6,ISea);
             p.setInt(7,IEpi);
             p.setString(8,Des);
             p.setString(9,Cast);
             p.setString(10,Tra);
             p.executeUpdate();
             c.close();
             JOptionPane.showMessageDialog(BUpload, "New Series added", "Success", JOptionPane.INFORMATION_MESSAGE);
 
          }
          catch(Exception e1){
              System.out.print("--->"+e1);
          }
        }
       
     int x,y;
     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
     x  = (int) ((screenSize.getWidth() - Sframe.getWidth()) / 2);
     y = (int) ((screenSize.getHeight() - Sframe.getHeight()) / 2);
     Sframe.setLocation(x, y);
}
}
