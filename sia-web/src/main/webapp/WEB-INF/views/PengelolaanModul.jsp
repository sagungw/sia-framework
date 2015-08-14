<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<title>Sistem Informasi Akademik - Pengelolaan Modul</title>

<div class="row" id="masterpage">

	<div class="col-md-12">
	
		<div class="panel panel-white" >
		
		    <div class="panel-heading">
		        <h4 class="no-m m-b-lg">Pengelolaan Modul</h4>
		    </div>
		    
		    <div class="panel-body">
		        
		        <br/>
		        
		        <div class="row">
		        	<div class="col-md-12">
		        		<button id="btn-add" type="button" class="btn btn-info">Tambah Modul</button>
		        	</div>
		        </div>
		        
		        <br/>
		        
		        <div class="col-md-1"></div>
		        
		        <div class="table-responsive col-md-10">
	            	<table class="table table-striped">
			            <thead>
			               	<tr>
			               		<th>#</th>
				               	<th>Nama</th>
								<th>Mapping URL</th>
								<th>Versi</th>
								<th>Status</th>
								<th>Aksi</th>
			               	</tr>
			            </thead> 
	            		<tbody>
	            			<c:choose>
	            				<c:when test="${fn:length(moduleList) > 0}">
	            					<c:set var="i" value="${0}" />
	            					<c:forEach items="${moduleList}" var="module">
	            						<tr id="${module.getIdModul()}">
	            							<c:set var="i" value="${i+1}"/>
	            							<td><c:out value="${i}"/></td>
	                                        <td>${module.getNamaModul()}</td>
	                                        <td>${module.getUrlMapping()}</td>
	                                        <td>${module.getVersi()}</td>
	                                        <td>${module.getStatus().getNamaStatus()}</td>
	                                        <td>
	                                        	<form action="hapusModul" method="post">
	                                        		<input type="text" id="txt-delete" name="idModul" hidden="true" value="${module.getIdModul()}">
	                                        		<button type="submit" id="btn-delete" class="btn btn-danger">Hapus</button>
	                                        	</form>
	                                        <td>
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
		        
		        <div class="col-md-1"></div>
		        
		    </div>
		   
		</div>
	</div>
</div>

<script src="${pageContext.servletContext.contextPath}/resources/plugins/jquery/jquery-2.1.3.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/plugins/jquery-blockui/jquery.blockui.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/plugins/uniform/jquery.uniform.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/plugins/toastr/toastr.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/pages/notifications.js"></script>

<script>
	$("#btn-delete").click(function(event) {
		event.preventDefault();
		var idModul = $("#txt-delete").val();
		var data = {"idModul": idModul};
		$.ajax({
			url: contextPath + "/admin/module/delete",
			type: 'POST',
			data: data,
			success: function(result) {
			 	}
			});
	});
	
	$("#btn-add").click(function() {
		window.location.href = contextPath + "/admin/module/uploadWizard/1";
	});

</script>

