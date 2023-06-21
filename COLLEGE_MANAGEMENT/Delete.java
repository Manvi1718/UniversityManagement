package COLLEGE_MANAGEMENT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Delete extends JFrame implements ActionListener {
    private Choice enrollId;
    JButton del, bk;


    Delete() {
        Color c1 = new Color(1,62,79);
        getContentPane().setBackground(c1);
        setLayout(null);

        JLabel heading = new JLabel("Delete Student");
        heading.setFont(new Font("playfair display", Font.BOLD, 40));
        heading.setForeground(Color.red);
        heading.setBounds(300, 30, 500, 50);
        add(heading);

        JLabel enroll = new JLabel("Enrollment No:");
        enroll.setBounds(50, 200, 200, 30);
        enroll.setForeground(Color.white);
        enroll.setFont(new Font("serif", Font.PLAIN, 30));
        add(enroll);

        enrollId = new Choice();
        enrollId.setBounds(320, 205, 200, 50);
        add(enrollId);

        try {
            Conn con = new Conn();
            String query = "SELECT * FROM student";
            ResultSet rs = con.s.executeQuery(query);
            while (rs.next()) {
                enrollId.add(rs.getString("enrollment_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelname = new JLabel("Name:");
        labelname.setBounds(50, 270, 200, 30);
        labelname.setForeground(Color.white);
        labelname.setFont(new Font("serif", Font.PLAIN, 30));
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(300, 270, 200, 30);
        lblname.setForeground(Color.white);
        lblname.setFont(new Font("serif", Font.PLAIN, 30));
        add(lblname);

        // semester
        JLabel labelsem = new JLabel("Semester:");
        labelsem.setBounds(50, 340, 200, 30);
        labelsem.setForeground(Color.white);
        labelsem.setFont(new Font("serif", Font.PLAIN, 30));
        add(labelsem);

        JLabel lblsem = new JLabel();
        lblsem.setBounds(300, 340, 200, 30);
        lblsem.setForeground(Color.white);
        lblsem.setFont(new Font("serif", Font.PLAIN, 30));
        add(lblsem);

        // course
        JLabel labelc = new JLabel("Course:");
        labelc.setBounds(50, 410, 200, 30);
        labelc.setForeground(Color.white);
        labelc.setFont(new Font("serif", Font.PLAIN, 30));
        add(labelc);

        JLabel lblc = new JLabel();
        lblc.setBounds(300, 410, 200, 30);
        lblc.setForeground(Color.white);
        lblc.setFont(new Font("serif", Font.PLAIN, 30));
        add(lblc);

        enrollId.addItemListener(e -> {
            try {
                Conn con = new Conn();
                String query = "SELECT * FROM student WHERE enrollment_id = '" + enrollId.getSelectedItem() + "'";
                ResultSet rs = con.s.executeQuery(query);
                while (rs.next()) {
                    lblname.setText(rs.getString("name"));
                    lblsem.setText(rs.getString("semester"));
                    lblc.setText(rs.getString("course"));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        enrollId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn con = new Conn();
                    String query = "SELECT * FROM student WHERE enrollment_id = '" + enrollId.getSelectedItem() + "'";
                    ResultSet rs = con.s.executeQuery(query);
                    while (rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblsem.setText(rs.getString("semester"));
                        lblc.setText(rs.getString("course"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        bk = new JButton("BACK");
        bk.setBounds(230,500,100,60);
        bk.setBackground(Color.BLACK);
        Color bts = new Color(102,196,217);
        bk.setForeground(bts);
        bk.setFont(new Font("Raleway",Font.BOLD,15));
        bk.addActionListener(this);
        add(bk);

        del = new JButton("Delete");
        del.setBounds(450,500,100,60);
        del.setBackground(Color.BLACK);
        del.setForeground(Color.red );
        del.setFont(new Font("Raleway",Font.BOLD,15));
        del.addActionListener(this);
        add(del);


        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==del){
            try{
                Conn c= new Conn();
                String query = "delete from student where enrollment_id = '"+enrollId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student Information Deleted Successfully");
                setVisible(false);
                new Home();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new Delete();
    }
}

