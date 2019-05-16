<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>User status page</title>
</head>
<body>
    <p>
        Your login : ${login}
    </p>
    <a href="${pageContext.servletContext.contextPath}/project">
                <input type="button" value="Projects" />
       </a>
    </p>
    </body>
</html>