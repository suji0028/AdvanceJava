import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
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

public class EditServlet extends HttpServlet {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int data;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String eno=request.getParameter("eno");
                
        try (PrintWriter out = response.getWriter()) {

            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/employee", "root", "");
    
            ps=(PreparedStatement) con.prepareStatement("select * from empl where eno=?");
            
            ps.setString(1, eno);
            rs=ps.executeQuery();
            
            while(rs.next())
            {
                out.print("<form action='EditData' method='post'>");
                out.print("<table width='300' border='2'>");
                out.println("<tr>");
                out.println("<td>Empno</td> <td><input type='text' name='eno' value= ' "+rs.getString("eno")+" '/></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Empname</td> <td><input type='text' name='ename' value= '"+rs.getString("ename")+"'/></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td colspan='2'><input type='submit' value= 'Edit'/></td>");
                out.println("</tr>");
            }
            

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
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
