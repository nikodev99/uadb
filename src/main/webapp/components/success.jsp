<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String successMessage = (String) session.getAttribute("success");
    if (successMessage != null && !successMessage.isEmpty()) { %>
        <div class="alert alert-success">
            <span><i class="fa fa-exclamation-circle"></i> <%= successMessage %></span>
        </div>
<% }
    session.removeAttribute("success");
%>
