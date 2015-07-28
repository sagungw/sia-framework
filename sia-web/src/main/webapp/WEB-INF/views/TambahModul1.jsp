<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Tambah Modul</title>

<c:if test="${response.getStatus() == 'exception' || response.getStatus() == 'existed'}" >
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
		$(document).ready(function () {
			var msg = ${response.getMessage()};
			toastr["error"](msg);
		});
	</script>
</c:if>

<div class="row" id="masterpage">
	<div class="col-md-12">
		<div id="panel-unggah" class="panel panel-white">
			<div class="panel-heading clearfix">
				<h4 class="panel-title">Unggah Modul</h4>
			</div>
			<div class="panel-body">
				<div class="progress progress-sm m-t-sm">
					<div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100" style="width: 33%;"></div>
				</div>
				
				<div id="upload-form" class="row">
					<div class="col-md-12">
						<form enctype="multipart/form-data" id="uploadForm" action="${pageContext.servletContext.contextPath}/admin/module/uploadWizard/1/upload" method="post">
				    		<input id="fileInput" type="file" accept=".jar, .war" name="file"/>
				    		<br/>
				        	<button type="submit" class="btn btn-success m-b-sm" id="addModuleBtn">Unggah</button>
				    	</form>
			    	</div>
		    	</div>
		    	
		    	<c:if test="${response.getStatus() == 'success'}">
			    	<div id="upload-ket" class="row">
				    	<p>Modul dengan nama yang sama akan diperbarui</p>
						<br/>
						<div id="modul-new" class="col-md-6">
							<h4 class="no-m m-b-sm m-t-lg">Keterangan Modul</h4>
							<br/>
							<h4 class="no-m m-b-sm m-t-lg">Nama Modul</h4>
				    		<p>${modul.getNamaModul()}</p>
				    		<br/>
				    		<h4 class="no-m m-b-sm m-t-lg">Menu Modul</h4>
				    		<ul>
				    			<c:forEach items="${modul.getMenus()}" var="menu">
				    				<li>${menu.getNamaMenu()}</li>
				    			</c:forEach>
				    		</ul>
				    		<br/>
				    		<h4 class="no-m m-b-sm m-t-lg">Url Modul</h4>
				    		<p>${modul.getUrlMapping()}</p>
				    		<br/>
				    		<h4 class="no-m m-b-sm m-t-lg">Versi</h4>
				    		<p>${modul.getVersi()}</p>
				    		<br/>
						</div>
						
					</div>
					
					<div id="upload-confirm"  class="row">
						<div class="col-md-12">
							<ul class="pager wizard">
								<p>Klik "Lanjut" untuk menetapkan hak akses tiap menu pada modul</p>
								<li class="next"><a href="${pageContext.servletContext.contextPath}/admin/module/uploadWizard/2" class="btn btn-default">Lanjut</a></li>
							</ul>
						</div>
					</div>
				</c:if>
		    	
			</div>
		</div>
		
	</div>
</div>