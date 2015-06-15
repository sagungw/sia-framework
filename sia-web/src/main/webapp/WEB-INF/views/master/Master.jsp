<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="function" uri="http://taglibs/custom" %>

<!DOCTYPE html>
<html>
	<head>
		<!-- Title -->
		<link rel="shotcut icon" href="${pageContext.servletContext.contextPath}/resources/icon.ico">
        <title>
        	<decorator:title default="Sistem Informasi Akademik"></decorator:title>
        </title>
        
        <meta content="width=device-width, initial-scale=1" name="viewport"/>
        <meta charset="UTF-8">
        <meta name="description" content="Admin Dashboard Template" />
        <meta name="keywords" content="admin,dashboard" />
        <meta name="author" content="Steelcoders" />
        
       	<!-- Styles -->
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'>
		<link href="${pageContext.servletContext.contextPath}/resources/plugins/uniform/css/uniform.default.min.css" rel="stylesheet" />
		<link href="${pageContext.servletContext.contextPath}/resources/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.servletContext.contextPath}/resources/plugins/fontawesome/css/font-awesome.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.servletContext.contextPath}/resources/plugins/line-icons/simple-line-icons.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.servletContext.contextPath}/resources/plugins/waves/waves.min.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.servletContext.contextPath}/resources/plugins/switchery/switchery.min.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.servletContext.contextPath}/resources/plugins/3d-bold-navigation/css/style.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.servletContext.contextPath}/resources/plugins/slidepushmenus/css/component.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.servletContext.contextPath}/resources/plugins/toastr/toastr.min.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.servletContext.contextPath}/resources/plugins/bootstrap-datepicker/css/datepicker3.css" rel="stylesheet" type="text/css"/>
					
		<!-- Theme Styles -->
		<link href="${pageContext.servletContext.contextPath}/resources/css/modern.min.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.servletContext.contextPath}/resources/css/themes/white.css" class="theme-color" rel="stylesheet" type="text/css" />
		<link href="${pageContext.servletContext.contextPath}/resources/css/custom.css" rel="stylesheet" type="text/css" />
		
		<script src="${pageContext.servletContext.contextPath}/resources/plugins/3d-bold-navigation/js/modernizr.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/plugins/offcanvasmenueffects/js/snap.svg-min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/plugins/jquery/jquery-2.1.3.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/plugins/toastr/toastr.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/plugins/jquery-ui/jquery-ui.min.js"></script>
	
		<script>
			var context_path = "${pageContext.servletContext.contextPath}/";
		</script>
    </head>
    
    <body class="page-header-fixed page-horizontal-bar">
        <form class="search-form" action="#" method="GET">
            <div class="input-group">
                <input type="text" name="search" class="form-control search-input" placeholder="Search...">
                <span class="input-group-btn">
                    <button class="btn btn-default close-search waves-effect waves-button waves-classic" type="button"><i class="fa fa-times"></i></button>
                </span>
            </div><!-- Input Group -->
        </form><!-- Search Form -->
        <div class="page-content content-wrap">
            <div class="navbar">
                <div class="navbar-inner">
                    <div class="sidebar-pusher">
                        <a href="javascript:void(0);" class="waves-effect waves-button waves-classic push-sidebar">
                            <i class="fa fa-bars"></i>
                        </a>
                    </div>
                    <div class="logo-box">
                        <a href="index.html" class="logo-text"><span>Modern</span></a>
                    </div><!-- Logo Box -->
                    <div class="search-button">
                        <a href="javascript:void(0);" class="waves-effect waves-button waves-classic show-search"><i class="fa fa-search"></i></a>
                    </div>
                    <div class="topmenu-outer">
                        <div class="top-menu">
                            <ul class="nav navbar-nav navbar-left">
                            	<li>
                                    <a href="javascript:void(0);" class="waves-effect waves-button waves-classic sidebar-toggle"><i class="fa fa-bars"></i></a>
                                </li>
                                <li>		
                                    <a href="javascript:void(0);" class="waves-effect waves-button waves-classic toggle-fullscreen"><i class="fa fa-expand"></i></a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle waves-effect waves-button waves-classic" data-toggle="dropdown">
                                        <i class="fa fa-cogs"></i>
                                    </a>
                                    <ul class="dropdown-menu dropdown-md dropdown-list theme-settings" role="menu">
                                        <li class="li-group">
                                            <ul class="list-unstyled">
                                                <li class="no-link" role="presentation">
                                                    Fixed Header 
                                                    <div class="ios-switch pull-right switch-md">
                                                        <input type="checkbox" class="js-switch pull-right fixed-header-check" checked>
                                                    </div>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="li-group">
                                            <ul class="list-unstyled">
                                                <li class="no-link" role="presentation">
                                                    Fixed Sidebar 
                                                    <div class="ios-switch pull-right switch-md">
                                                        <input type="checkbox" class="js-switch pull-right fixed-sidebar-check">
                                                    </div>
                                                </li>
                                                <li class="no-link" role="presentation">
                                                    Horizontal bar 
                                                    <div class="ios-switch pull-right switch-md">
                                                        <input type="checkbox" class="js-switch pull-right horizontal-bar-check" checked>
                                                    </div>
                                                </li>
                                                <li class="no-link" role="presentation">
                                                    Toggle Sidebar 
                                                    <div class="ios-switch pull-right switch-md">
                                                        <input type="checkbox" class="js-switch pull-right toggle-sidebar-check">
                                                    </div>
                                                </li>
                                                <li class="no-link" role="presentation">
                                                    Compact Menu 
                                                    <div class="ios-switch pull-right switch-md">
                                                        <input type="checkbox" class="js-switch pull-right compact-menu-check">
                                                    </div>
                                                </li>
                                                <li class="no-link" role="presentation">
                                                    Hover Menu 
                                                    <div class="ios-switch pull-right switch-md">
                                                        <input type="checkbox" class="js-switch pull-right hover-menu-check">
                                                    </div>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="li-group">
                                            <ul class="list-unstyled">
                                                <li class="no-link" role="presentation">
                                                    Boxed Layout 
                                                    <div class="ios-switch pull-right switch-md">
                                                        <input type="checkbox" class="js-switch pull-right boxed-layout-check">
                                                    </div>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="no-link"><button class="btn btn-default reset-options">Reset Options</button></li>
                                    </ul>
                                </li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <li>	
                                    <a href="javascript:void(0);" class="waves-effect waves-button waves-classic show-search"><i class="fa fa-search"></i></a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle waves-effect waves-button waves-classic" data-toggle="dropdown">
                                        <span class="user-name">David<i class="fa fa-angle-down"></i></span>
                                        <img class="img-circle avatar" src="${pageContext.servletContext.contextPath}/resources/images/avatar1.png" width="40" height="40" alt="">
                                    </a>
                                    <ul class="dropdown-menu dropdown-list" role="menu">
                                        <li role="presentation"><a href="profile.html"><i class="fa fa-user"></i>Profile</a></li>
                                        <li role="presentation"><a href="calendar.html"><i class="fa fa-calendar"></i>Calendar</a></li>
                                        <li role="presentation"><a href="inbox.html"><i class="fa fa-envelope"></i>Inbox<span class="badge badge-success pull-right">4</span></a></li>
                                        <li role="presentation" class="divider"></li>
                                        <li role="presentation"><a href="lock-screen.html"><i class="fa fa-lock"></i>Lock screen</a></li>
                                        <li role="presentation"><a href="login.html"><i class="fa fa-sign-out m-r-xs"></i>Log out</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="login.html" class="log-out waves-effect waves-button waves-classic">
                                        <span><i class="fa fa-sign-out m-r-xs"></i>Log out</span>
                                    </a>
                                </li>
                            </ul><!-- Nav -->
                        </div><!-- Top Menu -->
                    </div>
                </div>
            </div><!-- Navbar -->
            
            <div class="horizontal-bar sidebar">
                <div class="page-sidebar-inner slimscroll">
                    <div class="sidebar-header">
                        <div class="sidebar-profile">
                            <a href="javascript:void(0);" id="profile-menu-link">
                                <div class="sidebar-profile-image">
                                    <img src="${pageContext.servletContext.contextPath}/resources/images/avatar1.png" class="img-circle img-responsive" alt="">
                                </div>
                                <div class="sidebar-profile-details">
                                    <span>David Green<br><small>Art Director</small></span>
                                </div>
                            </a>
                        </div>
                    </div>
					
					<!-- Module Bar -->
					<ul class="menu accordion-menu">
<%--                     	<h1>${lalala}</h1> --%>
<%--                         <c:if test="${sessionScope.modules != null}"> --%>
<%--                         	<c:forEach items="${sessionScope.modules}" var="module"> --%>
<!--                         	<h5>Modules</h5> -->
<%-- 	                        	<c:choose> --%>
<%-- 	                        		<c:when test="${function:instanceOf(module, 'com.sia.main.plugin.modul.Accessable')}" > --%>
<%-- 	                        			<li><a href="${module.getUrl()}" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-home"></span><p>$module.getModuleName()</p></a></li>	                        			 --%>
<%-- 	                        		</c:when> --%>
<%-- 	                        		<c:otherwise> --%>
<%--                         				<c:if test="${function:instanceOf(module, 'com.sia.main.plugin.modul.HasMenu')}"> --%>
<!--                         					<li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-home"></span><p>$module.getModuleName()</p><span class="arrow"></span></a> -->
<!--                         						<ul class="sub-menu"> -->
<%-- 		                        					<c:forEach items="${module.getModuleMenus()}" var="moduleMenu"> --%>
<%-- 		                        						<li><a href="${moduleMenu.getUrl()}">${moduleMenu.getName()}</a></li> --%>
<%-- 		                        					</c:forEach> --%>
<!-- 	                        					</ul> -->
<!--                         					</li> -->
<%--                         				</c:if> --%>
<%-- 	                        		</c:otherwise> --%>
<%-- 	                        	</c:choose> --%>
<%-- 	                        </c:forEach> --%>
<%--                         </c:if> --%>
                    </ul>

                </div><!-- Page Sidebar Inner -->
            </div><!-- Page Sidebar -->
            
            <div class="page-inner">
                <div class="page-title">
                    <h3>Horizontal Menu</h3>
                    <div class="page-breadcrumb">
                        <ol class="breadcrumb">
                            <li><a href="index.html">Home</a></li>
                            <li><a href="#">Layouts</a></li>
                            <li class="active">Horizontal Menu</li>
                        </ol>
                    </div>
                </div>
                
                <!-- Body -->
                <div id="main-wrapper">
                    <decorator:body/>
                </div>
                
                <div class="page-footer">
                    <p class="no-s">2015 &copy;</p>
                </div>
            </div><!-- Page Inner -->
        </div><!-- Page Content -->

		<!-- Javascripts -->
		<script src="${pageContext.servletContext.contextPath}/resources/plugins/jquery/jquery-2.1.3.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/jquery-ui/jquery-ui.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/pace-master/pace.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/jquery-blockui/jquery.blockui.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/switchery/switchery.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/uniform/jquery.uniform.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/offcanvasmenueffects/js/classie.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/offcanvasmenueffects/js/main.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/waves/waves.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/3d-bold-navigation/js/main.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/waypoints/jquery.waypoints.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/jquery-counterup/jquery.counterup.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/toastr/toastr.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/flot/jquery.flot.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/flot/jquery.flot.time.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/flot/jquery.flot.symbol.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/flot/jquery.flot.resize.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/flot/jquery.flot.tooltip.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/curvedlines/curvedLines.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/metrojs/MetroJs.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/js/modern.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/js/pages/dashboard.js"></script>
    </body>

</html>