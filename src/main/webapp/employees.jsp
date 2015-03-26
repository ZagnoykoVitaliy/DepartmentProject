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
</body>
</html>
