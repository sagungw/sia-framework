<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    
    </head>
    <body class="page-header-fixed compact-menu">
        <div class="overlay"></div>
        
        <main class="page-content content-wrap">
        
            <div class="navbar">
                <%@include file="master/Header.jsp" %>
            </div><!-- Navbar -->
           
            <div class="page-inner">
            
                <div class="page-title">
                    <h3>Selamat Datang</h3>
                </div>
                
                <div id="main-wrapper">
                	<div class="row">
						<div class="col-md-12">
							<div class="panel panel-white">
								<div class="panel-heading clearfix">
									<h4 class="panel-title">Modul Tersedia</h4>
								</div>
								<div class="panel-body">
									<c:forEach items="${sessionScope.moduleSession}" var="module">
										<div id="${module.getIdModul()}" class="modul-item">
											<img src="data:image/png;base64,${module.getBase64EncodedImage()}" alt="${module.getNamaModul()}" style="max-width:100%; max-height:100%;">
										</div>
									</c:forEach>
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