<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="function" uri="http://taglibs/custom" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
    
	<head>
        <title>Selamat Datang | Sistem Informasi Akademik</title>
        
        <meta content="width=device-width, initial-scale=1" name="viewport"/>
        <meta charset="UTF-8">
        <meta name="description" content="Admin Dashboard Template" />
        <meta name="keywords" content="admin,dashboard" />
        <meta name="author" content="Steelcoders" />
        
        <%@include file="master/DefaultCss.jsp" %>
    
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
    <body class="page-header-fixed">
        <div class="overlay"></div>
        
        <main class="page-content content-wrap">
        
            <div class="navbar">
                <%@include file="master/Header.jsp" %>
            </div><!-- Navbar -->
           
            <div class="page-inner">
                <div class="page-title">
                    <%@include file="master/PageTitle.jsp" %>
                </div>
                <div id="main-wrapper">
                	<div class="row">
                	
						<div class="col-md-12">
							<div class="panel panel-white">
								<div class="panel-heading clearfix">
									<h4 class="panel-title">Info</h4>
								</div>
								<div class="panel-body">									
								</div>
							</div>
						</div>
						
						<div class="col-md-12">
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
				                            				<a href="${pageContext.servletContext.contextPath}${menu.getUrlMenu()}" >
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
                    <%@include file="master/Footer.jsp" %>
                </div>
            </div><!-- Page Inner -->
            
        </main><!-- Page Content -->
        
        <div class="cd-overlay"></div>
	
        <%@include file="master/DefaultScripts.jsp" %>
        
    </body>

</html>