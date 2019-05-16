<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Project status page</title>
</head>
<body>
<p>
    <b>Projects :</b>
</p>
    <c:if test="${not empty message}">
        <p><b>${message}</b></p>
    </c:if>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Create date</th>
			<th>Start date</th>
			<th>End date</th>
    		<th>Status</th>
    		<th>Id</th>
    		<th>Edit</th>
    		<th>Delete</th>
		</tr>
		<c:forEach items="${projects}" var="project" varStatus="status">
		<tr>
			<td>${project.name}</td>
			<td>${project.description}</td>
			<td>${project.createDate}</td>
			<td>${project.startDate}</td>
			<td>${project.endDate}</td>
			<td>${project.status.name}</td>
			<td>${project.id}</td>
			<td>
				<form method="GET" action="${pageContext.servletContext.contextPath}/project/edit">
                    <input type="hidden" name="id" value=${project.id}>
                    <p><input type="submit" value="edit" /></p>
                </form>
            </td>
            <td>
				<form method="POST" action="${pageContext.servletContext.contextPath}/project/delete">
				    <input type="hidden" name="id" value=${project.id}>
                    <p><input type="submit" value="delete" /></p>
                </form>
			</td>
		</tr>
		</c:forEach>
		</table>
	<p>
        <a href="${pageContext.servletContext.contextPath}/project/add">
            <input type="button" value=" Add " />
        </a>
        <a href="${pageContext.servletContext.contextPath}/user">
            <input type="button" value="Back to main" /
        </a>
    </p>
</body>
</html>