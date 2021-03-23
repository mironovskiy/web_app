<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">

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
    </style>

    <script src="js/vendor/modernizr-2.6.2.min.js"></script>

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
                    <a href="#" class="toggle-menu"><i class="fa fa-bars"></i></a>
                    <div class="main-menu">
                        <ul>
                            <li><a href="#front">Пользователи</a></li>
                            <li><a href="#services">Аэропорты</a></li>
                            <li><a href="#products">Авиапарк</a></li>
                            <li><a href="#products">Маршруты</a></li>
                            <li><a href="#products">Рейсы</a></li>
                            <li><a href="#products">Билеты</a></li>
                        </ul>
                    </div> <!-- /.main-menu -->
                </div> <!-- /.col-md-8 -->
            </div> <!-- /.row -->
        </div> <!-- /.container -->
    </div> <!-- /.site-header -->
</div> <!-- /#front -->


<div class="site-slider">
    <ul class="bxslider">
        <li>
            <img src="images/slider/slide1.jpg" alt="slider image 1">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-right">
                        <div class="slider-caption">
                            <h2>Ближайшие рейсы</h2>
                        </div>
                    </div>
                </div>
            </div>
        </li>
        <li>
            <img src="images/slider/slide222.jpg" alt="slider image 2">
            <div class="container caption-wrapper">
                <div class="slider-caption">
                    <h2>Купить билеты</h2>
                </div>
            </div>
        </li>
        <li>
            <img src="images/slider/slide333.jpg" alt="slider image 3">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-right">
                        <div class="slider-caption">
                            <h2><a href="controller?command=go_to_authorization_page" style="color: black">Авиапарк</a></h2>
                        </div>
                    </div>
                </div>
            </div>
        </li>
    </ul> <!-- /.bxslider -->
    <div class="bx-thumbnail-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div id="bx-pager">
                        <a data-slide-index="0" href=""><img src="images/slider/thumb1.jpg" alt="image 1" /></a>
                        <a data-slide-index="1" href=""><img src="images/slider/thumb2.jpg" alt="image 2" /></a>
                        <a data-slide-index="2" href=""><img src="images/slider/thumb3.jpg" alt="image 3" /></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> <!-- /.site-slider -->

<div class="site-footer">
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

<script src="js/vendor/jquery-1.10.1.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.1.min.js"><\/script>')</script>
<script src="js/jquery.easing-1.3.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>
</body>
</html>