<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person Information</title>
</head>
<body>
<h4>Tờ khai y tế</h4>
<p>Họ tên: ${person.name}</p>
<p>Năm sinh: ${person.dayOfBirth}</p>
<p>Thông tin đi lại: ${person.travelInformation}</p>
<p> Ngày khởi hành: ${person.startDay}</p>
<p>Ngày kết thúc: ${person.endDay}</p>
<p>Trong vòng 14 ngày qua: ${person.goDay}</p>
<hr>
</body>
</html>