<%@ page import="lcb.app.uadb.config.StyleSheet" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="lcb.app.uadb.config.Configuration" %>
<%@ page import="java.util.Locale" %>
<%
    pageContext.setAttribute("pageTitle", "UADB");
    pageContext.setAttribute("styles", new String[]{});
    String[] urlParts = request.getRequestURL().toString().split("/");
    System.out.println("URLS: " + Arrays.toString(urlParts));
    String contextPath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";

    boolean loginPage = Configuration.getLastElementOfList(urlParts).toUpperCase(Locale.ROOT).equals("UADB") || Arrays.asList(urlParts).contains("login");
%>
<!DOCTYPE html>
<html>
<head>
    <!-- Basic Page Info -->
    <meta charset="utf-8">
    <title><%= pageTitle %></title>

    <!-- Site favicon -->
    <link rel="apple-touch-icon" sizes="180x180" href="vendors/images/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="vendors/images/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="vendors/images/favicon-16x16.png">

    <!-- Mobile Specific Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- Google Font -->
    <link href="<%= StyleSheet.FONT %>" rel="stylesheet">
    <!-- CSS -->
    <%= StyleSheet.setCssStyle(contextPath, styles) %>
    <link rel="stylesheet" href="<%= contextPath + "layout/assets/styles/main.css" %>">
</head>
<body class="<%= loginPage ? "login-page" : "" %>">
<% if (!loginPage) { %>

<% } %>
