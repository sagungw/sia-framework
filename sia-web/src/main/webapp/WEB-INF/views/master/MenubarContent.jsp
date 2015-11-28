<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="true" %>

<div class="page-sidebar-inner slimscroll">
	<div class="sidebar-header">
	    <div class="sidebar-profile">
	        <a href="javascript:void(0);" id="profile-menu-link">
	            <div class="sidebar-profile-image">
	                <img src="${pageContext.servletContext.contextPath}/resources/images/user_icon.png" class="img-circle img-responsive" alt="">
	            </div>
	            <div class="sidebar-profile-details">
	                <span>
	                	<c:choose>
	                		<c:when test="${sessionScope.userRoleSession.getPengguna().getPd().getNamaPd() != null}">
	                    		${sessionScope.userRoleSession.getPengguna().getPd().getNamaPd()}
	                    	</c:when>
	                    	<c:when test="${sessionScope.userRoleSession.getPengguna().getPtk().getNamaPtk() != null}">
	                    		${sessionScope.userRoleSession.getPengguna().getPtk().getNamaPtk()}
	                    	</c:when>
	                    	<c:otherwise>
	                    		${sessionScope.userRoleSession.getPengguna().getUsername()}
	                    	</c:otherwise>
	                	</c:choose>
	                	<br>
	                	<small>${sessionScope.userRoleSession.getPeran().getNamaPeran()}</small>
	                </span>
	            </div>
	        </a>
	    </div>
	</div>
    <ul class="menu accordion-menu">
    	<c:forEach items="${sessionScope.moduleSession}" var="module">
    		<c:choose>
    			<c:when test="${module.getUrl() != null}">
    				<li><a href="${pageContext.servletContext.contextPath}${module.getUrl()}" class="waves-effect waves-button"><span class="menu-icon ${module.getNamaIconTemplate()}"></span><p>${module.getNamaModul()}</p></a></li>
    			</c:when>
    			<c:otherwise>
    				<li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon ${module.getNamaIconTemplate()}"></span><p>${module.getNamaModul()}</p><span class="arrow"></span></a>
	     				<ul class="sub-menu" style="display: none;">
	     					<c:forEach items="${module.getMenus()}" var="menu">
	                   	<li><a href="${pageContext.servletContext.contextPath}${menu.getUrlMenu()}">${menu.getNamaMenu()}</a></li>
	     					</c:forEach>
	     				</ul>
          			 </li>    			
    			</c:otherwise>
    		</c:choose>
    	</c:forEach>
    </ul>
</div><!-- Page Sidebar Inner -->