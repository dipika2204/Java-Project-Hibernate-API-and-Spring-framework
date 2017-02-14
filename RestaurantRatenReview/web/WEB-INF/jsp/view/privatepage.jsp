<%@ page
	import="java.util.List,com.project2.Model.Rest"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	List<Rest> rest_details = (List<Rest>) request.getAttribute("rest_details");
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
				<li><a href="<c:url value="/login?logout" />"class="btn-large waves-effect waves-light blue">Logout</a></li>
			</ul>
		</div>
	</nav>

	<h1></h1>
	<h1></h1>
	<div class="row">
<%
            if(rest_details.size() == 0)
            {
                %><i>There are no Restaurants in the system.</i><%
            }
            else
            {%>

		<c:forEach items="${rest_details}" var="element">

			<div class="col s3 ">
				<div class="card small">
					<div class="card-image waves-effect waves-block waves-light">
						<img class="activator" src="images/image1.jpg" width=50%
							height=50%>
					</div>
					<div class="card-content">
				<!--	<c:set var="key" value="${element.restName}" />
					-->
					
						<span class="card-title activator grey-text text-darken-4">${element.restName}<i
							class="material-icons right">more_vert</i></span>
	
						<p>Rate:${Math.floor(element.rate_avg)}</p>

					</div>
					<div class="card-reveal">
						<span class="card-title grey-text text-darken-4">${element.restName}<i
							class="material-icons right">close</i></span>
						<p>${element.location}</p>
					<form method="POST" action="<c:url value="/restaurant" />">
					<c:set var="key" value="${element.restName}" scope="request"/>
					<!--<c:out value="${requestScope.key }"/>-->
					<input type="text" name=key value="${element.restId}" hidden=true/>
					<input type="text" name=key_Name value="${element.restName}" hidden=true/>
					<input type="text" name=key_loc value="${element.location}" hidden=true/>
					<input type="submit" name="review"  value="Review"
							class="btn-small waves-effect waves-light grey">
					</form>
					</div>
				</div>
			</div>

		</c:forEach>
<%} %>
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
