<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
    <title>LowCoster</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet">

    <style type="text/css">
        <%@include file="../../css/bootstrap.min.css" %>
        <%@include file="../../css/normalize.min.css" %>
        <%@include file="../../css/font-awesome.min.css" %>
        <%@include file="../../css/animate.css" %>
        <%@include file="../../css/templatemo_misc.css" %>
        <%@include file="../../css/templatemo_style.css" %>
        <%@include file="../../css/style.css" %>
    </style>

    <script src="../../js/vendor/modernizr-2.6.2.min.js"></script>

</head>
<body>

    <div id="front">
        <div class="site-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 col-sm-6 col-xs-6">
                        <div id="templatemo_logo">
                            <h1><a href="controller?command=go_to_welcome_page">LowCoster</a></h1>
                        </div> <!-- /.logo -->
                    </div> <!-- /.col-md-4 -->
                    <div class="col-md-8 col-sm-6 col-xs-6">
                        <h1 style="text-align: center; color: whitesmoke">Авторизация</h1>
                    </div> <!-- /.col-md-8 -->
                </div> <!-- /.row -->
            </div> <!-- /.container -->
        </div> <!-- /.site-header -->
    </div> <!-- /#front -->

    <div class="site-slider"></div>

    <div id="" class="content">
        <form class="box" action="controller" method="get">
            <input type="hidden" name="command" value="authorize_user">
            <input type="text" name="login" placeholder="Логин" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{3,20}$">
            <input type="password" name="password" placeholder="Пароль" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{3,20}$">
            <c:if test="${requestScope.error == 'incorrect login or password'}">
                <p style="color: red;">Неверный логин или пароль</p>
            </c:if>
            <input type="submit" name="" value="Войти">
            <div style="margin-top: 20px">
                <a href="controller?command=go_to_registration_page">Зарегистрироваться</a>
            </div>
        </form>
    </div>

    <div class="site-footer footer">
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-sm-6">
                            <span id="copyright">
                            Copyright &copy; 2020 <a href="#">epam</a> . Design: Template Mo </span>

                </div> <!-- /.col-md-6 -->
                <div class="col-md-4 col-sm-6">
                    <ul class="social">
                        <li><a href="#" class="fa fa-facebook"></a></li>
                        <li><a href="#" class="fa fa-twitter"></a></li>
                        <li><a href="#" class="fa fa-instagram"></a></li>
                        <li><a href="#" class="fa fa-linkedin"></a></li>
                        <li><a href="#" class="fa fa-rss"></a></li>
                    </ul>
                </div> <!-- /.col-md-6 -->
            </div> <!-- /.row -->
        </div> <!-- /.container -->
    </div> <!-- /.site-footer -->
</body>
</html>
