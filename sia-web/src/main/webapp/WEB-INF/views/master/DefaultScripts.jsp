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
	$("#user-control-a").click(function() {
		if($("#user-control-li").hasClass("open")) {
			$("#user-control-li").removeClass("open");
			$(this).attr("aria-expanded", "false");
		} else {
			$("#user-control-li").toggleClass("open");
			$(this).attr("aria-expanded", "true");
		}
	});
</script>