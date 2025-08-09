<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    int dan = request.getParameter("dan") == null ? 2 : Integer.parseInt(request.getParameter("dan"));
%>

<h3>--> <%=dan%>단 <--</h3>

<%
    for(int a = 1; a <= 9; a++)
    {
%>
        <div><%=dan%> * <%=a%> = <%=dan * a%></div>
<%
    }
%>

<a href="http://localhost:8080/">back</a>