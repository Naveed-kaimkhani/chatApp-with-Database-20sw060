import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager; 
import java.text.NumberFormat.Style;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.sql.*;
import java.awt.event.*;

class chat extends JFrame implements ActionListener

{     //chat class
    JPanel pan;
    JLabel lb;
    JTextField username;
    JTextField pass;
    JRadioButton rd;
    JLabel usernamelabel;
    JLabel passlabel;
    JButton login;
    JButton signup;
    Connection con;
  
    
   
    chat()
    {   //constructor start 
        setSize(500,500);
        setLayout(null);

        pan = new JPanel();
        pan.setLayout(null);
        pan.setBounds(0,0,200,500);
        pan.setBackground(new Color(7,94,84));
        add(pan);
        

        lb=new JLabel("Sign In");
        lb.setBounds(250,5,150,140);
        lb.setFont(new Font("SAN_SERIF",Font.BOLD,30));
        lb.setForeground(Color.black);
        add(lb);

        
        username =new JTextField();
        username.setBounds(240,200,220,30);
        username.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        username.setBorder(null);
        username.setBackground(Color.LIGHT_GRAY);
        //username.setForeground(new Color());
        add(username);
        
        
        pass =new JTextField();
        pass.setBounds(240,260,220,30);
        pass.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        pass.setBorder(null);
        pass.setBackground(Color.LIGHT_GRAY);
        add(pass);

         login=new JButton("login");
         login.setBounds(370,320,80,30);
         login.setBackground(new Color(7,94,84));
         //login.setFont();
         login.setForeground(Color.WHITE);
         add(login);
        
         login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                //catch end
                String url="jdbc:mysql://localhost:3306/chatapp";
                String user="root";
                String password="*#@kk901";
               try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection(url, user, password);
                Statement st=con.createStatement();
            String sql="SELECT password FROM USERS WHERE password = '"+pass.getText()+"'";
            ResultSet rs=st.executeQuery(sql);
            //rs=st.executeQuery(sql);
           if(rs.isBeforeFirst())
           { 
                server he=new server();
                client she=new client();
                dispose();
           }
           else{
               JOptionPane.showMessageDialog(null, "email or password incorrect", "Info", JOptionPane.INFORMATION_MESSAGE);
           } 
               
               } catch (Exception e) {
                   //TODO: handle exception
                   System.out.println(e);
               }
                // String sqll="SELECT password FROM USERS WHERE password = 'kk90'";
            }//actionperformed end
          }// Actionlistener end
          );

         signup=new JButton("Create new accont");
         signup.setBounds(270,400,160,30);
         signup.setBackground(new Color(7,94,84));
         signup.setForeground(Color.WHITE);
         add(signup);



        usernamelabel=new JLabel("username");
        usernamelabel.setBounds(240,180,60,20);
        add(usernamelabel);
        
        passlabel=new JLabel("password");
        passlabel.setBounds(240,240,60,20);
        add(passlabel);

        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                //catch end
                
                signup obj=new signup();
                dispose();
    
            }//actionperformed end
          }// Actionlistener end
          );
          
       System.out.print("constructor. end");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    } //constructor end
    
    //add actionlistener end
}//class end

 
public class App {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        //connection();
        chat obj=new chat();

    }//main end
}//class end
