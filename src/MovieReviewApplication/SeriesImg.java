package MovieReviewApplication;
import java.awt.*;  
import javax.swing.*;  
 import java.awt.event.*; 

public class SeriesImg {

    static JFrame f;  
    static Font font_2=new Font("SanSerif",Font.BOLD,200);
    public static void page1(String uname){  
        f=new JFrame("Page 1");  
        f.getContentPane().setBackground(Color.BLACK);
        f.getContentPane().setForeground(Color.BLACK);

        String url1="C:\\Users\\Gowtham\\Desktop\\series image\\sabrima.jpg";
         ImageIcon img1 = new ImageIcon(url1); 
         String url2="C:\\Users\\Gowtham\\Desktop\\series image\\strangerthings.jpg";
         ImageIcon img2= new ImageIcon(url2); 
          String url3="C:\\Users\\Gowtham\\Desktop\\series image\\flash.jpg";
         ImageIcon img3= new ImageIcon(url3); 
          String url4="C:\\Users\\Gowtham\\Desktop\\series image\\13reasonsy.jpg";
         ImageIcon img4= new ImageIcon(url4); 
          String url5="C:\\Users\\Gowtham\\Desktop\\series image\\breakingbad.jpg";
         ImageIcon img5= new ImageIcon(url5); 
          String url6="C:\\Users\\Gowtham\\Desktop\\series image\\sacredtimes.jpg";
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
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.red);
            JButton b2=new JButton(img2);  
            b2.setBackground(Color.BLACK);
            b2.setForeground(Color.red);
            JButton b3=new JButton(img3);
            b3.setBackground(Color.BLACK);
            b3.setForeground(Color.red);
            JButton b4=new JButton(img4);
            b4.setBackground(Color.BLACK);
            b4.setForeground(Color.red);
            JButton b5=new JButton(img5);
            b5.setBackground(Color.BLACK);
            b5.setForeground(Color.red);
            JButton b6=new JButton(img6); 
            b6.setBackground(Color.BLACK);
            b6.setForeground(Color.red);
            JButton b7=new JButton(img7); 
            b7.setBackground(Color.BLACK);
            b7.setForeground(Color.red);
            JButton b8=new JButton(img8); 
            b8.setBackground(Color.BLACK);
            b8.setForeground(Color.red);
            JButton b9=new JButton(img9); 
            b9.setBackground(Color.BLACK);
            b9.setForeground(Color.red);
            JButton b10=new JButton(img10); 
            b10.setBackground(Color.BLACK);
            b10.setForeground(Color.red);
            JButton next=new JButton(">");
            next.setBackground(Color.BLACK);
            next.setForeground(Color.red);
            JButton next1=new JButton(">");
            next1.setBackground(Color.BLACK);
            next1.setForeground(Color.red);
        
        next.setFont(font_2);
        next1.setFont(font_2);
        
        b1.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Chilling Adventures of Sabrina ");
                f.dispose();
            
            }  
        }); 
        
        b2.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Stranger Things");
                f.dispose();
            }  
        }); 
        
        b3.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"The Flash ");
                f.dispose();
            
            }  
        }); 
        
        b4.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"13 Reasons Why");
                f.dispose();
            
            }  
        }); 
        
        b5.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Breaking Bad");
                f.dispose();
            
            }  
        }); 
        
        b6.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Sacred Games");
                f.dispose();
            }  
        }); 
        
        b7.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"The Forgotten Army - Azaadi ke liye");
                f.dispose();
            }  
        }); 
        
        b8.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Supernatural ");
                f.dispose();
            }  
        }); 
        
        b9.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Peaky Blinders");
                f.dispose();
            }  
        }); 
        
        b10.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"The One punch Man");
                f.dispose();
            }  
        }); 
        
        next.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                SeriesImg.page2(uname);

            }
        });
        
        next1.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                SeriesImg.page2(uname);
                
            }
        });
       
       
             f.add(b1);
             f.add(b2);
             f.add(b3);
             f.add(b4);
             f.add(b5);
             f.add(next1);
             f.add(b6);
             f.add(b7);
             f.add(b8);
             f.add(b9);
             f.add(b10);
             f.add(next);
             
        f.setLayout(new GridLayout(2,5));  
      
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);  
        
    }  
    public static void page2(String uname){  
        f=new JFrame("Page 2");  
        f.getContentPane().setBackground(Color.BLACK);
        f.getContentPane().setForeground(Color.BLACK);
        

          String url11="C:\\Users\\Gowtham\\Desktop\\series image\\westman.jpg";
         ImageIcon img11= new ImageIcon(url11); 
          String url12="C:\\Users\\Gowtham\\Desktop\\series image\\mirzapur.jpg";
         ImageIcon img12= new ImageIcon(url12); 
          String url13="C:\\Users\\Gowtham\\Desktop\\series image\\sherlock.jpg";
         ImageIcon img13= new ImageIcon(url13); 
          String url14="C:\\Users\\Gowtham\\Desktop\\series image\\theboys.jpg";
         ImageIcon img14= new ImageIcon(url14); 
          String url15="C:\\Users\\Gowtham\\Desktop\\series image\\jackryan.jpg";
         ImageIcon img15= new ImageIcon(url15); 
          String url16="C:\\Users\\Gowtham\\Desktop\\series image\\theexpanse.jpg";
         ImageIcon img16= new ImageIcon(url16); 
         String url17="C:\\Users\\Gowtham\\Desktop\\series image\\vikings.jpg";
         ImageIcon img17= new ImageIcon(url17); 
         String url18="C:\\Users\\Gowtham\\Desktop\\series image\\100.jpg";
         ImageIcon img18= new ImageIcon(url18); 
         String url19="C:\\Users\\Gowtham\\Desktop\\series image\\hanna.jpg";
         ImageIcon img19= new ImageIcon(url19); 
         String url20="C:\\Users\\Gowtham\\Desktop\\series image\\umbrella.jpg";
         ImageIcon img20= new ImageIcon(url20); 
         
         JButton b11=new JButton(img11);  
            b11.setBackground(Color.BLACK);
            b11.setForeground(Color.red);
            JButton b12=new JButton(img12);  
            b12.setBackground(Color.BLACK);
            b12.setForeground(Color.red);
            JButton b13=new JButton(img13);
            b13.setBackground(Color.BLACK);
            b13.setForeground(Color.red);
            JButton b14=new JButton(img14);
            b14.setBackground(Color.BLACK);
            b14.setForeground(Color.red);
            JButton b15=new JButton(img15);
            b15.setBackground(Color.BLACK);
            b15.setForeground(Color.red);
            JButton b16=new JButton(img16); 
            b16.setBackground(Color.BLACK);
            b16.setForeground(Color.red);
            JButton b17=new JButton(img17); 
            b17.setBackground(Color.BLACK);
            b17.setForeground(Color.red);
            JButton b18=new JButton(img18); 
            b18.setBackground(Color.BLACK);
            b18.setForeground(Color.red);
            JButton b19=new JButton(img19); 
            b19.setBackground(Color.BLACK);
            b19.setForeground(Color.red);
            JButton b20=new JButton(img20); 
            b20.setBackground(Color.BLACK);
            b20.setForeground(Color.red);
            JButton next=new JButton("<");
            next.setBackground(Color.BLACK);
            next.setForeground(Color.red);
            JButton next1=new JButton(">");
            next1.setBackground(Color.BLACK);
            next1.setForeground(Color.red);
        
        next.setFont(font_2);
        next1.setFont(font_2);
     
             
        b11.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Westworld");
                f.dispose();
            }  
        }); 
        
        b12.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Mirzapur");
                f.dispose();
            }  
        }); 
        
        b13.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Sherlock");
                f.dispose();
            
            }  
        }); 
        
        b14.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"The boys");
                f.dispose();
            }  
        }); 
        
        b15.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Tom Clancy's Jack Ryan ");
                f.dispose();
            }  
        }); 
        
        b16.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"The Expanse");
                f.dispose();
            }  
        }); 
        
        b17.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Vikings");
                f.dispose();
            }  
        }); 
        
        b18.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){ 
                f.dispose();
                Series.series(uname,"The 100");
            
            }  
        }); 
        
        b19.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Hanna");
                f.dispose();
            }  
        }); 
        
        b20.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"The Umbrella Academy");
                f.dispose();
            }  
        }); 
        
        next.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                SeriesImg.page1(uname);
                
            }
        });
        
        next1.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                SeriesImg.page3(uname);
                
            }
        });
       
             f.add(next);
             f.add(b11);
             f.add(b12);
             f.add(b13);
             f.add(b14);
             f.add(b15);
             f.add(b16);  
             f.add(b17);
             f.add(b18);
             f.add(b19);
             f.add(b20);
             f.add(next1);
             
        f.setLayout(new GridLayout(2,5));  
      
        f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        f.setVisible(true);  
        
    }  
    public static void page3(String uname){  
        f=new JFrame("Page 3");  
        f.getContentPane().setBackground(Color.BLACK);
        f.getContentPane().setForeground(Color.BLACK);
        
        String url21="C:\\Users\\Gowtham\\Desktop\\series image\\de.jpg";
         ImageIcon img21= new ImageIcon(url21); 
          String url22="C:\\Users\\Gowtham\\Desktop\\series image\\thewicher.jpg";
         ImageIcon img22= new ImageIcon(url22); 
          String url23="C:\\Users\\Gowtham\\Desktop\\series image\\insideedge.jpg";
         ImageIcon img23= new ImageIcon(url23); 
           String url24="C:\\Users\\Gowtham\\Desktop\\series image\\gameofthrones.jpg";
         ImageIcon img24= new ImageIcon(url24); 
           String url25="C:\\Users\\Gowtham\\Desktop\\series image\\moneyheist.jpg";
         ImageIcon img25= new ImageIcon(url25); 
           String url26="C:\\Users\\Gowtham\\Desktop\\series image\\young.jpg";
         ImageIcon img26= new ImageIcon(url26); 
           String url27="C:\\Users\\Gowtham\\Desktop\\series image\\chernobyl.jpg";
         ImageIcon img27= new ImageIcon(url27); 
           String url28="C:\\Users\\Gowtham\\Desktop\\series image\\dark.jpg";
         ImageIcon img28= new ImageIcon(url28); 
           String url29="C:\\Users\\Gowtham\\Desktop\\series image\\hunters.jpg";
         ImageIcon img29= new ImageIcon(url29); 
           String url30="C:\\Users\\Gowtham\\Desktop\\series image\\lucifer.jpg";
         ImageIcon img30= new ImageIcon(url30); 
                 
         JButton b21=new JButton(img21);  
            b21.setBackground(Color.BLACK);
            b21.setForeground(Color.red);
            JButton b22=new JButton(img22);  
            b22.setBackground(Color.BLACK);
            b22.setForeground(Color.red);
            JButton b23=new JButton(img23);
            b23.setBackground(Color.BLACK);
            b23.setForeground(Color.red);
            JButton b24=new JButton(img24);
            b24.setBackground(Color.BLACK);
            b24.setForeground(Color.red);
            JButton b25=new JButton(img25);
            b25.setBackground(Color.BLACK);
            b25.setForeground(Color.red);
            JButton b26=new JButton(img26); 
            b26.setBackground(Color.BLACK);
            b26.setForeground(Color.red);
            JButton b27=new JButton(img27); 
            b27.setBackground(Color.BLACK);
            b27.setForeground(Color.red);
            JButton b28=new JButton(img28); 
            b28.setBackground(Color.BLACK);
            b28.setForeground(Color.red);
            JButton b29=new JButton(img29); 
            b29.setBackground(Color.BLACK);
            b29.setForeground(Color.red);
            JButton b30=new JButton(img30); 
            b30.setBackground(Color.BLACK);
            b30.setForeground(Color.red);
            JButton next=new JButton("<");
            next.setBackground(Color.BLACK);
            next.setForeground(Color.red);
            JButton next1=new JButton("<");
            next1.setBackground(Color.BLACK);
            next1.setForeground(Color.red);
        
        next.setFont(font_2);
        next1.setFont(font_2);
             
        b21.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Death Note");
                f.dispose();
            }  
        }); 
        
        b22.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"The witcher");
                f.dispose();
            }  
        }); 
        
        b23.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Inside Edge");
                f.dispose();
            
            }  
        }); 
        
        b24.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Game of Thrones");
                f.dispose();
            }  
        }); 
        
        b25.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Money Heist");
                f.dispose();
            }  
        }); 
        
        b26.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Young Sheldon");
                f.dispose();
            }  
        }); 
        
        b27.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Chernobyl");
                f.dispose();
            }  
        }); 
        
        b28.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Dark");
                f.dispose();
            }  
        }); 
        
        b29.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Hunters");
                f.dispose();
            }  
        }); 
        
        b30.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                Series.series(uname,"Lucifer");
                f.dispose();
            }  
        }); 
        
        next.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                SeriesImg.page2(uname);
                
            }
        });
        
        next1.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                SeriesImg.page2(uname);
                
            }
        });
             f.add(next);
             f.add(b21); 
             f.add(b22);
             f.add(b23);
             f.add(b24);
             f.add(b25);
             f.add(next1);
             f.add(b26);  
             f.add(b27);
             f.add(b28);
             f.add(b29);
             f.add(b30);
        
        f.setLayout(new GridLayout(2,5));  
      
        f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        f.setVisible(true);  
        
    }  
    public static void main(String[] args) {  
        page3("");
    }  
    
}
