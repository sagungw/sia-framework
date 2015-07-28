<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<title>Administrator - Dashboard</title>

<div class="row">
	<div class="col-lg-4 col-md-4">
		<div class="panel panel-white stats-info">
			<div class="panel-heading clearfix">
	            <h4 class="panel-title">Modul Terpasang</h4>
	        </div>
	        <div class="panel-body">
	            <ul class="list-unstyled">
	            	<c:forEach items="${installedModules}" var="module">
	                    <li>${module.getNamaModul()}<div class="pull-right">${module.getVersi()}</div></li>
                    </c:forEach>
	            	<li><div class="pull-right"><a href="${pageContext.servletContext.contextPath}/admin/module/">Kelola Modul</a></div></li>
	            </ul>
	        </div>
    	</div>
	</div>
</div>