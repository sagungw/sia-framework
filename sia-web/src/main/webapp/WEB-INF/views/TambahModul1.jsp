<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Tambah Modul</title>

<div class="row" id="masterpage">
	<div class="col-md-12">
		<div id="panel-unggah" class="panel panel-white">
			<div class="panel-heading clearfix">
				<h4 class="panel-title">Tambah Modul</h4>
			</div>
			<div class="panel-body">
				<div class="progress progress-sm m-t-sm">
					<div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%;"></div>
				</div>
				
				<c:if test="${response.getStatus() != 'success'}" >
					<div id="upload-form" class="row">
						<div class="col-md-12">
				    		<p>
                            	<strong>Unggah Modul</strong>
                            </p>
				    	</div>
						<div class="col-md-12">
							<form enctype="multipart/form-data" id="uploadForm" action="${pageContext.servletContext.contextPath}/admin/module/uploadWizard/1/upload" method="post">
					    		<input id="fileInput" type="file" accept=".jar, .war" name="file"/>
					    		<br/>
					        	<button type="submit" class="btn btn-info m-b-sm" id="addModuleBtn">Unggah</button>
					    	</form>
				    	</div>
			    	</div>
		    	</c:if>
		    	
		    	<c:if test="${response.getStatus() == 'success'}">
			    	<div id="upload-ket" class="row">
			    		<div class="col-md-12">
				    		<p>Modul dengan nama yang sama akan diperbarui</p>
				    	</div>
				    	<div class="col-md-12">
				    		<p>
                            	<strong>Keterangan Modul</strong>
                            </p>
				    	</div>
						<div class="col-md-6">
                            <p>
                                Nama Modul: ${modul.getNamaModul()}<br>
                                Url Modul: ${modul.getUrlMapping()}<br>
                                Versi: ${modul.getVersi()}<br>
                            </p>
                        </div>
                        <div class="col-md-6">
                        	<table class="table table-striped">
	                            <thead>
	                                <tr>
	                                    <th>Menu</th>
	                                </tr>
	                            </thead>
	                            <tbody>
	                            	<c:forEach items="${modul.getMenus()}" var="menu">
		                                <tr>
		                                    <td>${menu.getNamaMenu()}</td>
		                                </tr>
	                                </c:forEach>
	                            </tbody>
                        	</table>
                        </div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<p>Klik "Lanjut" untuk menetapkan hak akses tiap menu pada modul</p>
						</div>
						
						<div class="col-md-12">
							<form enctype="multipart/form-data" action="${pageContext.servletContext.contextPath}/admin/module/uploadWizard/2" method="post">
					    		<input type="text" name="modul" value="${modul.getIdModul()}" style="display: none;" />
					        	<button type="submit" class="btn btn-info" >Lanjut</button>
					    	</form>
						</div>
					</div>
				</c:if>
		    	
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
</script>

<c:if test="${response.getStatus() == 'exception' || response.getStatus() == 'existed'}" >
	<script>
		toastr["error"]("${response.getMessage()}");
	</script>
</c:if>

<c:if test="${response.getStatus() == 'success'}" >
	<script>
		toastr["success"]("${response.getMessage()}");
	</script>
</c:if>