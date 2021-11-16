//package ChattingApplication;
import java.io.IOException;
import java.lang.NullPointerException;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
public class server extends JFrame implements ActionListener
{
    JPanel p1;
    JTextField writingBar;
    static JTextArea ta;
    static ServerSocket skt;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    server()
    {  
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,450,70);
        p1.setBackground(new Color(7,94,84));
        add(p1);

       
        //back button
        ImageIcon back_button_icon1 = new ImageIcon (ClassLoader.getSystemResource("icons/3.png"));
        Image back_button_icon2 = back_button_icon1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);      
        ImageIcon back_button_icon3= new ImageIcon(back_button_icon2);
        JLabel l1=new JLabel(back_button_icon3);
        l1.setBounds(5,17,25,25);
        p1.add(l1);    

        l1.addMouseListener(new MouseAdapter()
        {
            public void mouceClicked(MouseEvent ae)
            {
                System.exit(0);
            }        
        });

      
        
        //1st user
        ImageIcon boy_dp1 = new ImageIcon (ClassLoader.getSystemResource("icons/boy1.png"));
        Image  boy_dp2= boy_dp1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);      
        ImageIcon boy_dp3= new ImageIcon(boy_dp2);
        JLabel l2=new JLabel(boy_dp3);
        l2.setBounds(25,10,60,60);
        p1.add(l2);    
        
        JLabel l3=new JLabel("He");
        l3.setBounds(90,15,100,20);
        l3.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        l3.setForeground(Color.WHITE);
        p1.add(l3);

        JLabel l4=new JLabel("Active now");
        l4. setBounds(90,35,100,20);
        l4.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        l4.setForeground(Color.WHITE);
        p1.add(l4);

        //three_Dot_Button
        ImageIcon three1 = new ImageIcon (ClassLoader.getSystemResource("icons/3icon.png"));
        Image three2 = three1.getImage().getScaledInstance(15,22,Image.SCALE_DEFAULT);      
        ImageIcon three3= new ImageIcon(three2);
        JLabel l5=new JLabel(three3);
        l5.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        l5.setForeground(Color.WHITE);
        l5.setBounds(350,22,15,22);
        p1.add(l5);    
      
        //phone
        ImageIcon phone1 = new ImageIcon (ClassLoader.getSystemResource("icons/phone.png"));
        Image phone2 = phone1.getImage().getScaledInstance(25,35,Image.SCALE_DEFAULT);      
        ImageIcon phone3= new ImageIcon(phone2);
        JLabel l6=new JLabel(phone3);
        l6.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        l6.setForeground(Color.WHITE);
        l6.setBounds(290,18,25,35);
        p1.add(l6);    
        

        //video
        ImageIcon video1 = new ImageIcon (ClassLoader.getSystemResource("icons/video.png"));
        Image video2 = video1.getImage().getScaledInstance(25,35,Image.SCALE_DEFAULT);      
        ImageIcon video3= new ImageIcon(video2);
        JLabel l7=new JLabel(video3);
        l7.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        l7.setForeground(Color.WHITE);
        l7.setBounds(240,18,25,35);
        p1.add(l7);    

        //writing bar
        writingBar =new JTextField();
        writingBar.setBounds(5,520,300,30);
        writingBar.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        add(writingBar);
        
        //send button
        JButton b1=new JButton("send");
        b1.setBounds(310,520,85,30);
        b1.setBackground(new Color(7,94,84));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
   
        //text Area
        ta=new JTextArea();
        ta.setBounds(2,70,400,450);
        ta.setBackground(Color.WHITE);
        ta.setFont(new Font("SAN SERIF",Font.PLAIN,18));
        ta.setEditable(false);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        add(ta);

        //getContentPane().setBackground(Color.YELLOW);
        setSize(400,600);
        setLocation(400,200);
        setLayout(null);
        setUndecorated(false);
        setVisible(true);
        
      
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public void actionPerformed(ActionEvent a)
    {
        String out=writingBar.getText();
        ta.setText(ta.getText()+"\n         \t"+out);
       try {
           dout.writeUTF(out);
           writingBar.setText("");
        } catch (Exception e) {
           //TODO: handle exception
       }
       
    }

    public static void main(String[] args) throws NullPointerException
    {
        server obj = new server();
        //new server().setVisible(true);
        String comingmsg="";
        try {
            skt=new ServerSocket(6001);
            s=skt.accept();
            din=new DataInputStream(s.getInputStream());
            dout=new DataOutputStream(s.getOutputStream());
            comingmsg=din.readUTF();
            ta.setText(ta.getText()+"\n"+comingmsg);
            skt.close();
            s.close();           
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }
}