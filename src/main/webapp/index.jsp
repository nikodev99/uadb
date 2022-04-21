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
<%
    System.out.println(session.getAttribute("errors"));
%>
<div class="login-header box-shadow">
    <div class="container-fluid d-flex justify-content-between align-items-center">
        <div class="brand-logo">
            <a href="login.html">
                <span>UADB</span>
            </a>
        </div>
    </div>
</div>
<div class="login-wrap d-flex align-items-center flex-wrap justify-content-center">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-6 col-lg-7">
                <img src="vendors/images/login-page-img.png" alt="">
            </div>
            <div class="col-md-6 col-lg-5">
                <div class="login-box bg-white box-shadow border-radius-10">
                    <div class="login-title">
                        <h2 class="text-center text-primary">Connexion à UADB</h2>
                    </div>
                    <form action="login" method="POST">
                        <div class="select-role">
                            <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                <div class="alert alert-danger">Nom d'utilisateur ou mot de passe incorrect</div>
                            </div>
                        </div>
                        <div class="input-group custom">
                            <input type="text" name="username" class="form-control form-control-lg" placeholder="Nom d'utilisateur ou email">
                            <div class="input-group-append custom">
                                <span class="input-group-text"><i class="icon-copy dw dw-user1"></i></span>
                            </div>
                        </div>
                        <div class="input-group custom">
                            <input type="password" name="password" class="form-control form-control-lg" placeholder="**********">
                            <div class="input-group-append custom">
                                <span class="input-group-text"><i class="dw dw-padlock1"></i></span>
                            </div>
                        </div>
                        <div class="row pb-30">
                            <div class="col-6">
                                <div class="forgot-password"><a href="forgot-password.html">Mot de passe oublié</a></div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="input-group mb-0">
                                        <input class="btn btn-primary btn-lg btn-block" type="submit" value="Se connecter">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="layout/footer.jsp"%>
