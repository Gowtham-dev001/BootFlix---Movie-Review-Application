package MovieReviewApplication;

import java.awt.*;  
import javax.swing.*;  
 import java.awt.event.*; 
public class SkipLogin extends MouseAdapter{  
JFrame f;  
SkipLogin(){  
    f=new JFrame();
    f.setTitle("Demo Pack");
      String url1="C:\\Users\\Gowtham\\Desktop\\movie image\\amazingspider.jpg";
     ImageIcon img1 = new ImageIcon(url1); 
     String url2="C:\\Users\\Gowtham\\Desktop\\movie image\\civilwar.jpg";
     ImageIcon img2= new ImageIcon(url2); 
      String url3="C:\\Users\\Gowtham\\Desktop\\movie image\\avengers.jpg";
     ImageIcon img3= new ImageIcon(url3); 
      String url4="C:\\Users\\Gowtham\\Desktop\\movie image\\antman.jpg";
     ImageIcon img4= new ImageIcon(url4); 
      String url5="C:\\Users\\Gowtham\\Desktop\\movie image\\ironman.jpg";
     ImageIcon img5= new ImageIcon(url5); 
      String url6="C:\\Users\\Gowtham\\Desktop\\movie image\\guardian.jpg";
     ImageIcon img6= new ImageIcon(url6); 
      String url7="C:\\Users\\Gowtham\\Desktop\\series image\\army.jpg";
     ImageIcon img7= new ImageIcon(url7); 
      String url8="C:\\Users\\Gowtham\\Desktop\\series image\\supernatural.jpg";
     ImageIcon img8= new ImageIcon(url8); 
      String url9="C:\\Users\\Gowtham\\Desktop\\series image\\peakyblinders.jpg";
     ImageIcon img9= new ImageIcon(url9);
      String url10="C:\\Users\\Gowtham\\Desktop\\series image\\punch.jpg";
     ImageIcon img10= new ImageIcon(url10); 
     
    JButton b1=new JButton(img1);  
    JButton b2=new JButton(img2);  
    JButton b3=new JButton(img3);   
    JButton b4=new JButton(img4);    
    JButton b5=new JButton(img5); 
    JButton b6=new JButton(img6); 
    JButton b7=new JButton(img7); 
    JButton b8=new JButton(img8); 
    JButton b9=new JButton(img9); 
    JButton b10=new JButton(img10); 
    
    b1.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
        	JOptionPane.showMessageDialog(f,"Login for more");
            f.dispose();
        
        }  
    }); 
    
    b2.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
        	JOptionPane.showMessageDialog(f,"Login for more");
            f.dispose();
        }  
    }); 
    
    b3.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
        	JOptionPane.showMessageDialog(f,"Login for more");
            f.dispose();
        
        }  
    }); 
    
    b4.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
        	JOptionPane.showMessageDialog(f,"Login for more");
            f.dispose();
        
        }  
    }); 
    
    b5.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
        	JOptionPane.showMessageDialog(f,"Login for more");
            f.dispose();
        
        }  
    }); 
    
    b6.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
        	JOptionPane.showMessageDialog(f,"Login for more");
            f.dispose();
        }  
    }); 
    
    b7.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
        	JOptionPane.showMessageDialog(f,"Login for more");
            f.dispose();
        }  
    }); 
    
    b8.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
        	JOptionPane.showMessageDialog(f,"Login for more");
            f.dispose();
        }  
    }); 
    
    b9.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
        	JOptionPane.showMessageDialog(f,"Login for more");
            f.dispose();
        }  
    }); 
    
    b10.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
        	JOptionPane.showMessageDialog(f,"Login for more");
            f.dispose();
        }  
    }); 
    
    f.add(b1);
    f.add(b2);
    f.add(b3);
    f.add(b4);
    f.add(b5);  
    f.add(b6);
    f.add(b7);
    f.add(b8);
    f.add(b9);
    f.add(b10);
    
    f.setLayout(new GridLayout(2,5));  
    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    f.setVisible(true);  
    
}  
public static void main(String[] args) {  
     new SkipLogin(); 
}  
}  