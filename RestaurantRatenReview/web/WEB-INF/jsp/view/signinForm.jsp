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
	<!-- ---------------------nav------------------------------- -->
	<nav class="light-blue lighten-1" role="navigation">
		<div class="nav-wrapper container">
			<a id="logo-container" href="#" class="brand-logo">CONNOISSEUR</a>
			<ul class="right hide-on-med-and-down">
				<!-- <li><a href="login.jsp">Log In</a></li>-->
				<li><form method="POST" action="<c:url value="/login" />">
						<input type="submit" name="input_case" value="login-page"
							class="btn-medium waves-effect waves-light blue"> <input
							type="submit" name="input_case" value="Home-page"
							class="btn-medium waves-effect waves-light blue">
					</form></li>
			</ul>



		</div>
	</nav>

	<!-- ----------------------------------------------- -->

	<div class="body_signup">
		<div class="signup">
			<h4 class="light-blue-text">SIGN-UP</h4>
		</div>
		<form method="POST" action="login" class="col s12">
			<input type="hidden" name="input_case" value="sign-up" />
			<div class="row">
				<div class="input-field col s6">
					<p>Enter Username:</p>
					<i class="material-icons prefix">account_circle</i> <br /> <input
						type="text" name="input_username"><br />

				</div>
			</div>

			<div class="row">
				<div class="input-field col s6">
					<p>Enter Password:</p>
					<i class="material-icons prefix">vpn_key</i> <br /> <input
						type="password" name="input_password"><br />

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
					<p class="grey-text text-lighten-4">Done by:
					<p class="grey-text text-lighten-4">Dipika Mahashabde</p>
					</p>

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
