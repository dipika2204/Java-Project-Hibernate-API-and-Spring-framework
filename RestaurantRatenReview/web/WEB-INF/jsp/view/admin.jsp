<%@ page import="java.util.List,com.project2.Model.Rest"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	List<Rest> rest_details = (List<Rest>) request.getAttribute("rest_details");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0" />
<title>CONNOISSEUR</title>
<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/mystyle.css" type="text/css" rel="stylesheet"
	media="screen,projection" />

</head>
<body>
	<!-- HOME PAGE -->
	<nav class="light-blue lighten-1" role="navigation">
		<div class="nav-wrapper container">
			<a id="logo-container" href="#" class="brand-logo">CONNOISSEUR</a>
			<ul class="right hide-on-med-and-down">
				<li><a href="<c:url value="/login?logout" />"class="btn-large waves-effect waves-light blue">Logout</a></li>
			</ul>
		</div>
		
	</nav>
	
		<div class="body_signup">
		<div class="signup">
			<h4 class="light-blue-text">ADD</h4>
		</div>
		<form method="POST" action="admin" class="col s12">
			<input type="hidden" name="add_rest" value="add" />
			<div class="row">
				<div class="input-field col s6">
					<p>Enter Restaurant Name:</p>
					<i class="material-icons prefix">local dining</i> <br /> <input
						type="text" name="restaurant_name"><br />

				</div>
			</div>

			<div class="row">
				<div class="input-field col s6">
					<p>Enter Location</p>
					<i class="material-icons prefix">add location</i> <br /> <input
						type="text" name="location"><br />

					<div class="row center">
						<input type="submit" value="Submit" id="download-button"
							class="btn-large waves-effect waves-light orange" />
					</div>
				</div>
			</div>

		</form>

	</div>


	<!-- -----------------------footer------------- -->
	<footer class="page-footer orange">
		<div class="container">
			<div class="row">
				<div class="col l6 s12">
					<h5 class="white-text">CPSC 476 Graduate Project</h5>
					<p class="grey-text text-lighten-4">Done by:</p>
					<p class="grey-text text-lighten-4">Dipika Mahashabde</p>


				</div>
				<div class="col l3 s12"></div>
				<div class="col l3 s12">
					<ul>
						<li><a class="white-text" href="#!">Guided by:</a></li>
						<li><a class="white-text" href="#!">Prof Kenytt Avery</a></li>

					</ul>
				</div>
			</div>
		</div>
		<div class="footer-copyright">
			<div class="container">
				Made by <a class="grey-text text-lighten-3"
					href="http://materializecss.com">Materialize</a>
			</div>
		</div>
	</footer>


	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="js/materialize.js"></script>
	<script src="js/init.js"></script>



</body>
</html>
