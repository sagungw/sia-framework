<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Tambah Modul</title>

<div class="row" id="masterpage">
	<div class="col-md-12">
		<div id="panel-unggah" class="panel panel-white">
			<div class="panel-heading clearfix">
				<h4 class="panel-title">Tambah Modul</h4>
			</div>
			<div class="panel-body">
				<div class="progress">
					<div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;"></div>
				</div>	
				
				<div id="detail-row" class="row" >
	            	<div class="col-md-12">
			    		<p>
                           	<strong>Keterangan Akhir Modul</strong>
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
	                				<th>Peran</th>
	                           	</tr>
	                       	</thead>
	                       	<tbody>
	                       		<c:forEach items="${modul.getMenus()}" var="menu">
		                       		<tr>
		                       			<td>${menu.getNamaMenu()}</td>
		                       			<td>
		                       				<ul>
		                       					<c:forEach items="${menu.getDaftarMenuPeran()}" var="menuPeran">
		                       						<li>${menuPeran.getPeran().getNamaPeran()}</li>
		                       					</c:forEach>
		                       				</ul>
		                       			</td>
	                       			</tr>
	                       		</c:forEach>
	                       	</tbody>
	                  	</table>
	            	</div>
	            	
	            	<div class="col-md-12">
		            	<form class="m-t-md" action="${pageContext.servletContext.contextPath}/admin/module/uploadWizard/4/end" method="post">
                            <input type="text" name="wizardEnd" hidden="true">
	                        <button type="submit" class="btn btn-success">Selesai</button>
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

