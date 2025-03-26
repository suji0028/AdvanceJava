package com.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String validUsername = "admin";
        String validPassword = "password123";
        
        if(username.equals(validUsername) && password.equals(validPassword)) {

            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("welcome.html");
        } else {
            out.println("<h2>Login Failed</h2>");
            out.println("<p>Invalid username or password</p>");
            out.println("<a href='index.html'>Try Again</a>");
           
        }
    }
}