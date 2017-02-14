<%@ page import="java.util.List,com.project2.Model.RateReview"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	List<RateReview> rate_review = (List<RateReview>) request.getAttribute("rate_review");
	String rrid = (String) request.getAttribute("rrid");
	String rrname = (String) request.getAttribute("rrname");
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
			<li><form method="POST" action="login">
						<input type="hidden" name="input_case" value="back" />
						 <input type="submit" value="Back" class="btn-large waves-effect waves-light blue" />
					</form>
			</li></ul>
		</div>
	</nav>
	<div>
	 <%
            if(rate_review.size() == 0)
            {
                %><i>There are no Review in the system.</i><%
            }
            else
            {%>
	
	<c:set var="rrnames" value ="${rrname}"></c:set>
		<h1>${rrnames}</h1>
		<c:forEach items="${rate_review}" var="element">
			<c:if test="${element.rest_id==rrid}">
				<b>Rate :</b>${element.rate} <b>Review :</b>${element.review}
	        	<br></br>
			</c:if>
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
