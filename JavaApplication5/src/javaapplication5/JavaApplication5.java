package javaapplication5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaApplication5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection to the 'client' database
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/client", "root", "")) {
            
            // Create a statement object to execute queries
            Statement st = con.createStatement();
            
            // Create table e2
            String createTableQuery = "CREATE TABLE e2 (eno INT, ename VARCHAR(20))";
            st.execute(createTableQuery);
            System.out.println("Table 'e2' created successfully!");

            // Insert data into the table e2 (not e1)
            st.executeUpdate("INSERT INTO e2 VALUES(1, 'Arjun')");
            st.executeUpdate("INSERT INTO e2 VALUES(2, 'Devraj')");
            st.executeUpdate("INSERT INTO e2 VALUES(3, 'Jeet')");
            System.out.println("Data inserted successfully!");

            // Retrieve and display data from e2
            ResultSet rs = st.executeQuery("SELECT * FROM e2");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
