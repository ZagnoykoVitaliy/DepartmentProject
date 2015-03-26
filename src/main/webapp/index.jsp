<!doctype html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Departments</title>
    <link rel="stylesheet" href="assets/style.css">
</head>

<body>
<h1 class="department_header">Departments</h1>

<jsp:include page="/getdeps" flush="true"/>
<ul>
    <c:choose>
        <c:when test="${not empty allDepartments}">
            <c:forEach items="${allDepartments}" var="department">
                <li class="department_control">
                    <form>
                        <input name="departmentId" type="hidden" value="${department.departmentId}"/>
                        <input name="departmentName" type="text" value="${department.name}"/>

                        <input type="submit" formaction="updateDepartment" formmethod="post" value="Update"/>
                        <input type="submit" formaction="deleteDepartment" formmethod="post" value="Delete"/>
                        <input type="submit" formaction="getemployees" formmethod="post" value="Employees"/>
                    </form>
                </li>

            </c:forEach>
        </c:when>

        <c:otherwise>
            No department found
        </c:otherwise>
    </c:choose>
</ul>
<ul>
    <li>
        <form>
            <input name="departmentName" type="text"/>
            <input type="submit" formaction="createDepartment" formmethod="post" value="Create department"/>
        </form>
    </li>
</ul>
</body>
</html>

