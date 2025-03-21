import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeServlet extends HttpServlet {

    PreparedStatement ps;
    ResultSet rs;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con=(Connection) DriverManager.getConnection
                   ("jdbc:mysql://localhost/employee", "root", "");
            
            Statement st=(Statement) con.createStatement();
                        
            String eno=request.getParameter("eno");
            String ename=request.getParameter("ename");   
            
//         String query="create table empl(eno int,ename varchar(20))";
        
  //          st.execute(query);
            out.println("Table Created...");
           
            ps=(PreparedStatement) con.prepareStatement("insert into empl(eno,ename)values(?,?)");
            ps.setString(1, eno);
            ps.setString(2, ename);
            int data=ps.executeUpdate();
            out.println("Record Inserted!!!!");
           rs=st.executeQuery("select * from empl");
            while(rs.next())
          {
            out.println(rs.getInt(1)+" "+rs.getString(2));
           }
                     
            con.close();
        } 
        catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
