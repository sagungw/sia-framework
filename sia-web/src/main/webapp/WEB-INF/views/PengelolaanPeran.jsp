<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script src="${pageContext.servletContext.contextPath}/resources/js/app/pengelolaan_peran.js"></script>

<div class="row" id="masterpage">
	<div class="col-md-12">
	
		<div class="panel panel-white" style="max-width:700px; margin-left: auto; margin-right: auto">
		
		    <div class="panel-heading">
		        <h3 class="no-m m-b-lg">
		        	<c:choose>
		        		<c:when test="${chooseOnly == null}">Pengelolaan Peran Pengguna</c:when>
		        		<c:otherwise>Pilih Peran</c:otherwise>
		        	</c:choose>
		        </h3>
		    </div>	
		    
		    <div class="panel-body">
		    
		        <button type="button" class="btn btn-success m-b-sm" data-toggle="modal" data-target="#modalAdd"><c:if test="${chooseOnly == null}">Tambah</c:if></button>
		        
		        <!-- Modal -->
		        <form id="add-row-form" action="javascript:void(0)" method="POST">
			        <div class="modal fade" id="modalAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
			            <div class="modal-dialog modal-sm">
			                <div class="modal-content">
			                    <div class="modal-header">
			                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
			                        <h4 class="modal-title" id="modalAddLabel">Tambah Peran</h4>
			                    </div>
			                    <div class="modal-body">
			                            <div class="form-group">
			                                <input type="text" id="peranInputAdd" class="form-control" placeholder="Peran" required="">
			                            </div>
			                    </div>
			                    <div class="modal-footer">
			                        <button type="button" class="btn btn-default" data-dismiss="modal">Batal</button>
			                        <button type="submit" id="peranTambah" class="btn btn-success">Tambah</button>
			                    </div>
			                </div>
			            </div>
			        </div>
		        </form>
		        
				<!-- Modal -->
		        <form id="edit-row-form" action="javascript:void(0)" method="POST">
			        <div class="modal fade" id="modalEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
			            <div class="modal-dialog modal-sm">
			                <div class="modal-content">
			                    <div class="modal-header">
			                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
			                        <h4 class="modal-title" id="modalEditLabel">Ubah Peran</h4>
			                    </div>
			                    <div class="modal-body">
			                            <div class="form-group">
			                                <input type="text" id="peranInputEdit" class="form-control" placeholder="Peran" required="">
			                            </div>
			                    </div>
			                    <div class="modal-footer">
			                        <button type="button" class="btn btn-default" data-dismiss="modal">Batal</button>
			                        <button type="submit" id="peranUbah" class="btn btn-success">Ubah</button>
			                    </div>
			                </div>
			            </div>
			        </div>
		        </form>
		        
		        <div class="table-responsive">
		        	
		            <div id="example3_wrapper" class="dataTables_wrapper">
		            	<table id="example3" class="display table dataTable" style="width: 100%;" role="grid" aria-describedby="example3_info">
				            <thead>
				               	<tr role="row">
					               	<th class="" tabindex="0" aria-controls="example3" rowspan="1" colspan="1"  style="width: 300px;">Peran</th>
					               	<c:if test="${chooseOnly == null}">
						               	<th class="" tabindex="0" aria-controls="example3" rowspan="1" colspan="1"  style="width: 100px;">Ubah</th>
						               	<th class="" tabindex="0" aria-controls="example3" rowspan="1" colspan="1"  style="width: 100px;">Hapus</th>
					               	</c:if>
					               	<th class="" tabindex="0" aria-controls="example3" rowspan="1" colspan="1"  style="width: 100px;">Tetapkan Pengguna</th>
				               	</tr>
				            </thead>
				            <tfoot>
				                <tr>
				                	<th rowspan="1" colspan="1">Peran</th>
				                	<th rowspan="1" colspan="1">Ubah</th>
				                	<th rowspan="1" colspan="1">Hapus</th>
				                	<th rowspan="1" colspan="1">Tetapkan Pengguna</th>
				                </tr>
				            </tfoot>
		            		<tbody>
		            			<c:choose>
		            				<c:when test="${fn:length(daftarPeran) > 0}">
		            					<c:forEach items="${daftarPeran}" var="peran">
		            						<tr id="${peran.getIdPeran()}" role="row" class="odd">
		                                        <td class="nama-peran">${peran.getNamaPeran()}</td>
		                                        <c:if test="${chooseOnly == null}">
			                                        <td><button type="button" class="btn btn-info edit" data-toggle="modal" data-target="#modalEdit">Ubah</button></td>
			                                        <td><button type="button" class="btn btn-danger delete">Hapus</button></td>
			                                    </c:if>
		                                        <td>
		                                        	<form method="post" action="${pageContext.servletContext.contextPath}/pengelolaanPeranPengguna/tetapkanPeran">
		                                        		<input type="hidden" value="${peran.getIdPeran()}" name="idPeran"/>
		                                        		<button class="btn btn-default">Tetapkan Pengguna</button>
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
