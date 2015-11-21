<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<title>Sistem Informasi Akademik - Pengelolaan Peran Pengguna</title>

<div class="row">

	<div class="col-md-12">
	
		<div class="panel panel-white" >
		
		    <div class="panel-heading">
		        <h4 class="no-m m-b-lg">Pengelolaan Peran Pengguna</h4>
		    </div>
		    
		    <div class="panel-body">
		        
		        <br/>
		        
		        <c:choose>
		        	<c:when test="${not empty user}">
			        	<div class="row" id="one-assign">
				        	<div class="col-md-6">
				        		<form action="${pageContext.servletContext.contextPath}/admin/userRole/add" method="post">
				   					<div class="form-group" hidden=true>
								    	<input type="text" class="form-control" id="id" placeholder="id" name="id" value="${user.getIdPengguna()}">
								  	</div>
					    			<div class="form-group">
								    	<input type="email" class="form-control" id="username" placeholder="Username" name="username" value="${user.getUsername()}" readonly>
								  	</div>
							  		<div class="form-group">
									  	<select class="form-control" id="sel-peran" name="peran">
											<c:forEach items="${peranList}" var="peran">
												<option id="${peran.getIdPeran()}">${peran.getNamaPeran()}</option>
											</c:forEach>
									    </select>
								  	</div>
								  	<div class="form-group">
									  	<select class="form-control" id="sel-satman" name="satMan">
											<c:forEach items="${satManList}" var="satMan">
												<option id="${satMan.getIdSatMan()}">${satMan.getNmSatMan()}</option>
											</c:forEach>
									    </select>
								  	</div>
								  	<button type="submit" class="btn btn-primary">Tambah</button>
								</form>
				        	</div>
				    		<div class="col-md-6">
				    			<c:forEach items="${peranPenggunaList}" var="peranPengguna">
				    				<form action="${pageContext.servletContext.contextPath}/admin/userRole/delete" method="post">
				    					<div class="btn-group">
				    						<div class="form-group" hidden=true>
				    							<input type="text" class="form-control" id="id" placeholder="id" name="id" value="${peranPengguna.getIdPeranPengguna()}">
				    						</div>
											<button type="button" class="btn btn-info">${peranPengguna.getPeran().getNamaPeran()} - ${peranPengguna.getSatMan().getNmSatMan()}</button>
										  	<button type="submit" class="btn btn-info">
											    <span><i class="fa fa-close"></i></span>
										  	</button>
										</div>
				    				</form>
				    				
									<br/>
				    			</c:forEach>
				        	</div>
				    	</div>
		        	</c:when>
		        	<c:otherwise>
			        	<div class="row" id="mult-assign">
				    		<div class="col-md-4">
				    			<form enctype="multipart/form-data" id="upload-csv" action="${pageContext.servletContext.contextPath}/admin/userRole/add/upload" method="post">
						    		<input id="fileInput" type="file" accept=".csv" name="file"/>
						    		<br/>
						        	<button type="submit" class="btn btn-primary m-b-sm" id="upload-csv-btn">Unggah</button>
						    	</form>
				    		</div>
				    	</div>		
		        	</c:otherwise>
		        </c:choose>
		    
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

</script>

<c:if test="${not empty addResponse}">
	<script>
		toastr["${addResponse.getStatus()}"]("${addResponse.getMessage()}");
	</script>
</c:if>
