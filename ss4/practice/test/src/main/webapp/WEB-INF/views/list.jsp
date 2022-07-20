<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><a href="/form"> Create</a></h1>
    <table border="1px">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>DAY OF BIRTH</th>
            <th>TRAVEL</th>
            <th>END DAY</th>
            <th>START DAY</th>
            <th> GO DAY</th>
            <th>Edit</th>
        </tr>
        <c:forEach items="${person}" var="person">
        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.dayOfBirth}</td>
            <td>${person.travelInformation}</td>
            <td>${person.startDay}</td>
            <td>${person.endDay}</td>
            <td>${person.goDay}</td>
            <td><a href="/update?id=${person.id}"> edit</a></td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
