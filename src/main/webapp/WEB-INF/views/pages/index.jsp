<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 5/18/2018
  Time: 12:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script src="/static/script/deleteConfirm.js" ></script>

<div class="panel panel-default">
    <div class="panel-body">
        <table class="table table-striped">
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Country</th>
                <th>Marital Status</th>
                <th>Skills</th>
                <sec:authorize access="hasRole('ADMIN')">
                    <th>Edit</th>
                </sec:authorize>
            </tr>
            <c:forEach items="${employees}" var="employee">
                <tr>
                    <td><c:out value="${employee.name}"/></td>
                    <td><c:out value="${employee.surname}"/></td>
                    <td><c:out value="${employee.country}"/></td>
                    <td><c:out value="${employee.maritalStatus.statoCivile}"/></td>
                    <td>
                        <c:forEach items="${employee.skills}" var="sk">
                            <c:out value="${sk.skill}"/>
                        </c:forEach>
                    </td>
                    <sec:authorize access="hasRole('ADMIN')">
                        <td>
                            <c:url value="" var = "editURL">
                                <c:param name = "username" value = "${employee.username}"/>
                            </c:url>
                            <a href="${editURL}" class="btn btn-default">Edit</a>
                            <!-- Trigger the modal with a button -->
                            <c:url value="/delete/${employee.id}" var = "delURL"> </c:url>
                            <button type="button" class="btn btn-danger deleteBtn" value="${delURL}">Delete</button>
                        </td>
                    </sec:authorize>

                </tr>
            </c:forEach>

        </table>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Conferma cancellazione</h4>
            </div>
            <div class="modal-body">
                <p>Sei sicuro di voler eliminare l'utente?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-danger " id="confirmDelete">Delete</button>
            </div>
        </div>

    </div>

</div>


