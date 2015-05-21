<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    
	<head>
        
        <!-- Title -->
        <title>Modern | Login - Sign in</title>
        
        <meta content="width=device-width, initial-scale=1" name="viewport"/>
        <meta charset="UTF-8">
        <meta name="description" content="Admin Dashboard Template" />
        <meta name="keywords" content="admin,dashboard" />
        <meta name="author" content="Steelcoders" />
        
        <!-- Styles -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'>
        <link href="<c:url value="resources/plugins/pace-master/themes/blue/pace-theme-flash.css"/>" rel="stylesheet"/>
        <link href="<c:url value="resources/plugins/uniform/css/uniform.default.min.css"/>" rel="stylesheet"/>
        <link href="<c:url value="resources/plugins/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/plugins/fontawesome/css/font-awesome.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/plugins/line-icons/simple-line-icons.css"/>" rel="stylesheet" type="text/css"/>	
        <link href="<c:url value="resources/plugins/offcanvasmenueffects/css/menu_cornerbox.css"/>" rel="stylesheet" type="text/css"/>	
        <link href="<c:url value="resources/plugins/waves/waves.min.css"/>" rel="stylesheet" type="text/css"/>	
        <link href="<c:url value="resources/plugins/switchery/switchery.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/plugins/3d-bold-navigation/css/style.css"/>" rel="stylesheet" type="text/css"/>	
        
        <!-- Theme Styles -->
        <link href="<c:url value="resources/css/modern.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/css/themes/white.css"/>" class="theme-color" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/css/custom.css"/>" rel="stylesheet" type="text/css"/>
        
        <script src="<c:url value="resources/plugins/3d-bold-navigation/js/modernizr.js"/>"></script>
        <script src="<c:url value="resources/plugins/offcanvasmenueffects/js/snap.svg-min.js"/>"></script>
      
    </head>
    <body class="page-login">
        <div class="page-content">
            <div class="page-inner">
                <div id="main-wrapper">
                    <div class="row">
                        <div class="col-md-3 center">
                            <div class="login-box">
                                <a href="index.html" class="logo-name text-lg text-center">Modern</a>
                                <p class="text-center m-t-md">Please login into your account.</p>
                                <form class="m-t-md" action="http://lambdathemes.in/modern/index.html">
                                    <div class="form-group">
                                        <input type="email" class="form-control" placeholder="Email" required>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control" placeholder="Password" required>
                                    </div>
                                    <button type="submit" class="btn btn-success btn-block">Login</button>
                                    <a href="forgot.html" class="display-block text-center m-t-md text-sm">Forgot Password?</a>
                                    <p class="text-center m-t-xs text-sm">Do not have an account?</p>
                                    <a href="register.html" class="btn btn-default btn-block m-t-md">Create an account</a>
                                </form>
                                <p class="text-center m-t-xs text-sm">2015 &copy; Modern by Steelcoders.</p>
                            </div>
                        </div>
                    </div><!-- Row -->
                </div><!-- Main Wrapper -->
            </div><!-- Page Inner -->
        </div><!-- Page Content -->
	

        <!-- Javascripts -->
        <script src="<c:url value="resources/plugins/jquery/jquery-2.1.3.min.js"/>"></script>
        <script src="<c:url value="resources/plugins/jquery-ui/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="resources/plugins/pace-master/pace.min.js"/>"></script>
        <script src="<c:url value="resources/plugins/jquery-blockui/jquery.blockui.js"/>"></script>
        <script src="<c:url value="resources/plugins/bootstrap/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="resources/plugins/jquery-slimscroll/jquery.slimscroll.min.js"/>"></script>
        <script src="<c:url value="resources/plugins/switchery/switchery.min.js"/>"></script>
        <script src="<c:url value="resources/plugins/uniform/jquery.uniform.min.js"/>"></script>
        <script src="<c:url value="resources/plugins/offcanvasmenueffects/js/classie.js"/>"></script>
        <script src="<c:url value="resources/plugins/offcanvasmenueffects/js/main.js"/>"></script>
        <script src="<c:url value="resources/plugins/waves/waves.min.js"/>"></script>
        <script src="<c:url value="resources/plugins/3d-bold-navigation/js/main.js"/>"></script>
        <script src="<c:url value="resources/js/modern.min.js"/>"></script>
        
    </body>

</html>
