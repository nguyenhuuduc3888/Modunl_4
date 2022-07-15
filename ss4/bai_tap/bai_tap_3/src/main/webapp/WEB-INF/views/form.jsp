<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Health Declaration</title>
    <style>
        .align-center {
            text-align: center;
        }
    </style>


</head>
<body>
<h3 class="align-center">TỜ KHAI Y TẾ</h3>
<h5 class="align-center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ
    LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h5>
<h6 class="align-center">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</h6>

<%--@elvariable id="person" type=""--%>
<form:form action="/save" modelAttribute="person" method="post">
    <div><label>Họ tên (ghi chữ IN HOA)</label>
        <form:input path="fullName"/>
    </div>
    <div><label>Năm sinh</label>
        <form:select path="yearOfBirth" items="${dayOfBirth}"/>
        <label>Giới tính</label>
        <form:select path="gender" items="${gender}"/>
        <label>Quốc tịch</label>
        <form:select path="nationality" items="${country}"/>
    </div>

    <div>
        <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label>
        <form:input path="idCard"/>
    </div>
    <div>
        <label>Thông tin đi lại</label>
        <form:radiobuttons path="travelInfo" items="${travel}"/>
    </div>
    <div><label>Số hiệu phương tiện</label>
        <form:input path="signalPlate"/>
        <label>Số ghế</label>
        <form:input path="seatNumber"/>
    </div>
    <div>
        <label>Ngày khởi hành</label>
        <form:select path="startDay" items="${day}"/>
        <form:select path="startMonth" items="${month}"/>
        <form:select path="startYear" items="${year}"/>

        <label>Ngày kết thúc</label>
        <form:select path="endDay" items="${day}"/>
        <form:select path="endMonth" items="${month}"/>
        <form:select path="endYear" items="${year}"/>

    </div>
    <label>Trong vòng 14 ngày qua, anh/chị có đến tỉnh/thành phố nào?</label>
    <form:textarea path="travel14DaysInfo"/>
    <button type="submit" value="save">Save</button>
</form:form>
</body>
</html>
