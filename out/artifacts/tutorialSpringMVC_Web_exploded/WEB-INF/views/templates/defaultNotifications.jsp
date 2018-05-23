<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 5/23/2018
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${not empty notifications}" >
    <c:forEach items="${notifications}" var="n">
        <div class="alert ${n.type} alert-dismissible">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong><c:out value="${n.description}"/>!</strong>
        </div>
    </c:forEach>
</c:if>
