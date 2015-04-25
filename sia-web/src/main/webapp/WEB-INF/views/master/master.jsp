<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head lang="en">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/app/css/header.css"/>">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/app/css/template.css"/>">
		<script type="text/javascript" src="<c:url value="/resources/jquery/jquery-1.11.1.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/bootsnip/side-menu/site-menu.js"/>"></script>
		
		<script type="text/javascript">
			
		</script>
		
	</head>
	
	<body style="background-color: #E4E4E4;">
	
		<nav class="navbar navbar-default navbar-static-top">
	    	<div class="container-fluid">	    		
			
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href="">
						SI Akademik
					</a>
				</div>
	
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown ">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
							Pengguna
							<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li class=""><a href="#">Hak Akses</a></li>
								<li class="divider"></li>
								<li><a href="#">Keluar</a></li>
							</ul>
						</li>
					</ul>
				</div><!-- /.navbar-collapse -->
				
			</div><!-- /.container-fluid -->
		</nav>  	
	
		<div class="container-fluid main-container">
  			<div class="col-md-2 sidebar">
  				<div class="row">
					<!-- uncomment code for absolute positioning tweek see top comment in css -->
					<div class="absolute-wrapper"> </div>
					<!-- Menu -->
					<div class="side-menu">
						<nav class="navbar navbar-default" role="navigation">
							<!-- Main Menu -->
							<div class="side-menu-container">
								<ul class="nav navbar-nav" style="width: 100%;">
									<li class="active"><a href="#"><span class="glyphicon glyphicon-dashboard"></span> Modul1</a></li>
									<li><a href="#"><span class="glyphicon glyphicon-plane"></span> Modul2</a></li>
				
									<!-- Dropdown-->
									<li class="panel panel-default" id="dropdown">
										<a data-toggle="collapse" href="#dropdown-lvl1">
											<span class="glyphicon glyphicon-user"></span> Modul3<span class="caret"></span>
										</a>
				
										<!-- Dropdown level 1 -->
										<div id="dropdown-lvl1" class="panel-collapse collapse">
											<div class="panel-body">
												<ul class="nav navbar-nav">
													<li><a href="#">Link</a></li>
													<li><a href="#">Link</a></li>
													<li><a href="#">Link</a></li>
				
													<!-- Dropdown level 2 -->
													<li class="panel panel-default" id="dropdown">
														<a data-toggle="collapse" href="#dropdown-lvl2">
															<span class="glyphicon glyphicon-off"></span> Sub Level <span class="caret"></span>
														</a>
														<div id="dropdown-lvl2" class="panel-collapse collapse">
															<div class="panel-body">
																<ul class="nav navbar-nav">
																	<li><a href="#">Link</a></li>
																	<li><a href="#">Link</a></li>
																	<li><a href="#">Link</a></li>
																</ul>
															</div>
														</div>
													</li>
												</ul>
											</div>
										</div>
									</li>
				
								</ul>
							</div><!-- /.navbar-collapse -->
						</nav>
				
					</div>
				</div>  		
			</div>
			
  			<div class="col-md-10 content">
  			 	<div class="panel panel-default">
					<div class="panel-heading">
							
					</div>
					<div class="panel-body">
							<decorator:body/>
					</div>
				</div>
  			</div>
  			
  			<footer class="pull-left footer">
  				<p class="col-md-12">
  				</p>
  			</footer>
  			
  		</div>
	
	</body>
	
</html>