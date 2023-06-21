package COLLEGE_MANAGEMENT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JOptionPane;

import java.awt.event.*;
public class AddStudent extends JFrame implements ActionListener {
    Random ran = new Random();
    int num = ran.nextInt(999999);

    JTextField tname,tffname,tfc,tfs;


    JLabel tfe;
    JButton add , bk;


    AddStudent(){

        Color c = new Color(1,42,51);
        getContentPane().setBackground(c);
        setLayout(null);

        JLabel heading = new JLabel("Add Student Details");
        heading.setFont(new Font("playfair display",Font.BOLD,40));
        heading.setForeground(Color.PINK);
        heading.setBounds(300,30,500,50);
        add(heading);
    //STUDENT NAME
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(80,150,150,30);
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("serif",Font.PLAIN,30));
        add(lblName);

        tname = new JTextField();
        tname.setBounds(260,153,150,30);
        add(tname);

    //FATHERS NAME
        JLabel lblfName = new JLabel("father's name");
        lblfName.setBounds(480,153,300,30);
        lblfName.setForeground(Color.WHITE);
        lblfName.setFont(new Font("serif",Font.PLAIN,30));
        add(lblfName);

        tffname = new JTextField();
        tffname.setBounds(680,153,150,30);
        add(tffname);

    //  COURSE
        JLabel course = new JLabel("Course");
        course.setBounds(480,250,300,30);
        course.setForeground(Color.WHITE);
        course.setFont(new Font("serif",Font.PLAIN,30));
        add(course);

        tfc = new JTextField();
        tfc.setBounds(680,253,150,30);
        add(tfc);
    //SEMESTER
        JLabel sem = new JLabel("Semester");
        sem.setBounds(80,250,300,30);
        sem.setForeground(Color.WHITE);
        sem.setFont(new Font("serif",Font.PLAIN,30));
        add(sem);

        tfs = new JTextField();
        tfs.setBounds(253,253,150,30);
        add(tfs);
    // ENROLLMENT
        JLabel enrl = new JLabel("Enrollment number ");
        enrl.setBounds(80,450,300,30);
        enrl.setForeground(Color.WHITE);
        enrl.setFont(new Font("serif",Font.PLAIN,30));
        add(enrl);

        tfe = new JLabel(""+num);
        tfe.setBounds(400,450,150,30);
        tfe.setForeground(Color.white);
        tfe.setFont(new Font("serif",Font.PLAIN,25));
        add(tfe);

        add = new JButton("ADD");
        add.setBounds(350,550,200,60);
        add.setBackground(Color.BLACK);
        Color bts = new Color(102,196,217);
        add.setForeground(bts);
        add.setFont(new Font("Raleway",Font.BOLD,20));
        add.addActionListener(this);
        add(add);

        bk = new JButton("BACK");
        bk.setBounds(600,550,200,60);
        bk.setBackground(Color.BLACK);
        bk.setForeground(bts);
        bk.setFont(new Font("Raleway",Font.BOLD,20));
        add(bk);

        setSize(900,700);
        setLocation(300,50);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String name = tname.getText();
            String fname = tffname.getText();
            String course = tfc.getText();
            int  seme = Integer.parseInt(tfs.getText());
            String enroll = tfe.getText();

            try{
                Conn conn = new Conn();
                String query1 = "insert into student values ('"+name+"','"+fname+"','"+course+"','"+seme+"','"+enroll+"')";
                conn.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null,"details added successfully");
                setVisible(false);
                new Home();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
