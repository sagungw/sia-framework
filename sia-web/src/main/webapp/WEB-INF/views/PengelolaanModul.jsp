<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script src="${pageContext.servletContext.contextPath}/resources/js/app/pengelolaan_peran.js"></script>

<title>Sistem Informasi Akademik - Pengelolaan Modul</title>

<div class="row" id="masterpage">
	<div class="col-md-12">
	
		<div class="panel panel-white">
		
		    <div class="panel-heading">
		        <h3 class="no-m m-b-lg">
		        	Pengelolaan Modul
		        </h3>
		    </div>	
		    
		    <div class="panel-body">
		    
		        <button type="button" class="btn btn-success m-b-sm">Tambah</button>
		        
		        <div class="table-responsive">
		        	
		            <div id="example3_wrapper" class="dataTables_wrapper">
		            	<table id="example3" class="display table dataTable" style="width: 100%;" role="grid" aria-describedby="example3_info">
				            <thead>
				               	<tr role="row">
					               	<th class="" tabindex="0" aria-controls="example3" rowspan="1" colspan="1"  style="width: 300px;">Nama</th>
					               	<th class="" tabindex="0" aria-controls="example3" rowspan="1" colspan="1"  style="width: 100px;">Mapping URL</th>
					               	<th class="" tabindex="0" aria-controls="example3" rowspan="1" colspan="1"  style="width: 100px;">Versi</th>
					               	<th class="" tabindex="0" aria-controls="example3" rowspan="1" colspan="1"  style="width: 100px;">Status</th>
					               	<th class="" tabindex="0" aria-controls="example3" rowspan="1" colspan="1"  style="width: 100px;">Aksi</th>
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
		                                        <td><button class="btn btn-default">Aksi</button><td>
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