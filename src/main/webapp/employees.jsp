<%--
  Created by IntelliJ IDEA.
  User: Frederick
  Date: 25.03.2015
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Employees</title>
</head>
<body>
<h1>Employees</h1>

<ul>
    <c:choose>
        <c:when test="${not empty allEmployees}">
            <c:forEach items="${allEmployees}" var="employee">
                <li>
                    <form>
                        <input name="employeeId" type="text" value="${employee.employeeId}"/>
                        <input name="employeeName" type="text" value="${employee.name}"/>
                        <input name="employeeBirthDate" type="text" value="${employee.birthDate}"/>
                        <input name="employeePhone" type="text" value="${employee.phone}"/>
                        <input name="employeeAddress" type="text" value="${employee.address}"/>
                        <input name="employeeHireDate" type="text" value="${employee.hireDate}"/>
                        <input name="employeeEmail" type="text" value="${employee.email}"/>
                        <input type="submit" formaction="updateEmployee" formmethod="post" value="Update"/>
                        <input type="submit" formaction="deleteEmployee" formmethod="post" value="Delete"/>
                    </form>
                </li>
            </c:forEach>
        </c:when>
        <c:otherwise>
            Employees not found
        </c:otherwise>
    </c:choose>
</ul>
<ul>
    <li>
        <form>
            <br>Department Id<input name="DepartmentId" type="text"/></br>
            <br>Employee name <input name="employeeName" type="text"/></br>
            <br>Birth date <input birthDate="employeeBirthDate" type="text"/></br>
            <br>Address <input address="employeeAddress" type="text"/></br>
            <br>Phone <input phone="employeePhone" type="text"/></br>
            <br>Hire date <input employeeHireDate="employeeHireDate" type="text"/></br>
            <br>Email <input email="employeeEmail" type="text"/></br>
            <br><input type="submit" formaction="createEmployee" formmethod="post" value="Create employee"/></br>
        </form>
    </li>
</ul>
</body>
</html>
