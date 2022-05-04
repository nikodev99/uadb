<%@ page import="java.util.List" %>
<%
  List<String> errorList = (List<String>) session.getAttribute("errors");
  if (errorList != null && !errorList.isEmpty()) { %>
      <ul class="alert alert-danger">
        <% for (String s : errorList){ %>
        <li><i class="fa fa-question-circle"></i> <%= s %></li>
        <% } %>
      </ul>
<% }
  session.removeAttribute("errors");
%>
