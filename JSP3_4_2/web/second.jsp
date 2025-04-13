<%-- 
    Document   : second
    Created on : 3 Apr, 2025, 10:53:15 AM
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
           // String unm=(String)session.getAttribute("unm");
            String unm=(String)pageContext.getAttribute("unm",PageContext.SESSION_SCOPE);
            out.print("Hello "+unm);
        %>
    </body>
</html>
