<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.khmelev.tm.dto.ProjectDTO" %>
<%@ page import="java.util.Date" %>
<html>
    <head>
	    <title>Task create</title>
    </head>
<body>
<div align = "center">
        <h1> Создание задачи </h1>
        <form action = "<%=request.getContextPath()%>/projectCreate" method = "post">

         <%List list = (List<ProjectDTO>) request.getAttribute("projects");%>
         <c:set var="list" value="<%=list%>"/>

         <select  name="pid">
            <c:forEach var = "project" items="${list}" varStatus="status">
                <option value = "${project.id}"  ${project.id.equals(projectId)}> ${project.name} </option>
            </c:forEach>
         </select>
         <p> Название: </p>
         <input type = "text" name = "nameProject" value = "" placeholder = "Название задачи"/>
         <p> Описание: </p>
         <input type = "text" name = "descProject" value = "" placeholder = "Описание задачи"/>
         <p> Дата начала: </p>
         <input type = "date" name = "dateStart" value = "<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd"/>"/>
         <p>Дата окончания: </p>
         <input type = "date" name = "dateFinish" value = "<fmt:formatDate value="<%=new Date()%>"  pattern="yyyy-MM-dd"/>"/>
         <p> <button type="submit"> Сохранить задачу </button> </p>
        </form>
    </div>
    </body>
</html>