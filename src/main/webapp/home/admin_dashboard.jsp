<%@ page import="lcb.app.uadb.user.UserBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserBean user = (UserBean)request.getAttribute("loggedUser");
%>
<h1><%= user.getFirstName() + " " + user.getLastName() %></h1>
