<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 5/28/2018
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="/static/script/changePassword.js"></script>

<div class="generic-container">
    <div class="well lead">Change Password</div>
    <c:url var="changeURL" value="/changePW/${loggedIN}" />
    <form action="${changeURL}" method="post" class="form-horizontal validatedForm">

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="oldPassword">Old password*</label>
                <div class="col-md-7">
                    <input type="password" class="form-control" id="oldPassword" name="oldPassword" placeholder="Enter old password" required>
                    <div class="has-error"></div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="newPassword">New password*</label>
                <div class="col-md-7">
                    <input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="Enter new Password" required>
                    <div class="has-error"></div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="confirmPassword">Confirm password*</label>
                <div class="col-md-7">
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm password" required>
                    <div class="has-error"></div>
                </div>
            </div>
        </div>

        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

        <div class="row">
            <div class="form-actions floatRight col-md-7">
                <input type="submit" value="Change password" class="btn btn-primary btn-sm"/> or
                <a href="<c:url value='/' />">Cancel</a>
            </div>
        </div>

    </form>
</div>