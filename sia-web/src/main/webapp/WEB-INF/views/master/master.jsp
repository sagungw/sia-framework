<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head lang="en">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/app/css/side-menu.css"/>">
			<link rel="stylesheet" type="text/css" href="<c:url value="/resources/app/css/header.css"/>">
		<script type="text/javascript" src="<c:url value="/resources/jquery/jquery-1.11.1.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/bootsnip/side-menu/side-menu.js"/>"></script>
		
		<script type="text/javascript">
			
		</script>
		
	</head>
	
	<body style="background-color: #E4E4E4;">
	
		<div id="header">
		</div>
	
		<div class="side-menu">
		    <nav class="navbar navbar-default" role="navigation">
			
			    <!-- Main Menu -->
			    <div class="side-menu-container">
			        <ul class="nav navbar-nav">
			        
<!-- 			            Dropdown -->
			            <li class="panel panel-default" id="dropdown">
			                <a data-toggle="collapse" href="#dropdown-lvl1">
			                    <span class="glyphicon glyphicon-user"></span> Modul <span class="caret"></span>
			                </a>
			
<!-- 			                Dropdown level 1 -->
			                <div id="dropdown-lvl1" class="panel-collapse collapse">
			                    <div class="panel-body">
			                        <ul class="nav navbar-nav">
			                            
			                        </ul>
			                    </div>
			                </div>
			            </li>
			            
			            <!-- Dropdown-->
			            <li class="panel panel-default" id="dropdown">
			                <a data-toggle="collapse" href="#dropdown-lvl1">
			                    <span class="glyphicon glyphicon-user"></span> Pengguna <span class="caret"></span>
			                </a>
			
			                <!-- Dropdown level 1 -->
			                <div id="dropdown-lvl1" class="panel-collapse collapse">
			                    <div class="panel-body">
			                        <ul class="nav navbar-nav">
			                            <li><a href="#">Hak Akses</a></li>
                           				<li><a href="#">Keluar</a></li>
			                        </ul>
			                    </div>
			                </div>
			            </li>
			            
			       		<li  class="no_border"><a href=""><span></span></a></li>
			        </ul>
			    </div>
			</nav>
    
    	</div>
	
	</body>
	
</html>