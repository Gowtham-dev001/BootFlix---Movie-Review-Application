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


public class Delete_Movie implements ActionListener{
 JFrame Mframe;
     JLabel LName,LDes,LRun,LCast,LRat,LTra,LDate;
     JTextArea TName,TDes,TRun,TCast,TRat,TTra,TDate;
     JScrollPane PCast,PDes;
     JButton BDelete,BSearch,BBack;
     String SName,SDes,SRun,SCast,SRat,STra,SDate,SSearch,change;   
     
           public Delete_Movie() {
     Mframe = new JFrame("Delete MOVIE");
    
        
     LName = new JLabel("MOVIE :");
     LName.setBackground(Color.BLACK);
 	LName.setForeground(Color.RED);
     Mframe.add(LName);
     LName.setBounds(10, 10, 50, 30);
     
     TName = new JTextArea("Enter moive to be seacrched");
     Mframe.add(TName);
     TName.setBounds(95, 10, 300, 30);
     
     BSearch = new JButton("Search");
     BSearch.setBackground(Color.BLACK);
  	BSearch.setForeground(Color.RED);
     Mframe.add(BSearch);
     BSearch.setBounds(400, 10,100, 30);
     BSearch.addActionListener(this);
     
     
     
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
     TTra.setBounds(95, 90, 400, 30);
     
     
     
     LRun = new JLabel("Runtime :");
     LRun.setBackground(Color.BLACK);
  	LRun.setForeground(Color.RED);
     Mframe.add(LRun);
     LRun.setBounds(10, 130, 80, 30);
     
      TRun = new JTextArea();
     Mframe.add(TRun);
     TRun.setBounds(95, 130, 300, 30);
     
     
     
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
      
      
      BDelete = new JButton("DELETE");
      BDelete.setBackground(Color.BLACK);
	  BDelete.setForeground(Color.RED);
      Mframe.add(BDelete);
      BDelete.setBounds(450,600 ,100 , 40);
      BDelete.addActionListener(this);
      
       BBack = new JButton("BACK");
       BBack.setBackground(Color.BLACK);
       BBack.setForeground(Color.RED);
      Mframe.add(BBack);
      BBack.setBounds(10, 600, 100, 40);
      BBack.addActionListener(this);
     
     Mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     Mframe.getContentPane().setBackground(Color.black);
     Mframe.setSize(1000,800);
     Mframe.setLocationRelativeTo(null);
     Mframe.setLayout(null);
     Mframe.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
      if(e.getSource().equals(BSearch)){
              SSearch=TName.getText();
              try{
                  
              Connection con=GetConnection.getconnection();
              String query="select * from movies";
              PreparedStatement p = con.prepareStatement(query);
              ResultSet r = p.executeQuery();
              int flag=0;
              while(r.next()){
                  if(SSearch.equalsIgnoreCase(r.getString("Name"))){
                      TDes.setText(r.getString("Description"));
                      TRun.setText(r.getString("Runtime"));
                      TCast.setText(r.getString("Crew"));
                      
                      TRat.setText(r.getString("Ratingyet"));
                      TTra.setText(r.getString("Trailer"));
                      TDate.setText(r.getString("Year"));
                      change=r.getString("Name");
                      flag=1;
                  }
              }
              if(flag==0){
                  JOptionPane.showMessageDialog(BSearch, "Movie not found", "Try Again", JOptionPane.INFORMATION_MESSAGE);
              }
              con.close();
              }
              catch(Exception e1){
                  System.out.print("--->"+e1);
              }
          }
      else if(e.getSource().equals(BDelete)){
        try{
        	Connection c=GetConnection.getconnection();
            String q = "delete from movies where Name = ?";
            PreparedStatement p = c.prepareStatement(q);
            p.setString(1,change);
            p.executeUpdate();
            c.close();
            JOptionPane.showMessageDialog(BDelete, "Movie Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e2){
          System.out.print("---->"+e2);
      }
    }
        else if(e.getSource().equals(BBack)){
             //Previous frame class object;
             Mframe.dispose();
             new MovieDataBase();
        } 
    }
}