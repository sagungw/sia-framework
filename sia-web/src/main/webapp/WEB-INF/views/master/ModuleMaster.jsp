<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="function" uri="http://taglibs/custom" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ page session="true" %>

<!DOCTYPE html>
<html>

	<head>
        <title><decorator:title default="Modul | Sistem Informasi Akademik"></decorator:title></title>
        
        <meta content="width=device-width, initial-scale=1" name="viewport"/>
        <meta charset="UTF-8">
        <meta name="description" content="Admin Dashboard Template" />
        <meta name="keywords" content="admin,dashboard" />
        <meta name="author" content="Steelcoders" />
        
        <%@include file="DefaultCss.jsp" %>
        
        <decorator:head></decorator:head>
        
    </head>
    <body class="page-header-fixed page-horizontal-bar compact-menu">
        <div class="overlay"></div>
        
        <main class="page-content content-wrap">
        
            <div class="navbar">
                <%@include file="Header.jsp" %>
            </div><!-- Navbar -->
            
            <div class="horizontal-bar sidebar">
                <div class="page-sidebar-inner slimscroll">
                    <div class="sidebar-header">
                        <div class="sidebar-profile">
                            <a href="javascript:void(0);" id="profile-menu-link">
                                <div class="sidebar-profile-image">
                                    <img src="${pageContext.servletContext.contextPath}/resources/images/user_icon.png" class="img-circle img-responsive" alt="">
                                </div>
                                <div class="sidebar-profile-details">
                                    <span>${sessionScope.userRoleSession.getPengguna().getPd().getNamaPd()}${sessionScope.userRoleSession.getPengguna().getPtk().getNamaPtk()}<br><small>${sessionScope.userRoleSession.getPeran().getNamaPeran()}</small></span>
                                </div>
                            </a>
                        </div>
                    </div>
                    <ul class="menu accordion-menu">
                       <c:forEach items="${sessionScope.moduleSession}" var="module">		
               				<li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon"></span><p>${module.getNamaModul()}</p><span class="arrow"></span></a>
	                            <ul class="sub-menu" style="display: none;">
	                            	<c:forEach items="${module.getMenus()}" var="menu">
	                            		<li><a href="${pageContext.servletContext.contextPath}${menu.getHomeUrl()}">${menu.getNamaMenu()}</a></li>
	                            	</c:forEach>
	                            </ul>
	                        </li>
	               		</c:forEach>
                    </ul>
                </div><!-- Page Sidebar Inner -->
            </div><!-- Page Sidebar -->
            
            <div class="page-inner">
                <div class="page-title">
                    <%@include file="PageTitle.jsp" %>
                </div>
                <div id="main-wrapper">
                    <decorator:body/>
                </div><!-- Main Wrapper -->
                <div class="page-footer">
                    <%@include file="Footer.jsp" %>
                </div>
            </div><!-- Page Inner -->
            
        </main><!-- Page Content -->
        
        <div class="cd-overlay"></div>

        <%@include file="DefaultScripts.jsp" %>
        
    </body>

</html>		