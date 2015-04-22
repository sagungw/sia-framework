<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
		<script src="<c:url value="/resources/login/js/jquery-1.11.0.js"/>"></script>
	    <script src="<c:url value="/resources/login/js/bootstrap.min.js"/>"></script>
	    <link href="<c:url value="/resources/login/css/bootstrap.min.css"/>" rel="stylesheet">
	    <link href="<c:url value="/resources/app/css/login.css"/>" rel="stylesheet">
	    <script type="text/javascript">
		    $(document).ready(function () {
		    	$('#username_tb').focusin(function() {
		    		$(this).attr('placeholder','');
		    	});
		    	$('#username_tb').focusout(function() {
		    		$(this).attr('placeholder','Username');
		    	});
		    	
		    	$('#password_tb').focusin(function() {
		    		$(this).attr('placeholder','');
		    	});
		    	$('#password_tb').focusout(function() {
		    		$(this).attr('placeholder','Password');
		    	});
		    });
	    </script>
	</head>

	<body>

	    <div class="login_container panel-default">
	        <div class="panel-heading" align="center" >
	            <img src="<c:url value="/resources/landingpage/images/s03.png"/>">
	        </div>
	        <div class="panel-body">
	            <form role="form" action="authenticate" method="post">
	                <fieldset>
	                    <div class="form-group">
	                        <input id="username_tb" class="form-control" placeholder="Username" name="usernameLogin" type="text" />
	                    </div>
	                    <div class="form-group">
	                        <input id="password_tb" class="form-control" placeholder="Password" name="passwordLogin" type="password" />
	                    </div>
	                    <input type="submit" class="btn btn-lg btn-primary btn-block" value="Masuk"/>
	                </fieldset>
	            </form>
	        </div>
	    </div>

	</body>

</html>
