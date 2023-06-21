package COLLEGE_MANAGEMENT;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class View extends JFrame implements ActionListener {
    JTable table;
    JButton bk;
    View(){
        Color c = new Color(1,42,51);
        getContentPane().setBackground(c);
        setLayout(null);


        table = new JTable();


        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane jp = new  JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);


        JLabel heading = new JLabel("Student Details");
        heading.setFont(new Font("playfair display",Font.BOLD,40));
        heading.setForeground(Color.PINK);
        heading.setBounds(300,30,500,50);
        add(heading);

        bk = new JButton("BACK");
        bk.setBounds(790,30,80,50);
        bk.setBackground(Color.BLACK);
        Color bts = new Color(102,196,217);
        bk.setForeground(bts);
        bk.setFont(new Font("Raleway",Font.BOLD,15));
        bk.addActionListener(this);
        add(bk);

        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == bk){
            setVisible(false);
            new Home();
        }
        else{
            setVisible(true);
        }
    }
    public static void main(String[] args) {
        new View();
    }
}
