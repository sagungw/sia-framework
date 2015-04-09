<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="en">

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	
	<title><decorator:title default="Sistem Informasi Akademik"/></title>
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/landingpage/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/landingpage/css/bootstrap.min.css"/>" type="text/css" media="screen">
	<link rel="stylesheet" href="<c:url value="/resources/landingpage/css/font-awesome.min.css"/>" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/landingpage/css/style.css"/>">
	<link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,600,300,200&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link rel="prefetch" href="<c:url value="/resources/landingpage/images/zoom.png"/>">
		
</head>

<body>
	<div class="navbar navbar-fixed-top" data-activeslide="1">
		<div class="container">		
			<!-- .navbar-toggle is used as the toggle for collapsed navbar content -->
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			
			<table>
				<tr>
					<td width = "800px">						
						<div class="nav-collapse collapse navbar-responsive-collapse">
							<ul class="nav row">
								<li data-slide="1" class="col-12 col-sm-2"><a id="menu-link-1" href="#slide-1" title="Next Section"><span class="icon icon-home"></span> <span class="text">FRS</span></a></li>
								<li data-slide="2" class="col-12 col-sm-2"><a id="menu-link-2" href="#slide-2" title="Next Section"><span class="icon icon-user"></span> <span class="text">PENILAIAN</span></a></li>
								<li data-slide="3" class="col-12 col-sm-2"><a id="menu-link-3" href="#slide-3" title="Next Section"><span class="icon icon-briefcase"></span> <span class="text">KURIKULUM</span></a></li>
								<li data-slide="4" class="col-12 col-sm-2"><a id="menu-link-4" href="#slide-4" title="Next Section"><span class="icon icon-gears"></span> <span class="text">OPSI</span></a></li>								
							</ul>
							
							<div class="row">
								<div class="col-sm-2 active-menu"></div>
							</div>
						</div><!-- /.nav-collapse -->
					</td>
					<td>
						<td>
							<div class="nav-collapse collapse navbar-responsive-collapse" >
								
								
								<ul class="nav row">
									<li > <a href="#"><font size= "3px">Logout</font></a></li>
																
								</ul>
													
							</div><!-- /.nav-collapse -->		
						</td>
					</td>
					
				</tr>
			</table>
			
		</div><!-- /.container -->
	</div><!-- /.navbar -->

	
	<!-- === MAIN Background === -->
	<div id="content">
	    	<decorator:body />
    </div>

</body>

	<!-- SCRIPTS -->	
	<script src="<c:url value="/resources/landingpage/js/html5shiv.js"/>"></script>
	<script src="<c:url value="/resources/landingpage/js/jquery-1.10.2.min.js"/>"></script>
	<script src="<c:url value="/resources/landingpage/js/jquery-migrate-1.2.1.min.js"/>"></script>
	<script src="<c:url value="/resources/landingpage/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/landingpage/js/jquery.easing.1.3.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/landingpage/fancybox/jquery.fancybox.pack-v=2.1.5.js"/>"></script>
	<script src="<c:url value="/resources/landingpage/js/script.js"/>"></script>
	
	<!-- fancybox init -->
	<script>
	$(document).ready(function(e) {
		var lis = $('.nav > li');
		menu_focus( lis[0], 1 );
		
		$(".fancybox").fancybox({
			padding: 10,
			helpers: {
				overlay: {
					locked: false
				}
			}
		});
	
	});
	</script>
</html>