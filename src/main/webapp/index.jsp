<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
	    <title>ПРИВЕТСТВУЮ</title>
    </head>
    <body>
    <p>
        <b>Привет ДРУГ :</b>
    </p>

    <a align = "right" href="${pageContext.servletContext.contextPath}/login">
        <input type = "button"  value = "Login" align = "centre"/>
    </a>
    </body>
</html>