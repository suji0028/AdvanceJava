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
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewServlet extends HttpServlet {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int data;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/employee", "root", "");
            
            String query="select * from empl";
            
            Statement st=(Statement) con.createStatement();
            rs=st.executeQuery(query);
            
            out.println("<table width='300' border='2'>");
            out.println("<tr>");
            out.println("<th>ENO</th>");
            out.println("<th>ENAME</th>");
            out.println("<th>Delete</th>");
            out.println("<th>Edit</th>");
            out.println("</tr>");
            
            while(rs.next())
            {
                out.println("<tr>");
                 out.println("<td>"+rs.getString("eno")+"</td> ");
                 out.println("<td>"+rs.getString("ename")+"</td> ");
                 out.println("<td>"+"<a href='DeleteServlet?eno="
                         +rs.getString("eno")+"'>Delete</a>"+"</td>");
                 out.println("<td>"+"<a href='EditServlet?eno="+rs.getString("eno")+"'>Edit</a>"+"</td>");
                 out.println("</tr>");
            }
                out.println("</table>");
                   out.println("<a href='index.html'>Home</a>");
           } 
        catch (ClassNotFoundException ex) {
         } 
        catch (SQLException ex) {
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
