<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 5/18/2018
  Time: 12:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div align="center" id="contenitore">
    EMPLOYEES
    <c:url value="" var = "addEmployee">
        <c:param name = "id" value = "-1"/>
    </c:url>
    <a href="${addEmployee}" style="align: right;">Add employee</a>
</div>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Country</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td><c:out value="${employee.name}"/></td>
            <td><c:out value="${employee.surname}"/></td>
            <td><c:out value="${employee.country}"/></td>
            <td>
                <c:url value="" var = "editURL">
                    <c:param name = "id" value = "${employee.id}"/>
                </c:url>
                <a href="${editURL}">Edit</a>
                <a href="">Remove</a>
            </td>
        </tr>
    </c:forEach>

</table>

