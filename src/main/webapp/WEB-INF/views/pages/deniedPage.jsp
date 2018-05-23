<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 5/23/2018
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="generic-container">
    <div class="authbar">
        <span>Dear <strong>${loggedinuser}</strong>, You are not authorized to access this page.</span>
        <span class="floatRight"><a href="<c:url value="/logout" />">Logout</a></span>
    </div>
</div>
