<%-- 
    Document   : newjsp
    Created on : 8 Apr, 2025, 12:25:33 PM
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
        <jsp:useBean class="newpackage.NewClass" id="t"/>
        
        <jsp:setProperty property="*" name="t"/>
        
        |My Data|<br><br>
        Username :<jsp:getProperty name="t" property="unm"/><br><br>
        Password :<jsp:getProperty name="t" property="pwd"/><br>
       
    </body>
</html>
