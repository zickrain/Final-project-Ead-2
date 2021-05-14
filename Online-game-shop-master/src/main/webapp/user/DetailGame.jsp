<%@ page import="Model.Game" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sign In Page</title>
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
    <title>Detail Game</title>
    <jsp:useBean id="game" class="Model.Game" scope="session"/>
</head>
<jsp:include page="../bodyStart.jsp"/>
<nav class="navbar fixed-top navbar-expand-lg navbar-dark" style="background-color: crimson">
    <a class="navbar-brand" href="Menu.jsp">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-333"
            aria-controls="navbarSupportedContent-333" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="../UserLogoutServlet"> Logout </a>
</nav>
<h3 class="text-center font-weight-bold text-dark text-uppercase pb-2 mb-4" style="padding-top: 100px">Add New Game</h3>
<div>
    <form action="../GameDetailServlet" method="post">
        <table class="table">
            <tr>
                <td scope="col">Game Id:</td>
                <td><jsp:getProperty name="game" property="gameId"/></td>
            </tr>
            <tr>
                <td scope="col">Game Name:</td>
                <td><jsp:getProperty name="game" property="gameName"/></td>
            </tr>
            <tr>
                <td scope="col">Game Author:</td>
                <td><jsp:getProperty name="game" property="gameAuthor"/></td>
            </tr>
            <tr>
                <td scope="col">Game Img:</td>
                <td><jsp:getProperty name="game" property="gameImg"/></td>
            </tr>
            <tr>
                <td scope="col">Game Description:</td>
                <td><jsp:getProperty name="game" property="gameDescription"/></td>
            </tr>
            <tr>
                <td scope="col">Game Price:</td>
                <td><jsp:getProperty name="game" property="gamePrice"/></td>
            </tr>
            <tr>
                <td scope="col">Game Year:</td>
                <td><jsp:getProperty name="game" property="gameYear"/></td>
            </tr>
            <tr>
                <td scope="col"><a href="../BuyCartServlet?gameId=<jsp:getProperty name="game" property="gameId"/>">
                    <button type="button" class="btn btn-elegant">Buy Carts</button>
                </a></td>
            </tr>
        </table>
    </form>
</div>
<jsp:include page="../footer.jsp"/>

