<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title> DUC</title>
</head>
<body>
<form action="dictionary" method="post">
    <div>
        English:
        <input type="text" name="english" placeholder="Nhập từ cần dịch" value="${english}">
    </div>
    <div style="margin-top: 20px">
        <button style="border-radius: 5px; border: 1px  black ;color: darkorange;background-color: aqua " type="submit">
            Translate
        </button>
    </div>
</form>
<div>
    Vietnamese: <strong style="color: burlywood">${vietnamese}</strong>
</div>
</body>
</html>