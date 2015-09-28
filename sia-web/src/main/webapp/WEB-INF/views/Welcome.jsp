<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="function" uri="http://taglibs/custom" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
    
	<head>
        <title>Sistem Informasi Akademik - Selamat Datang</title>
        
        <meta content="width=device-width, initial-scale=1" name="viewport"/>
        <meta charset="UTF-8">
        <meta name="description" content="Admin Dashboard Template" />
        <meta name="keywords" content="admin,dashboard" />
        <meta name="author" content="Steelcoders" />
        
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
        <link href="${pageContext.servletContext.contextPath}/resources/plugins/toastr/toastr.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/resources/plugins/nestable/nestable.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.servletContext.contextPath}/resources/plugins/datatable/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
        
        <link href="${pageContext.servletContext.contextPath}/resources/css/modern.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/resources/css/themes/white.css" class="theme-color" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/resources/css/custom.css" rel="stylesheet" type="text/css"/>
        
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/3d-bold-navigation/js/modernizr.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/plugins/offcanvasmenueffects/js/snap.svg-min.js"></script>
        
    	<script>
    		var contextPath = "${pageContext.servletContext.contextPath}";
    	</script>
    
    	<style>
    		.menu-item:hover {
    			background-color: #CAC5E5;
    			color: white;
    		}
    		.dd-item a:link {
			    color: #333;
			    text-decoration: none;
			}
			.dd-item a:visited {
			    color: #333;
			    text-decoration: none;
			}
			.dd-item a:hover {
			    color: white;
			    text-decoration: none;
			}
			.dd-item a:active {
			    color: #333;
			    text-decoration: none;
			} 
    	</style>
    
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
                        <a href="index.html" class="logo-text"><span>SIA</span></a>
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
                                        <span class="user-name">${sessionScope.userSession.getUsername()}<i class="fa fa-angle-down"></i></span>
                                        <img class="img-circle avatar" src="${pageContext.servletContext.contextPath}/resources/images/user_icon.png" width="40" height="40" alt="">
                                    </a>
                                    <ul class="dropdown-menu dropdown-list" role="menu">
                                        <li role="presentation"><a href="${pageContext.servletContext.contextPath}/session/chooseUserRole"><i class="fa fa-calendar"></i>Pilih Peran</a></li>
                                        <li role="presentation" class="divider"></li>
                                        <li role="presentation"><a href="${pageContext.servletContext.contextPath}/account/logout"><i class="fa fa-sign-out m-r-xs"></i>Log out</a></li>
                                    </ul>
                                </li>
                            </ul><!-- Nav -->
                        </div><!-- Top Menu -->
                    </div>
                </div>
            </div><!-- Navbar -->
           
            <div class="page-inner">
                <div class="page-title">
                    <h3>Selamat Datang</h3>
                </div>
                <div id="main-wrapper">
                	<div class="row">
                	
						<div class="col-md-6">
							<div class="panel panel-white">
								<div class="panel-heading clearfix">
									<h4 class="panel-title">Info</h4>
								</div>
								<div class="panel-body">
								</div>
							</div>
						</div>
						
						<div class="col-md-6">
							<div class="panel panel-white">
								<div class="panel-heading clearfix">
									<h4 class="panel-title">Modul Tersedia</h4>
								</div>
								<div class="panel-body">
									<ol class="dd-list">
				                    	<c:forEach items="${sessionScope.moduleSession}" var="module">
				                    		<li class="dd-item">
				                            	<div id="${module.getIdModul()}" class="dd-handle" style="background-color: #7a6fbe; color: white;">${module.getNamaModul()}</div>
				                            	<ol class="dd-list">
				                            		<c:forEach items="${module.getMenus()}" var="menu">
				                            			<li class="dd-item">
				                            				<a href="${pageContext.servletContext.contextPath}${menu.getHomeUrl()}" >
				                            					<div id="${menu.getIdMenu()}" class="dd-handle menu-item" style="cursor: pointer;">${menu.getNamaMenu()}</div>
				                            				</a>
				                            			</li>
				                            		</c:forEach>
				                            	</ol>
				                        	</li>
				                    	</c:forEach>
				                    </ol>
								</div>
							</div>
						</div>
						
					</div>
					
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