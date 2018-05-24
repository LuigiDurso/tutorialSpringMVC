<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 5/22/2018
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="generic-container">
    <div class="well lead">User Registration Form</div>
    <form:form  method="POST" modelAttribute="employee" class="form-horizontal">
        <form:hidden path="id"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="firstName">First Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="name" id="firstName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="name" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="lastName">Last Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="surname" id="lastName" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="surname" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="birthDate">BirthDate</label>
                <div class="col-md-7">
                    <form:input type="date" path="birthDate" id="birthDate" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="birthDate" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="country">Country</label>
                <div class="col-md-7">
                    <form:input type="text" path="country" id="country" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="country" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="username">Username</label>
                <div class="col-md-7">
                    <form:input type="text" path="username" id="username" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="username" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="password">Password</label>
                <div class="col-md-7">
                    <form:input type="password" path="password" id="password" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="password" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="maritalStatus">Marital Status</label>
                <div class="col-md-7">
                    <form:select path="maritalStatus" class="form-control input-sm">
                        <form:options items="${maritalStatues}" itemValue="statoCivile" itemLabel="statoCivile"/>
                    </form:select>
                    <div class="has-error">
                        <form:errors path="${maritalStatus}" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="skillList">Skills</label>
                <div class="col-md-7">
                    <form:select multiple="true" path="skillList" class="form-control input-sm">
                        <form:options items="${skills}" itemValue="skill" itemLabel="skill"/>
                    </form:select>
                    <div class="has-error">
                        <form:errors path="skillList" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="userProfiles">Role</label>
                <div class="col-md-7">
                    <form:select multiple="true" path="userProfiles" class="form-control input-sm" >
                        <form:options items="${roles}" itemValue="type" itemLabel="type"/>
                    </form:select>
                    <div class="has-error">
                        <form:errors path="userProfiles" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-actions floatRight col-md-7">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a

                            href="<c:url value='/' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a

                            href="<c:url value='/' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</div>
