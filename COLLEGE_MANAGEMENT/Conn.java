package COLLEGE_MANAGEMENT;
import java.sql.*;
public class Conn {
    //Interface
    Connection c;
    Statement s ;
    public Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //making connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","Manvi@1718");

            // creating statement
            s = c.createStatement();


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

