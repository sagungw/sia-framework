<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="function" uri="http://taglibs/custom" %>

<!DOCTYPE html>
<html>
    
	<head>
        
        <!-- Title -->
        <title><decorator:title default="Sistem Informasi Akademik"></decorator:title></title>
        
        <meta content="width=device-width, initial-scale=1" name="viewport"/>
        <meta charset="UTF-8">
        <meta name="description" content="Admin Dashboard Template" />
        <meta name="keywords" content="admin,dashboard" />
        <meta name="author" content="Steelcoders" />
        
        <!-- Styles -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'>
        <link href="${pageContext.servletContext.contextPath}/resources/plugins/pace-master/themes/blue/pace-theme-flash.css" rel="stylesheet"/>
        <link href="${pageContext.servletContext.contextPath}/resources/plugins/uniform/css/uniform.default.min.css" rel="stylesheet"/>
        <link href="${pageContext.servletContext.contextPath}/resources/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/resources/plugins/fontawesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/resources/plugins/line-icons/simple-line-icons.css" rel="stylesheet" type="text/css"/>	
        <link href="${pageContext.servletContext.contextPath}/resources/plugins/offcanvasmenueffects/css/menu_cornerbox.css" rel="stylesheet" type="text/css"/>	
        <link href="${pageContext.servletContext.contextPath}/resources/plugins/waves/waves.min.css" rel="stylesheet" type="text/css"/>	
        <link href="${pageContext.servletContext.contextPath}/resources/plugins/switchery/switchery.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/resources/plugins/3d-bold-navigation/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/resources/plugins/slidepushmenus/css/component.css" rel="stylesheet" type="text/css"/>	
        
        <!-- Theme Styles -->
        <link href="${pageContext.servletContext.contextPath}/resources/css/modern.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/resources/css/themes/white.css" class="theme-color" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/resources/css/custom.css" rel="stylesheet" type="text/css"/>
        
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/3d-bold-navigation/js/modernizr.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/offcanvasmenueffects/js/snap.svg-min.js"></script>
    
    </head>
    <body class="page-header-fixed compact-menu">
        <div class="overlay"></div>
        
        <main class="page-content content-wrap">
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
                                                        <input type="checkbox" class="js-switch pull-right horizontal-bar-check">
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
                                                        <input type="checkbox" class="js-switch pull-right compact-menu-check" checked>
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
                                        <li class="li-group">
                                            <ul class="list-unstyled">
                                                <li class="no-link" role="presentation">
                                                    Choose Theme Color
                                                    <div class="color-switcher">
                                                        <a class="colorbox color-blue" href="layout-compact-menuca00.html?theme=blue" title="Blue Theme" data-css="blue"></a>
                                                        <a class="colorbox color-green" href="layout-compact-menuaf91.html?theme=green" title="Green Theme" data-css="green"></a>
                                                        <a class="colorbox color-red" href="layout-compact-menu0e99.html?theme=red" title="Red Theme" data-css="red"></a>
                                                        <a class="colorbox color-white" href="layout-compact-menu13d4.html?theme=white" title="White Theme" data-css="white"></a>
                                                        <a class="colorbox color-purple" href="layout-compact-menu938c.html?theme=purple" title="purple Theme" data-css="purple"></a>
                                                        <a class="colorbox color-dark" href="layout-compact-menu4965.html?theme=dark" title="Dark Theme" data-css="dark"></a>
                                                    </div>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="no-link"><button class="btn btn-default reset-options">Reset Options</button></li>
                                    </ul>
                                </li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle waves-effect waves-button waves-classic" data-toggle="dropdown">
                                        <span class="user-name">David<i class="fa fa-angle-down"></i></span>
                                        <img class="img-circle avatar" src="${pageContext.servletContext.contextPath}/resources/images/avatar1.png" width="40" height="40" alt="">
                                    </a>
                                    <ul class="dropdown-menu dropdown-list" role="menu">
                                        <li role="presentation"><a href="calendar.html"><i class="fa fa-calendar"></i>Pilih Peran</a></li>
                                        <li role="presentation"><a href="inbox.html"><i class="fa fa-envelope"></i>Pilih Modul<span class="badge badge-success pull-right">4</span></a></li>
                                        <li role="presentation" class="divider"></li>
                                        <li role="presentation"><a href="login.html"><i class="fa fa-sign-out m-r-xs"></i>Log out</a></li>
                                    </ul>
                                </li>
                            </ul><!-- Nav -->
                        </div><!-- Top Menu -->
                    </div>
                </div>
            </div><!-- Navbar -->
            <div class="page-sidebar sidebar">
                <div class="page-sidebar-inner slimscroll">
                    <div class="sidebar-header">
                        <div class="sidebar-profile">
                            <a href="javascript:void(0);" id="profile-menu-link">
                                <div class="sidebar-profile-image">
                                    <img src="${pageContext.servletContext.contextPath}/resources/images/avatar1.png" class="img-circle img-responsive" alt="">
                                </div>
                                <div class="sidebar-profile-details">
                                    <span>David<br><small>Administrator</small></span>
                                </div>
                            </a>
                        </div>
                    </div>
                    <ul class="menu accordion-menu">
                        <li><a href="index.html" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-home"></span><p>Dashboard</p></a></li>
                        <li><a href="profile.html" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-user"></span><p>Profile</p></a></li>
                        <li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-envelope"></span><p>Mailbox</p><span class="arrow"></span></a>
                            <ul class="sub-menu">
                                <li><a href="inbox.html">Inbox</a></li>
                                <li><a href="message-view.html">View Message</a></li>
                                <li><a href="compose.html">Compose</a></li>
                            </ul>
                        </li>
                        <li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-briefcase"></span><p>UI Kits</p><span class="arrow"></span></a>
                            <ul class="sub-menu">
                                <li><a href="ui-alerts.html">Alerts</a></li>
                                <li><a href="ui-buttons.html">Buttons</a></li>
                                <li><a href="ui-icons.html">Icons</a></li>
                                <li><a href="ui-typography.html">Typography</a></li>
                                <li><a href="ui-notifications.html">Notifications</a></li>
                                <li><a href="ui-grid.html">Grid</a></li>
                                <li><a href="ui-tabs-accordions.html">Tabs &amp; Accordions</a></li>
                                <li><a href="ui-modals.html">Modals</a></li>
                                <li><a href="ui-panels.html">Panels</a></li>
                                <li><a href="ui-progress.html">Progress Bars</a></li>
                                <li><a href="ui-nestable.html">Nestable</a></li>
                                <li><a href="ui-tree-view.html">Tree View</a></li>
                            </ul>
                        </li>
                        <li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon glyphicon glyphicon-th"></span><p>Layouts</p><span class="arrow"></span></a>
                            <ul class="sub-menu">
                                <li><a href="layout-blank.html">Blank Page</a></li>
                                <li><a href="layout-boxed.html">Boxed Page</a></li>
                                <li><a href="layout-horizontal-menu.html">Horizontal Menu</a></li>
                                <li><a href="layout-horizontal-menu-boxed.html">Boxed &amp; Horizontal Menu</a></li>
                                <li><a href="layout-horizontal-menu-minimal.html">Horizontal Menu Minimal</a></li>
                                <li><a href="layout-fixed-sidebar.html">Fixed Sidebar</a></li>
                                <li><a href="layout-static-header.html">Static Header</a></li>
                                <li><a href="layout-collapsed-sidebar.html">Collapsed Sidebar</a></li>
                                <li class="active"><a href="layout-compact-menu.html">Compact Menu</a></li>
                                <li><a href="layout-hover-menu.html">Hover Menu</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- Page Sidebar Inner -->
            </div><!-- Page Sidebar -->
            <div class="page-inner">
                <div class="page-title">
                    <h3>Compact Menu</h3>
                    <div class="page-breadcrumb">
                        <ol class="breadcrumb">
                            <li><a href="index.html">Home</a></li>
                            <li><a href="#">Layouts</a></li>
                            <li class="active">Compact Menu</li>
                        </ol>
                    </div>
                </div>
                <div id="main-wrapper">
                	<decorator:body/>
                </div><!-- Main Wrapper -->
                <div class="page-footer">
                    <p class="no-s">2015 &copy; Modern by Steelcoders.</p>
                </div>
            </div><!-- Page Inner -->
        </main><!-- Page Content -->
        
        <div class="cd-overlay"></div>
	
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
        <script src="${pageContext.servletContext.contextPath}/resources/js/modern.min.js"></script>
        
    </body>

</html>