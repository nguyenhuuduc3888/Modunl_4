<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save" method="post">
    <input type="checkbox" name="condiment" value="Lettuce"><span> Lettuce </span>
    <input type="checkbox" name="condiment" value="Tomato"><span> Tomato </span>
    <input type="checkbox" name="condiment" value="Mustard"><span> Mustard </span>
    <input type="checkbox" name="condiment" value="Sprouts"><span> Sprouts </span>
    <hr>
    <button type="submit" value="save" > Save </button>
</form>
</body>
</html>
