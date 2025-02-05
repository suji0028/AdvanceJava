
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
public class NewServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) 
            throws ServletException, IOException {
                
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            
            out.print("Hello I am Generic Servlet");
        
    }
 }
*/
public class NewServlet implements Servlet {

        ServletConfig config = null;
        
    @Override
    public void init(ServletConfig config) throws ServletException {
       this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            
            out.print("Hello I am in Servlet Interface");
    }
    
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
       System.out.println("Servlet Destroy!!!");
    }
    
 }
