<%-- 
    Document   : tag1
    Created on : 8 Apr, 2025, 12:55:40 PM
    Author     : Sujal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--<c:out value="Welcome to JSTL"/>--%>
        
        <%--
        <c:set var="a" value="5"/>
        <c:out value="Value is = ${a}"/><br>
        <c:remove var="a"/>
        <c:out value="Value is = ${a}"/><br>
        --%>
        
        <%--
        <c:set var="b" value="5"/>
        <c:set var="c" value="5"/>
        <c:set var="sum" value="${b+c}"/>
        <c:out value="Sum is = ${sum}"/>
        --%>
        
        <br>
        Import Data
        <c:import url="newjsp.jsp"/>
        <%--<c:redirect url="https://www.youtube.com"/>--%>
        
        <%--
        <c:set var="a" value="4"/>
        <c:if test="${a%2==0}">
            <c:out value="Even No"/>
        </c:if>
        <c:if test="${a%2==1}">
            <c:out value="Odd No"/>
        </c:if>
        --%>
        
        <%--
        <c:set var="a" value="0"/>
        <c:choose>
            <c:when test="${a>0}">
                <c:out value="Positive"/>
            </c:when>
            <c:when test="${a<0}">
                <c:out value="Negative"/>
            </c:when>
            <c:otherwise>
                <c:out value="Zero"/>
            </c:otherwise>
        </c:choose>
        --%>
        
        <%--
        <c:forEach var="i" begin="1" end="10" step="2">
            <c:out value="${i}"/>
        </c:forEach> 
        --%>
        
        <%--
        <c:set var="a" value="Hello JSTL Tags"/>
        
        <c:forTokens items="${a}" var="s" delims="">
            <c:out value="${s}"/><br>
        </c:forTokens>
        --%>
        
        <%--
        <c:catch var="e">
            <%
                int a=10/0;
                out.print("a");
            %>
        </c:catch>
        <c:if test="${e!=null}">
            <c:out value="Exception generated !!! Exception is ${e}"/>
        </c:if>
        --%>
        
        <%--
        <c:url var="myurl" value="https://www.google.com/search">
            <c:param name="query" value="Lamborghini Veneno"/>
        </c:url>
        
        <c:redirect url="${myurl}"/>
        --%>
        
    </body>
</html>
