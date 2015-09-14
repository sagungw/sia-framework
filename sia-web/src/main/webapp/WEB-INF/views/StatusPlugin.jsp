<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<title>Sistem Informasi Akademik - Status Osgi Module dan Plugin</title>

<div class="row" id="masterpage">

	<div class="col-md-12">
	
		<div class="panel panel-white" >
		
		    <div class="panel-heading">
		        <h4 class="no-m m-b-lg">Status Osgi Module dan Plugin</h4>
		    </div>
		    
		    <div class="panel-body">
		        
		        <br/>
		        
		        <div class="row">
		        	<div class="col-md-12">
		        		<form action="${pageContext.servletContext.contextPath}/admin/modulePluginStatus/refresh" method="post">
		        			<input type="text" name="refresh" hidden="true">
		        			<button id="btn-add" type="submit" class="btn btn-info"><i>Refresh</i> Daftar</button>
		        		</form>
		        	</div>
		        </div>
		        
		        <br/>
		        
		        <div class="table-responsive col-md-8">
	            	<table class="table table-striped">
			            <thead>
			               	<tr>
				               	<th>Status</th>
			               	</tr>
			            </thead> 
	            		<tbody>
	            			<c:choose>
	            				<c:when test="${fn:length(statusPluginList) > 0}">
	            					<c:forEach items="${statusPluginList}" var="statusPlugin">
	            						<tr id="${statusPlugin.getIdStatus()}" class="module-item">
	                                        <td>${statusPlugin.getNamaStatus()}</td>
	                                    </tr>
	            					</c:forEach>
	            				</c:when>
	            				<c:otherwise>
	            					<tr class="odd">
	            						<td valign="top" colspan="5" class="dataTables_empty">Tidak ada data</td>
	            					</tr>
	            				</c:otherwise>
	            			</c:choose>
	            		</tbody>
	            	</table>
		        </div>
		        
		    </div>
		   
		</div>
	</div>
</div>