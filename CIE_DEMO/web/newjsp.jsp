<%-- 
    Document   : first
    Created on : 19 Mar, 2025, 1:52:12 PM
    Author     : Sujal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--Commented Box--%>
        <%
            
            int a = Integer.parseInt(request.getParameter("first"));
            int b = Integer.parseInt(request.getParameter("second"));
            
            int sum = a+b;
            out.println("Sum is = "+sum);
        %>
        <%= "welcome to jsp!!!"%>
        
        <%! int a=10; %>
        <%= "Value is = "+a %>1
    </body>
</html>
