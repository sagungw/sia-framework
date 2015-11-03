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
		        
		        <div class="table-responsive col-md-8">
	            	<table class="table table-striped">
			            <thead>
			               	<tr>
				               	<th>Modul</th>
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
	            						<tr id="${module.getIdModul()}" class="module-item">
	            							<c:set var="i" value="${i+1}"/>
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
		        
		        
				<div class="table-responsive col-md-4">
					<c:forEach items="${moduleList}" var="module">
			        	<table id="${module.getIdModul()}-menu-table" class="table table-striped menu-table" style="display: none;">
				            <thead>
				               	<tr>
					               	<th>Menu</th>
									<th>Mapping URL</th>
				               	</tr>
				            </thead> 
		            		<tbody>
	           					<c:forEach items="${module.getMenus()}" var="menu">
	           						<tr id="${menu.getIdMenu()}">
                                       <td>${menu.getNamaMenu()}</td>
                                       <td>${menu.getUrlMenu()}</td>
                                   </tr>
	           					</c:forEach>
		            		</tbody>
		            	</table>
		        	</c:forEach>
			    </div>
		        
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

	$(".module-item").click(function() {
		var moduleId = $(this).attr("id");
		var menuTableId = "#" + moduleId + "-menu-table";
		$(".menu-table").css("display", "none");
		$(menuTableId).css("display", "");
	});
	
</script>

<c:if test="${uploadWizardDone != null}">
	<script>
		toastr.options = {
				  "closeButton": true,
				  "debug": false,
				  "newestOnTop": false,
				  "progressBar": false,
				  "positionClass": "toast-top-right",
				  "preventDuplicates": false,
				  "onclick": null,
				  "showDuration": "300",
				  "hideDuration": "1000",
				  "timeOut": "5000",
				  "extendedTimeOut": "1000",
				  "showEasing": "swing",
				  "hideEasing": "linear",
				  "showMethod": "fadeIn",
				  "hideMethod": "fadeOut"
				}
		
		toastr["success"]("${uploadWizardDone.getMessage()}");
	</script>
</c:if>

