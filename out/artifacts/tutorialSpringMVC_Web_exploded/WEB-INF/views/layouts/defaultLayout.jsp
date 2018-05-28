<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 5/18/2018
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" photo="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/errors.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

    <title><tiles:getAsString name="title" /></title>
</head>

<body>
<header id="header">
    <tiles:insertAttribute name="header" />
</header>

<section id="site-photo">
    <tiles:insertAttribute name="body" />
</section>

<tiles:insertAttribute name="notification" />
</body>
</html>
