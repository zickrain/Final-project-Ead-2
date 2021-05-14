<%@page	import="Model.Game"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<!-- Font Awesome -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
	<!-- Google Fonts -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
	<!-- Bootstrap core CSS -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
	<!-- Material Design Bootstrap -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">

	<!-- JQuery -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title>Product Details</title>
	<%! Game game; %>
	<%
		game = (Game) request.getSession().getAttribute("game");
		if (game == null) {
			request.getSession().setAttribute("message", "Error");
			response.sendRedirect("AdminHome.jsp");
		}
		assert game != null;%>
</head>
<jsp:include page="../bodyStart.jsp"/>
<nav class="navbar fixed-top navbar-expand-lg navbar-dark" style="background-color: crimson">
	<a class="navbar-brand" href="Menu.jsp">Home</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-333"
			aria-controls="navbarSupportedContent-333" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href="../AdminLogoutServlet"> Logout </a>
</nav>
<h3 class="text-center font-weight-bold text-dark text-uppercase pb-2 mb-4" style="padding-top: 100px">Edit Game Info</h3>
<div>
	<form action="../EditGameServlet" method="post">
		<table class="table">
			<tr>
				<td scope="col">Game Id:</td>
				<td ><input type="text" name="game_id" readonly="readonly" value="<%=game.getGameId()%>" /></td>
			</tr>
			<tr>
				<td scope="col">Game Name:</td>
				<td><input type="text" name="game_name" required="true" value="<%=game.getGameName()%>" /></td>
			</tr>
			<tr>
				<td scope="col">Game Author:</td>
				<td><input type="text" name="game_author" required="true" value="<%=game.getGameAuthor()%>" /></td>
			</tr>
			<tr>
				<td scope="col">Game Img:</td>
				<td><input type="text" name="game_img" required="true" value="<%=game.getGameImg()%>" /></td>
			</tr>
			<tr>
				<td scope="col">Game Description:</td>
				<td><input type="text" name="game_description" required="true" value="<%=game.getGameDescription()%>" /></td>
			</tr>
			<tr>
				<td scope="col">Game Price:</td>
				<td><input type="text" name="game_price" required="true" value="<%=game.getGamePrice()%>" pattern="[0-9.]+" /></td>
			</tr>
			<tr>
				<td scope="col">Game Year:</td>
				<td><input type="text" name="game_year" required="true" value="<%=game.getGameYear()%>" pattern="[0-9.]+" /></td>
			</tr>
			<tr>
				<td><input value="Update Product" type="submit" class="btn btn-elegant" /></td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="../footer.jsp"/>