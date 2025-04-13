<%-- 
    Document   : newjsp
    Created on : 8 Apr, 2025, 12:03:52 PM
    Author     : Sujal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UseBean</title>
    </head>
    <body>
        <jsp:useBean class="newpackage.NewClass" id="t"/>
        <%
            int x = Integer.parseInt(request.getParameter("value"));
            int res = t.square(x);
            out.print("Square is= "+res);
        %>
    </body>
</html>
