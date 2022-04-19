<%@ page import="lcb.app.uadb.config.Script" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="layout/header.jsp"%>
<%! String pageTitle = "Bienvenu sur UADB"; %>
<%!
    String[] styles = new String[]{
            StyleSheet.CORE, StyleSheet.FONTICON, StyleSheet.STYLE
    };
%>
<%!
    String[] scripts = new String[]{
            Script.CORE, Script.SCRIPT, Script.PROCESS, Script.LAYOUT_SETTING
    };
%>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<%@include file="layout/footer.jsp"%>
