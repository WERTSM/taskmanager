<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.khmelev.tm.dto.ProjectDTO" %>
<html>
    <head>
	    <title>Project status page</title>
    </head>
<body>
	<p>
    <b align = "center"> Projects :</b>
	</p>

	<table border="5" align = "center">
		<tr>
		    <th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Start date</th>
			<th>Finish date</th>
    		<th>Create date</th>
    		<th>Status</th>
		</tr>
		<% List list = (List<ProjectDTO>)request.getAttribute("projects"); %>
		<c:set var="list" value=<%=list%>/>
		<c:forEach items="${list}"  var="project" varStatus="status">
			<tr>
				<td>${project.id}</td>
				<td>${project.name}</td>
				<td>${project.description}</td>
				<td>${project.createDate}</td>
				<td>${project.startDate}</td>
				<td>${project.endDate}</td>
				<td>${project.status.displayName}</td>
			</tr>
		</c:forEach>
	</table>
	</body>
</html>