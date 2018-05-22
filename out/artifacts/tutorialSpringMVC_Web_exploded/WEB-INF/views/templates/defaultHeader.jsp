<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 5/18/2018
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="">Training SpringMVC</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <c:url value="" var = "addEmployee">
                <c:param name = "id" value = "-1"/>
            </c:url>
            <li class="active"><a href="${addEmployee}">New Employee</a></li>
        </ul>
    </div>
</nav>
