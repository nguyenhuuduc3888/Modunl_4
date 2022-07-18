<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person Information</title>
</head>
<body>
<h4>Tờ khai y tế</h4>
<p>Họ tên: ${person.fullName}</p>
<p>Năm sinh: ${person.yearOfBirth}</p>
<p>Giới tính: ${person.gender}</p>
<p>Quốc tịch: ${person.nationality}</p>
<p>Số hộ chiếu/CMND: ${person.idCard}</p>
<p>Thông tin đi lại: ${person.travelInfo}</p>
<p>Số hiệu phương tiện: ${person.signalPlate}</p>
<p>Số ghế: ${person.seatNumber}</p>
<span>
    Ngày khởi hành: ${person.startDay}
/ ${person.startMonth}
/${person.startYear}
</span>
<span>
    Ngày kết thúc: ${person.endDay}
/ ${person.endMonth}
/ ${person.endYear}
</span>

<p>Trong vòng 14 ngày qua: ${person.travel14DaysInfo}</p>
</body>
</html>