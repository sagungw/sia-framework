<script src="${pageContext.servletContext.contextPath}/resources/plugins/jquery/jquery-2.1.3.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/plugins/pace-master/pace.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/plugins/jquery-blockui/jquery.blockui.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/plugins/switchery/switchery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/plugins/uniform/jquery.uniform.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/plugins/offcanvasmenueffects/js/classie.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/plugins/offcanvasmenueffects/js/main.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/plugins/waves/waves.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/plugins/3d-bold-navigation/js/main.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/plugins/metrojs/MetroJs.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/modern.js"></script>
<script>
	var idPengguna = "${sessionScope.userRoleSession.getPengguna().getIdPengguna()}";
	getRoles(idPengguna);
	
	$("#user-control-a").click(function() {
		if($("#user-control-li").hasClass("open")) {
			$("#user-control-li").removeClass("open");
			$(this).attr("aria-expanded", "false");
		} else {
			$("#user-control-li").toggleClass("open");
			$(this).attr("aria-expanded", "true");
		}
	});
	
	$("#role-select").on("change", function() {
		var idPeran = $(this).val();
		var idPengguna = "${sessionScope.userRoleSession.getPengguna().getIdPengguna()}";
		if(idPeran != "" && idPeran != null) {
			$("#satman-select").empty();
			$("#satman-select").append("<option value=\"\">-- Satuan Manajemen --</option>");
			getSatMan(idPeran, idPengguna);
		} else {
			$("#satman-select").empty();
			$("#satman-select").append("<option value=\"\">-- Satuan Manajemen --</option>");
		}
	});
	
	$("#satman-select").on("change", function(){
		var idSatMan = $(this).val();
		var idPeran = $("#role-select").val();
		var currentIdSatMan = "${sessionScope.userRoleSession.getSatMan().getIdSatMan()}";
		var currentIdPeran = "${sessionScope.userRoleSession.getPeran().getIdPeran()}";
		if(idSatMan != null && idSatMan != "") {
			if(idSatMan != currentIdSatMan || idPeran != currentIdPeran) {
				$("#hot-swap-role").val(idPeran);
				$("#hot-swap-satman").val(idSatMan);
				$("#hot-swap-role-form").submit();	
			}
		}
	});
	
	function getRoles(idPengguna) {
		$.ajax({
			url: contextPath + "/session/getRoles",
			type: "POST",
			data: {
				"idPengguna": idPengguna		
			},
			success: function(response) {
				for(var i = 0 ; i < response.length; i++) {
					$("#role-select").append("<option value=" + response[i].roleId + ">" + response[i].roleName + "</option>");
				}
			}
		});	
	}
	
	function getSatMan(idPeran, idPengguna) {
		$.ajax({
			url: contextPath + "/session/getSatMan",
			type: "POST",
			data: {
				"idPeran": idPeran,
				"idPengguna": idPengguna		
			},
			success: function(response) {
				for(var i = 0 ; i < response.length; i++) {
					$("#satman-select").append("<option value=" + response[i].idSatMan + ">" + response[i].namaSatMan + "</option>");
				}
			}
		});	
	} 
</script>