<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator" method="post">
    <input required pattern="[0-9]+([\.][0-9]{0,2})?" type="text" name="num1" value="${num1}">
    <input required pattern="[0-9]+([\.][0-9]{0,2})?" type="text" name="num2" value="${num2}">
    <br>
    <button name="operator" value="+">+</button>
    <button name="operator" value="-">-</button>
    <button name="operator" value="*">*</button>
    <button name="operator" value="/">/</button>
</form>
<h1>
    Result:${result}
</h1>
</body>
</html>
