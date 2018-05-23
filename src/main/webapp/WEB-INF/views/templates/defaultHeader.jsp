<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
            <sec:authorize access="hasRole('ADMIN')">
                <c:url value="/newEmployee" var = "addEmployee"></c:url>
                <li class="active"><a href="${addEmployee}">New Employee</a></li>
            </sec:authorize>
        </ul>
        <c:if test="${not empty loggedIN }">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="glyphicon glyphicon-user"></span>
                        Welcome <c:out value="${loggedIN}"></c:out>
                    <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <c:url value="/edit/${loggedIN}" var = "editURL"></c:url>
                            <a href="${editURL}" class="btn btn-default">Edit you profile</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <c:url value="/logout" var = "logout"></c:url>
                    <a href="${logout}"><span class="glyphicon glyphicon-log-out"></span>Logout</a>
                </li>
            </ul>
        </c:if>
    </div>
</nav>
