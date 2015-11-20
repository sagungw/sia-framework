<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
            </ul>
            <ul class="nav navbar-nav navbar-right">
            	<li style="margin-top: 12px;">
					<select id="role-select" >
						<option value="">-- Hak Akses --</option>
						<c:forEach items="${sessionScope.userSession.getPeranPenggunaList()}" var="userRole">
							<c:choose>
								<c:when test="${userRole.getPeran().getIdPeran() == sessionScope.userRoleSession.getPeran().getIdPeran()}">
									<option value="${userRole.getPeran().getIdPeran()}" selected="selected">${userRole.getPeran().getNamaPeran()}</option>
								</c:when>
								<c:otherwise>
									<option value="${userRole.getPeran().getIdPeran()}">${userRole.getPeran().getNamaPeran()}</option>
								</c:otherwise>
							</c:choose>						
						</c:forEach>
					</select>
            	</li>
                <li id="user-control-li" class="dropdown">
                    <a id="user-control-a" href="#" class="dropdown-toggle waves-effect waves-button waves-classic" data-toggle="dropdown">
	                    <c:choose>
	                    	<c:when test="${sessionScope.userSession.getPd().getNamaPd() != null}">
	                    		<span class="user-name">${sessionScope.userSession.getPd().getNamaPd()}<i class="fa fa-angle-down"></i></span>
	                    	</c:when>
	                    	<c:when test="${sessionScope.userSession.getPtk().getNamaPtk() != null}">
	                    		<span class="user-name">${sessionScope.userSession.getPtk().getNamaPtk()}<i class="fa fa-angle-down"></i></span>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<span class="user-name">${sessionScope.userSession.getUsername()}<i class="fa fa-angle-down"></i></span>
	                    	</c:otherwise>
	                    </c:choose>
                        <img class="img-circle avatar" src="${pageContext.servletContext.contextPath}/resources/images/user_icon.png" width="40" height="40" alt="">
                    </a>
                    <ul class="dropdown-menu dropdown-list" role="menu">
                    	 <c:choose>
	                    	<c:when test="${sessionScope.userSession.getPd().getNamaPd() != null}">
	                    		<li role="presentation"><a href="#"><i class="fa fa-user"></i>${sessionScope.userSession.getPd().getNamaPd()}</a></li>
	                    		<li role="presentation"><a href="#"><i class="fa fa-user"></i>${sessionScope.userSession.getPd().getNiPd()}</a></li>
	                    	</c:when>
	                    	<c:when test="${sessionScope.userSession.getPtk().getNamaPtk() != null}">
	                    		<li role="presentation"><a href="#"><i class="fa fa-user"></i>${sessionScope.userSession.getPtk().getNamaPtk()}</a></li>
	                    		<li role="presentation"><a href="#"><i class="fa fa-user"></i>${sessionScope.userSession.getPtk().getNiPtk()}</a></li>
	                    	</c:when>
	                    </c:choose>
	                    <li role="presentation"><a href="#"><i class="fa fa-envelope"></i>${sessionScope.userSession.getUsername()}</a></li>
                    	<li role="presentation" class="divider"></li>
                        <li role="presentation"><a href="${pageContext.servletContext.contextPath}/j_spring_security_logout"><i class="fa fa-sign-out m-r-xs"></i>Keluar</a></li>
                    </ul>
                </li>
            </ul><!-- Nav -->
        </div><!-- Top Menu -->
    </div>
</div>