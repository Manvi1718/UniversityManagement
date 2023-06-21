package COLLEGE_MANAGEMENT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    JButton add,update,view,del;
    Home(){

        // IMAGE of home page
        // getting image from system
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("images/Home_photo.jpg"));
        // setting the height width of image by image it of image class
        Image i8 = i7.getImage().getScaledInstance(1280,720,Image.SCALE_DEFAULT);
        // from image class converting to imageIcon
        ImageIcon i9 = new ImageIcon(i8);
        // making a label to add it in window
        JLabel image3 = new JLabel(i9);
        // setting the height width of image and also locations from x and y
        image3.setBounds(0,0,226,221);
        // add the image to window
        add(image3);

        JLabel heading = new JLabel("Welcome To IGDTUW");
        heading.setBounds(680,40,500,40);
        heading.setFont(new Font("TAHOMA",Font.BOLD,45));
        Color head = new Color(0,0,0);
        heading.setForeground(head);
        image3.add(heading);

    //  BUTTON 1 ADD
        add = new JButton("ADD");
        add.setBounds(700,200,200,60);
        add.setBackground(Color.BLACK);
        Color bts = new Color(102,196,217);
        add.setForeground(bts);
        add.setFont(new Font("Raleway",Font.BOLD,20));
        add.addActionListener(this);
        image3.add(add);

    //BUTTON 2 VIEW
        view = new JButton("VIEW");
        view.setBounds(950,200,200,60);
        view.setBackground(Color.BLACK);
        view.setForeground(bts);
        view.setFont(new Font("Raleway",Font.BOLD,20));
        view.addActionListener(this);
        image3.add(view);

//    // BUTTON 3 logout
//        update = new JButton("LOG OUT");
//        update.setBounds(800,570,350,50);
//        update.setBackground(Color.BLACK);
//        Color bts1 = new Color(255, 215, 4);
//        update.setForeground(bts1);
//        update.setFont(new Font("Raleway",Font.BOLD,20));
//        update.addActionListener(this);
//        image3.add(update);

    // BUTTON 4 DELETE
        del = new JButton("DELETE");
        del.setBounds(950,370,200,60);
        del.setBackground(Color.BLACK);
        del.setForeground(bts);
        del.setFont(new Font("ariel",Font.BOLD,20));
        del.addActionListener(this);
        image3.add(del);

        setSize(1280,720);
        setLocation(120,50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==add){
            setVisible(false);
            new AddStudent();
        }
        else if(e.getSource() == view){
            setVisible(false);
            new View();
        }
        else{
            setVisible(false);
            new Delete();
        }
    }

    public static void main(String[] args) {
        new Home();

    }
}
