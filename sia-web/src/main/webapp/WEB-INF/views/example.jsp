<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<div>
	<div id="clickme">CLICK ME!!!</div>
</div>

<script src="${pageContext.servletContext.contextPath}/resources/plugins/jquery/jquery-2.1.3.min.js"></script>
<script>
	
	$("#clickme").click(function() {
		console.log("YEAH BOY!! U CLICKED ME!!");
		var contextPath = "${pageContext.servletContext.contextPath}";
		var id = "r1";
		var menus = ["m1", "m2", "m3"];
		var json = {roleId: id, roleMenus: menus};
		$.ajax({
			url: contextPath + "/example/submit",
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(json),
			success: function() {
				console.log("json object saved");
			}
		});
	});
	
</script>

</body>
</html>
