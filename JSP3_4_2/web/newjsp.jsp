<%-- 
    Document   : newjsp
    Created on : 3 Apr, 2025, 10:32:58 AM
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
       <%
           String name=request.getParameter("uname");
           out.print("Welcome "+name);
           //session.setAttribute("unm", name);
           pageContext.setAttribute("unm", name,PageContext.SESSION_SCOPE);
       %>
       <a href="second.jsp">Second JSP Page</a>
    </body>
</html>
