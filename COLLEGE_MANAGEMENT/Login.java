package COLLEGE_MANAGEMENT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JTextField txUsername ,txPassword;
    Login(){

        Color c1 = new Color(1,62,79);
        getContentPane().setBackground(c1);


        setLayout(null);

    // USERNAME TEXT AREA
        txUsername = new JTextField();
        txUsername.setBounds(400,153,150,30);
        txUsername.setBackground(Color.white);
        add(txUsername);

    // PASSWORD TEST AREA
        txPassword = new JTextField();
        txPassword.setBounds(400,203,150,30);
        txPassword.setBackground(Color.white);
        add(txPassword);
    // USERNAME
        JLabel startUsername = new JLabel("Username");
        startUsername.setBounds(220,150,150,40);
        startUsername.setFont(new Font("open sans",Font.PLAIN,26));
        Color Txt = new Color(222,193,2);
        startUsername.setBackground(c1);
        startUsername.setForeground(Txt);
        add(startUsername);

    // PASSWORD
        JLabel startPassword = new JLabel("Password");
        startPassword.setBounds(220,200,150,40);
        startPassword.setFont(new Font("open sans",Font.PLAIN,26));
        startPassword.setBackground(c1);
        startPassword.setForeground(Txt);
        add(startPassword);

    // LOGIN BUTTON
        JButton Login = new JButton("LOGIN");
        Login.setBounds(300,300,150,30);
        Color button1 = new Color(12,12,12);
        Login.setBackground(button1);
        Login.setForeground(Color.white);
        // action listener
        Login.addActionListener(this);
        Login.setFont(new Font("playfair display",Font.PLAIN,25));

        add(Login);

        // IMAGE
        // getting image from system
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/admin_logo.png"));
        // setting the height width of image by image it of image class
        Image i5 = i4.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        // from image class converting to imageIcon
        ImageIcon i6 = new ImageIcon(i5);
        // making a label to add it in window
        JLabel image2 = new JLabel(i6);
        // setting the height width of image and also locations from x and y
        image2.setBounds(320,0,120,120);
        // add the image to window
        add(image2);


        // SIZE OF WINDOW
        setSize(750,500);
        setLocation(400,150);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        try{
            String username = txUsername.getText();
            String password = txPassword.getText();

            String query = "select * from login where username ='"+username+"' and password = '"+password+"';";
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery(query);
            // if value is there
            if(rs.next()){
                setVisible(false);
                // next class i.e HOME
                new Home();
            }
            else{
                // for message display
                JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                setVisible(true);
            }
        }catch(Exception e){

        }
    }


    public static void main(String[] args) {

        new Login();
    }
}
