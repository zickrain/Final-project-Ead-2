<%@page import="java.util.List"%>
 <%@ page import="java.io.*" %>
<%@ page import="Model.Game" %>
<META HTTP-EQUIV="Refresh" CONTENT="5">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<% List<?> games = (List<?>) request.getSession().getAttribute("games");%>
	<%! Game game; %>
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
<h3 class="text-center font-weight-bold text-dark text-uppercase pb-2 mb-4" style="padding-top: 100px">Games</h3>
	<div>
		<table class="table">
			<tr>
				<th scope="col">Game Name</th>
				<th scope="col">Game Author</th>
				<th scope="col">Game Img</th>
				<th scope="col">Game Description</th>
				<th scope="col">Game Price</th>
				<th scope="col">Game Year</th>
				<th scope="col">Edit</th>
				<th scope="col">Delete</th>
			</tr>
			<%
				for (Object obj : games) {
					game = (Game) obj;
			%>
			<tr>
				<td><%=game.getGameName()%></td>
				<td><%=game.getGameAuthor()%></td>
				<td><%=game.getGameImg()%></td>
				<td><%=game.getGameDescription()%></td>
				<td><%=game.getGamePrice()%></td>
				<td><%=game.getGameYear()%></td>
				<td><a href="../EditGameServlet?gameId=<%=game.getGameId()%>" style = "color: cornflowerblue">Edit
				</a></td>
				<td><a href="../DeleteGameServlet?gameId=<%=game.getGameId()%>" style = "color: cornflowerblue">Delete
				</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
<jsp:include page="../footer.jsp"/>