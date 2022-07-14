<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>The condiments accompanying the sandwich</h1>
<p>
    <c:forEach items="${condiment}" var="condiment"> ${condiment} </c:forEach>
</p>
</body>
</html>
