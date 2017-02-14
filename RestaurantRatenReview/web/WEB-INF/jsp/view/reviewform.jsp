<%@ page import="java.util.List,com.project2.Model.RateReview"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	List<RateReview> rate_review = (List<RateReview>) request.getAttribute("rate_review");
	String rrid = (String) request.getAttribute("rrid");
	String rrname = (String) request.getAttribute("rrname");
	String rrloc = (String) request.getAttribute("rrloc");
	//List<RateReview> rate_review = (List<RateReview>) request.getAttribute("rate_review");
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
				<li><a href="<c:url value="/login?logout" />"
					class="btn-large waves-effect waves-light blue">Logout</a></li>

				<li>
					<form method="POST" action="restaurant">
						<input type="submit" name="review" value="Back"
							class="btn-large waves-effect waves-light blue" />
					</form>
				</li>

			</ul>
		</div>
	</nav>
	<div>
		<div>
			<c:set var="rrnames" value="${rrname}"></c:set>
			<c:set var="rrids" value="${rrid}"></c:set>
			<c:set var="rrlocs" value="${rrloc}"></c:set>
			<h1>${rrnames}</h1>
			
		</div>
		<form method="POST" action="restaurant">
			<div class="row">
				<p>Enter your Rating:(between 0-5)</p>
				<i class="material-icons prefix">grade</i> <br /> <input
					type="text" name="review_rate"><br />
				<p>Enter your Review:</p>
				<i class="material-icons prefix">thumbs_up_down</i> <br /> <input
					type="text" name="rate_review"><br /> 
					<input type="text" name=key value="${rrids}" hidden=true /> <input
					type="text" name=key_Name value="${rrnames}" hidden=true />
					<input type="text" name=key_loc value="${rrlocs}" hidden=true /><input type="submit"
					name="review" value="add"
					class="btn-large waves-effect waves-light blue" />
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
