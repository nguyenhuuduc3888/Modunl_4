<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator" method="post">
    <span>
        <input type="text" name="num1">
        <input type="text" name="num2">
    </span>
    <br>
    <span>
        <button type="submit" value="+" name="operator">+</button>
        <button type="submit" value="-" name="operator">-</button>
        <button type="submit" value="*" name="operator">*</button>
        <button type="submit" value="/" name="operator">/</button>
    </span>
</form>
<h3>
     result: ${result}
</h3>
</body>
</html>
