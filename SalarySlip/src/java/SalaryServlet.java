import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SalaryServlet") 
public class SalaryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {  
            
            String name = request.getParameter("name");
            String id = request.getParameter("id");
            double basicSalary = Double.parseDouble(request.getParameter("basicSalary"));

            double hra = 0.10 * basicSalary;
            double ta = 0.15 * basicSalary;
            double pf = 0.20 * basicSalary;
            
            double bonus;
            if (basicSalary > 40000) {
                bonus = 0.20 * basicSalary;
            } else if (basicSalary > 30000) {
                bonus = 0.15 * basicSalary;
            } else if (basicSalary > 25000) {
                bonus = 0.12 * basicSalary;
            } else if (basicSalary > 20000) {
                bonus = 0.10 * basicSalary;
            } else {
                bonus = 0;
            }

            double netSalary = basicSalary + hra + ta + bonus - pf;
         
            out.println("<h2>Salary Slip</h2>");
            out.println("Employee Name:  " + name);
            out.println("Employee ID:  " + id);
            out.println("Basic Salary:  " + basicSalary);
            out.println("HRA (10%):  " + hra);
            out.println("TA (15%):  " + ta);
            out.println("PF (20%):  " + pf);
            out.println("Bonus:  " + bonus);
            out.println("<h3>Net Salary:  " + netSalary);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Salary Servlet for calculating employee salary";
    }
}
