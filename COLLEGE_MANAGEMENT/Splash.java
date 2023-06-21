package COLLEGE_MANAGEMENT;
// importing swing package from extended java
import javax.swing.*;
// importing color class
import java.awt.*;
import java.awt.event.*;

 class Splash extends JFrame implements ActionListener {
    Splash(){
        setLayout(null);

        //setting the color of window
        getContentPane().setBackground(Color.BLACK);

    // HEADING
        // setting the heading
        JLabel heading1 = new JLabel("INDIRA GANDHI DELHI TECHNICAL UNIVERSITY");
        JLabel heading2 = new JLabel("FOR WOMEN");
        // setting the locations from left and right
        heading1.setBounds(250,30,1200,80);
        heading2.setBounds(600,110,1200,80);
        // changing font size and font style
        heading1.setFont(new Font("ALGERIAN",Font.PLAIN,50));
        heading2.setFont(new Font("ALGERIAN",Font.PLAIN,50));
        // for setting text color
        heading1.setForeground(Color.white);
        heading2.setForeground(Color.white);
        //adding the heading on screen
        add(heading1);
        add(heading2);

    // welcome to university
        JLabel heading3 = new JLabel("WELCOME TO UNIVERSITY ...");
        heading3.setBounds(475,360,900,60);
        heading3.setFont(new Font("serif",Font.PLAIN,40));
        heading3.setForeground(Color.ORANGE);
        add(heading3);


        // IMAGE
        // getting image from system
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/igdtuw_logo.jpg"));
        // setting the height width of image by image it of image class
        Image i2 = i1.getImage().getScaledInstance(226,221,Image.SCALE_DEFAULT);
        // from image class converting to imageIcon
        ImageIcon i3 = new ImageIcon(i2);
        // making a label to add it in window
        JLabel image1 = new JLabel(i3);
        // setting the height width of image and also locations from x and y
        image1.setBounds(5,5,226,221);
        // add the image to window
        add(image1);

    //BUTTON
        JButton ClickHere = new JButton("Click Here To Continue");
        ClickHere.setBounds(565,560,350,100);
        Color clickC = new Color(112,128,144);
        ClickHere.setBackground(clickC);
        ClickHere.setForeground(Color.WHITE);
        ClickHere.setFont(new Font("serif",Font.PLAIN,25));
        // action
        ClickHere.addActionListener(this);
        add(ClickHere);

    // SETTING WINDOW
        // setting size of the window
        setSize(1500,800);
        // setting locations from left and top
        setLocation(22,7);
        // making our window visible
        setVisible(true);

        while(true){
            heading3.setVisible(false);
            try{
                Thread.sleep(250);
            }catch(Exception e){

            }

            heading3.setVisible(true);
            try{
                Thread.sleep(250);
            }catch(Exception e){

            }
        }
    }

    // overriding abstract method
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Splash();

    }
}
