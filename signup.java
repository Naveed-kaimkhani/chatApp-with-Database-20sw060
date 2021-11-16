import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import com.mysql.cj.protocol.Message;
public class signup extends JFrame implements ActionListener  {
    JPanel panel;
    JTextField name;
    JTextField email;
    JTextField password;
    JTextField phone;
    JButton signupp;  
    JButton back;  
    JLabel label;
    JLabel namelabel;
    JLabel emaillabel;
    JLabel passlabel;
    JLabel phonelabel;
    signup()
  {
    setSize(500,500);

    setLayout(null);

    panel = new JPanel() ;
    panel.setBounds(0,0,500,100);
    panel.setBackground(new Color(7,94,84));
    add(panel);

     name=new JTextField();
     name.setBounds(150,150,220,30);
     name.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
    name.setBorder(null);
    name.setBackground(Color.LIGHT_GRAY);
     add(name);

     namelabel=new JLabel("Enter name");
     namelabel.setBounds(150,125,80,30);
     add(namelabel);
     
     
     email=new JTextField(); 
     email.setBounds(150,200,220,30);
     email.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
    email.setBorder(null);
    email.setBackground(Color.LIGHT_GRAY);
     add(email);

     
     emaillabel=new JLabel("Enter Email");
     emaillabel.setBounds(150,175,80,30);
     add(emaillabel);
     

    password=new JTextField();
    password.setBounds(150,250,220,30);
    password.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
    password.setBorder(null);
    password.setBackground(Color.LIGHT_GRAY);
    add(password);

    
    passlabel=new JLabel("Enter password");
    passlabel.setBounds(150,225,100,30);
    add(passlabel);
    

    label=new JLabel("Lets get Connected..!!");
    label.setBounds(5,30,50,50);
    label.setFont(new Font("SAN_SERIF",Font.PLAIN,25));
    //password.setBorder(null);
    label.setBackground(Color.WHITE);
    label.setForeground(Color.white);
    panel.add(label);
    
    phone=new JTextField();
    phone.setBounds(150,300,220,30);
    phone.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
    phone.setBorder(null);
    phone.setBackground(Color.LIGHT_GRAY);
    add(phone);

    
    passlabel=new JLabel("Enter phone");
    passlabel.setBounds(150,275,100,30);
    add(passlabel);

   signupp = new  JButton ("SignUp");
   signupp.setBounds(200,360,100,30);
   signupp.setBackground(new Color(7,94,84));
   signupp.setForeground(Color.WHITE);
    add(signupp);

  
    signupp.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent a) {
            String url="jdbc:mysql://localhost:3306/chatapp";
            String user="root";
            String passwor="*#@kk901";
            String na=name.getText();
            String em=email.getText();
            String pas=password.getText();
            String pho=email.getText();
            try {
               Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection(url, user, passwor);
                Statement stm=con.createStatement();
                String query="INSERT INTO users VALUES ('"+na+"','"+em+"','"+pas+"','"+pho+"')";
               //String query="INSERT INTO users VALUES ('asim','kk','asim@gmail.com','password','1000')";
                //ResultSet rs=stm.executeQuery(query);
              //  rs.executeQuery(query);
              stm.executeUpdate(query);
            //  JOptionPane.showMessageDialog(parentComponent, message);
                System.out.println("built successfull");
                //JOptionPane.showMessageDialog(this, "Account has been created", "Message",JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Account has been created", "Message",JOptionPane.INFORMATION_MESSAGE);
            }//try end 
            catch (Exception e) {
                // TODO Auto-generated catch block
               System.out.println(e);
            }//catch end
            
            

        }//actionperformed end
      }// Actionlistener end
      );
      
    back=new JButton("Back");
    back.setBounds(300,360,80,30);
    back.setBackground(new Color(7,94,84));
    back.setForeground(Color.WHITE);
     add(back);
    
     
    back.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent a) {
        
        try
        {
          chat obj=new chat();      
          dispose(); 

          }//try end 
          catch (Exception e) {
              // TODO Auto-generated catch block
             System.out.println(e);
          }//catch end
          
          

      }//actionperformed end
    }// Actionlistener end
    );
  


      setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //  JOptionPane.showMessageDialog(this, "wellcome");

  }

    public static void main(String[] args) {
           // signup obj=new signup();
    }    
}
