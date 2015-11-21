<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<title>Sistem Informasi Akademik - Tambah Pengguna</title>

<div class="row" id="masterpage">

	<div class="col-md-12">
	
		<div class="panel panel-white" >
		
		    <div class="panel-heading">
		        <h4 class="no-m m-b-lg">Tambah Pengguna</h4>
		    </div>
		    
		    <div class="panel-body">
		        
		        <br/>
		        
		        <div id="choose" class="row">
		    		<div class="col-md-1">
		    			<button type="button" class="btn btn-primary m-b-sm" id="multi-add-btn">Impor CSV</button>
		    		</div>
		    		<div class="col-md-1">
		    			<button type="button" class="btn btn-primary m-b-sm" id="one-add-btn">Tambah Manual</button>
		    		</div>
		    	</div>
		    
		    	<br/>
		    
		    	<div id="by-csv" class="row" hidden=true>
		    		<div class="col-md-4">
		    			<form enctype="multipart/form-data" id="upload-csv" action="${pageContext.servletContext.contextPath}/admin/user/add/upload" method="post">
				    		<input id="fileInput" type="file" accept=".csv" name="file"/>
				    		<br/>
				        	<button type="submit" class="btn btn-primary m-b-sm" id="upload-csv-btn">Unggah</button>
				    	</form>
		    		</div>
		    	</div>
		    
		    	<div id="by-one" class="row" hidden=true>
		    	
		    		<div class=" col-md-4">
				    		
			    		<form action="${pageContext.servletContext.contextPath}/admin/user/add/" method="post">
			    			<div class="form-group">
						    	<label for="nrp">NRP</label>
						    	<input type="text" class="form-control" id="nrp" placeholder="NRP" name="ni">
						  	</div>
			    			<div class="form-group">
						    	<label for="username">Username</label>
						    	<input type="email" class="form-control" id="username" placeholder="Username" name="username">
						  	</div>
						  	<div class="form-group">
								<select class="form-control" id="sel-type" name="tipe">
				    				<c:forEach items="${userTypes}" var="userType">
										<option>${userType}</option>
									</c:forEach>
							    </select>
						  	</div>
						  	<div class="form-group">
							  	<select class="form-control" id="sel-satman" name="satMan">
									<c:forEach items="${satManList }" var="satMan">
										<option id="${satMan.getIdSatMan()}">${satMan.getNmSatMan()}</option>
									</c:forEach>
							    </select>
						  	</div>
						  	<button type="submit" class="btn btn-primary">Submit</button>
						</form>
		    		
		    		</div>
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
	toastr.options = {
		  "closeButton": false,
		  "debug": false,
		  "newestOnTop": false,
		  "progressBar": true,
		  "positionClass": "toast-top-right",
		  "preventDuplicates": false,
		  "onclick": null,
		  "showDuration": "300",
		  "hideDuration": "1000",
		  "timeOut": "3000",
		  "extendedTimeOut": "1000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "fadeIn",
		  "hideMethod": "fadeOut"
		}
	
	$("#multi-add-btn").click(function() {
		$("#by-one").prop("hidden", true);
		$("#by-csv").prop("hidden", false);
	});
	
	$("#one-add-btn").click(function() {
		$("#by-csv").prop("hidden", true);
		$("#by-one").prop("hidden", false);
	});

</script>