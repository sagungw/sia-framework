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
					<div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;"></div>
				</div>
				
				<div id="assignment-row" class="row" >
				
					<div class="col-md-12">
			    		<p>
                           	<strong>Tambah Hak Akses</strong>
                        </p>
			    	</div>
				
					<div id="role-list" class="col-md-6">
		                <div class="dd" id="nestable">
		                    <ol class="dd-list">
		                    	<c:forEach items="${roles}" var="role">
		                    		<li class="dd-item" data-id="1">
		                            	<div id="${role.getIdPeran()}" class="dd-handle role-item" style="cursor: pointer;">${role.getNamaPeran()}</div>
		                        	</li>
		                    	</c:forEach>
		                    </ol>
		                </div>
		            </div>
		            
		            <div id="menu-list" class="col-md-6">
		                <div class="dd" id="nestable">
		                    <ol class="dd-list">
			                    <c:forEach items="${menus}" var="menu">
			                    	<li class="dd-item" data-id="1">
			                            <div id="${menu.getIdMenu()}" class="dd-handle role-menu" style="cursor: pointer;">${menu.getNamaMenu() }</div>
			                        </li>
			                    </c:forEach>
		                    </ol>
		                </div>
		            </div>
		            
		            <div class="col-md-12">
		            	<button id="btn-submit" type="button" class="btn btn-info">Simpan</button>
		            </div>
		            
	            </div>
	            
	            <div id="detail-row" class="row" style="display: none;">
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
	                				<th>Peran</th>
	                           	</tr>
	                       	</thead>
	                       	<tbody>
	                       		<c:forEach items="${modul.getMenus()}" var="menu">
		                       		<tr>
		                       			<td>${menu.getNamaMenu()}</td>
		                       			<td>
		                       				<ul>
		                       					<c:forEach items="${menu.getMenuPerans()}" var="menuPeran">
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
		            	<button id="btn-back" type="button" class="btn btn-info">Kembali</button>
		            	<button id="btn-done" type="button" class="btn btn-info">
			            	<a href="${pageContext.servletContext.contextPath}/admin/module">
			            		Selesai
			            	</a>
		            	</button>
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

    var selectedRole = null;
    var roles = [];

    $(".role-item").click(function() {
        $(".dd-handle").css({"background-color": "#fafafa", "color": "#333"});
        $("#menu-list").css("display", "");
        var idRole = $(this).attr("id");
        if(! roles[idRole]) {
            roles[idRole] = [];
        } 
        selectedRole = idRole;
        $(this).css({"background-color": "#12AFCB", "color": "white"});
        for(var index = 0; index < roles[idRole].length; index++) {
            var idMenu = roles[idRole][index];
            $("#" + idMenu + "").css({"background-color": "#12AFCB", "color": "white"});
        }
    });

    $(".role-menu").click(function() {
        if(selectedRole != null) {
            var idMenu = $(this).attr("id");
            if($.inArray(idMenu, roles[selectedRole]) == -1) {
                roles[selectedRole].push(idMenu);   
                $(this).css({"background-color": "#12AFCB", "color": "white"});
            } else {
                var index = $.inArray(idMenu, roles[selectedRole]);
                roles[selectedRole].splice(index, 1);
                $(this).css({"background-color": "#fafafa", "color": "#333"});
            }
        }
    });
    
    $("#btn-submit").click(function() {
    	if(selectedRole != null) {
    		var contextPath = "${pageContext.servletContext.contextPath}";
    		var success = true;
    		$(".role-item").each(function() {
    			var id = $(this).attr("id");
    			var json = {roleId: id, roleMenus: roles[id]};
    			$.ajax({
    				url: contextPath + "/admin/module/uploadWizard/2/submit",
    				type: 'POST',
    				contentType: 'application/json',
    				data: JSON.stringify(json),
    				success: function(result) {
       					if(result.data == null) {
       						success = false;
       					}
       			 	}
       			});
    		});
    		if(success == true) {
    			$("#detail-row").css("display", "");
        		$("#assignment-row").css("display", "none");
        		toastr["success"]("penambahan hak akses untuk menu berhasil");
    		} else {
    			toastr["error"]("penambahan hak akses untuk menu gagal");
    		}
    		
    	} else {
    		toastr["error"]("mohon untuk mengisi hak akses sebelum melanjutkan");
    	}
    });
    
    $("#btn-back").click(function() {
    	$("#detail-row").css("display", "none");
		$("#assignment-row").css("display", "");
    });
    
</script>