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
</head>
<jsp:include page="bodyStart.jsp"/>
<nav class="navbar fixed-top navbar-expand-lg navbar-dark" style="background-color: crimson">
    <a class="navbar-brand" href="index.jsp">Change Role</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-333"
            aria-controls="navbarSupportedContent-333" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>
<section class="p-5  text-center"
         style="background-size: cover; background-color: seashell; height: 810px">
    <h3 class="text-center font-weight-bold text-light-dark text-uppercase pb-2 mb-4" style="margin-top: 100px">Sign in</h3>
    <form class="mb-5 mx-md-5" action="AdminLoginServlet" method="POST">
        <div class="col-md-4 mb-4" style="margin: auto;">
            <input class="form-control" type="email" name="admin-username" placeholder="Login"/>
        </div>
        <div class="col-md-4 mb-4" style="margin: auto;">
            <input type="password" class="form-control" name="admin-password" placeholder="Password"/>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-elegant">Sign in</button> <br><br>
        </div>
    </form>
</section>
<jsp:include page="footer.jsp"/>