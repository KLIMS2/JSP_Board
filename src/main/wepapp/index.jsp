<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div>JSP_Board Test site</div>

<%
    for(int a = 2; a <= 9; a++)
    {
%>
        <a href="http://localhost:8080/gugudan.jsp?dan=<%=a%>">--> gugudan<%=a%></a>
<%
    }
%>

<style>
    a {
        display: block;
    }

    a:hover {
        color: red;
    }
</style>
