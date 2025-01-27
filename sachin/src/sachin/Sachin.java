/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sachin;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import com.sun.imageio.plugins.jpeg.JPEG;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class Sachin {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/client","root","");
        
        Statement st=(Statement) con.createStatement();
        
        String query="create table e1(eno int,ename varchar(20))";
        st.execute(query);
        
        System.out.println("Table is created!!!");
        
        st.executeUpdate("insert into e1 values(1, 'Ram')");
        st.executeUpdate("insert into e1 values(2, 'Raj')");
        st.executeUpdate("insert into e1 values(3, 'Dev')");
        
        System.out.println("Records are installed!!!");
        ResultSet rs=st.executeQuery("seiect * from e1");
        while(rs.next())
        {
            System.out.println(rs.getInt(1)+" "+rs.getString(2));
        }
     }
}