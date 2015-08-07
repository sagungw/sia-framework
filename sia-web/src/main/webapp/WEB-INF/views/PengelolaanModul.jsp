<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<title>Sistem Informasi Akademik - Pengelolaan Modul</title>

<div class="row" id="masterpage">
	<div class="col-md-12">
	
		<div class="panel panel-white" style="max-width: 1000px; margin-left: auto; margin-right: auto;">
		
		    <div class="panel-heading">
		        <h3 class="no-m m-b-lg">
		        	Pengelolaan Modul
		        </h3>
		    </div>
		    
		    <div class="panel-body">
		        
		        <div class="table-responsive">
		        	
		            <div id="example3_wrapper" class="dataTables_wrapper">
		            	<table id="example3" class="display table dataTable" style="width: 100%;" role="grid" aria-describedby="example3_info">
				            <thead>
				               	<tr role="row">
					               	<th class="" tabindex="0" aria-controls="example3" rowspan="1" colspan="1"  style="width: 25%;">Nama</th>
									<th class="" tabindex="0" aria-controls="example3" rowspan="1" colspan="1"  style="width: 20%;">Mapping URL</th>
									<th class="" tabindex="0" aria-controls="example3" rowspan="1" colspan="1"  style="width: 20%;">Versi</th>
									<th class="" tabindex="0" aria-controls="example3" rowspan="1" colspan="1"  style="width: 15%;">Status</th>
									<th class="" tabindex="0" aria-controls="example3" rowspan="1" colspan="1"  style="width: 20%;">Aksi</th>
				               	</tr>
				            </thead>
				            <tfoot>
				                <tr>
				                	<th rowspan="1" colspan="1">Nama</th>
				                	<th rowspan="1" colspan="1">Mapping URL</th>
				                	<th rowspan="1" colspan="1">Versi</th>
				                	<th rowspan="1" colspan="1">Status</th>
				                	<th rowspan="1" colspan="1">Aksi</th>
				                </tr>
				            </tfoot>
		            		<tbody>
		            			<c:choose>
		            				<c:when test="${fn:length(moduleList) > 0}">
		            					<c:forEach items="${moduleList}" var="module">
		            						<tr id="${module.getIdModul()}" role="row" class="odd">
		                                        <td>${module.getNamaModul()}</td>
		                                        <td>${module.getUrlMapping()}</td>
		                                        <td>${module.getVersi()}</td>
		                                        <td>${module.getStatus()}</td>
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
		        </div>
		    </div>
		   
		</div>
	</div>
</div>
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

</script>

