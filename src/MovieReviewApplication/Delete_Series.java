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



public class Delete_Series implements ActionListener {
   JFrame Sframe;
     JLabel LName,LDes,LSea,LCast,LRat,LTra,LYear,LEpi;
     JTextArea TName,TDes,TSea,TCast,TRat,TTra,TYear,TEpi;
     JScrollPane PCast,PDes;
     JButton BDelete,BSearch,BBack;
     String SName,SDes,SSea,SCast,SRat,STra,SYear,SSearch,SEpi,change; 
     
     public Delete_Series(){
          Sframe = new JFrame("Delete Series");
    
        
     LName = new JLabel("SERIES :");
     LName.setBackground(Color.BLACK);
  	LName.setForeground(Color.RED);
     Sframe.add(LName);
     LName.setBounds(10, 10, 50, 30);
     
     TName = new JTextArea("Enter series to be seacrched");
     Sframe.add(TName);
     TName.setBounds(90, 10, 300, 30);
     
     BSearch = new JButton("Search");
     BSearch.setBackground(Color.BLACK);
   	BSearch.setForeground(Color.RED);
     Sframe.add(BSearch);
     BSearch.setBounds(400, 10,100, 30);
     BSearch.addActionListener(this);
     
     LRat = new JLabel("RATING : ");
     LRat.setBackground(Color.BLACK);
   	LRat.setForeground(Color.RED);
     Sframe.add(LRat);
     LRat.setBounds(10,50 , 70, 30);
     
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
     TSea.setBounds(90, 130, 50, 30);
     
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
      TYear.setBounds(90,530, 150, 30);
      
      BBack = new JButton("BACK");
      BBack.setBackground(Color.BLACK);
      BBack.setForeground(Color.RED);
      Sframe.add(BBack);
      BBack.setBounds(10, 630, 100, 40);
      BBack.addActionListener(this);
      
      BDelete = new JButton("DELETE");
      BDelete.setBackground(Color.BLACK);
	  BDelete.setForeground(Color.RED);
      Sframe.add(BDelete);
      BDelete.setBounds(450,630 ,100 , 40);
      BDelete.addActionListener(this);
     
     Sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     Sframe.getContentPane().setBackground(Color.black);
     Sframe.setSize(1000,800);
     Sframe.setLocationRelativeTo(null);
     Sframe.setLayout(null);
     Sframe.setVisible(true);
    
        
     
     }
     @Override
     public void actionPerformed(ActionEvent e){
          if(e.getSource().equals(BSearch)){
              SSearch=TName.getText();
              try{
                  
              Connection c=GetConnection.getconnection();
              String query="select * from series";
              PreparedStatement p = c.prepareStatement(query);
              ResultSet r = p.executeQuery();
              int flag=0;
              while(r.next()){
                  if(SSearch.equalsIgnoreCase(r.getString("Name"))){
                      TDes.setText(r.getString("Description"));
                      TSea.setText(r.getString("Seasons"));
                      TEpi.setText(r.getString("Episodes"));
                      TCast.setText(r.getString("Cast"));
                      TRat.setText(r.getString("Ratingyet"));
                      TTra.setText(r.getString("Trailer"));
                      TYear.setText(r.getString("Year"));
                      change=r.getString("Name");
                      flag=1;
                  }
              }
              if(flag==0){
                  JOptionPane.showMessageDialog(BSearch, "Series not found", "Try Again", JOptionPane.INFORMATION_MESSAGE);
              }
              c.close();
              }
              catch(Exception e1){
                  System.out.print("--->"+e1);
              }
          }
           else if(e.getSource().equals(BDelete)){
        try{
            Connection c=GetConnection.getconnection();
            String q = "delete from series where Name = ?";
            PreparedStatement p = c.prepareStatement(q);
            p.setString(1,change);
            p.executeUpdate();
            c.close();
            JOptionPane.showMessageDialog(BDelete, "Series Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e2){
          System.out.print("---->"+e2);
      }
    }
            else if(e.getSource().equals(BBack)){
             //Previous frame class object;
             Sframe.dispose();
             new SeriesDatabase();
        }
     }
}