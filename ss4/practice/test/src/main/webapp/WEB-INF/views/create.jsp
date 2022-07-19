
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tờ khai y tế</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container-fluid">
    <div class="row text-center mt-5">
        <h2>TỜ KHAI Y TẾ</h2>
    </div>
</div>

<div class="container-fluid mt-5">
    <form:form modelAttribute="person" method="post" action="/save">
        <div class="row mt-2">
            <div class="col-lg-12">
                <label class="fw-bold">Họ tên (ghi chữ IN HOA) </label>
                <label class="text-danger">(*)</label>
                <form:input path="name" cssClass="form-control" required = "true" pattern="[A-Z\\s]+"/>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-lg-4">
                <label class="fw-bold">Năm sinh </label>
                <label class="text-danger">(*)</label>
                <form:select path="dayOfBirth" items="${dayOfBirth}" cssClass="form-select" required="true"/>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-lg-12">
                <label class="fw-bold">Thông tin đi lại </label>
                <label class="text-danger">(*)</label>
                <form:radiobuttons path="travelInformation" items="${travel}" cssClass="form-check-inline fw-bold mx-2"
                                   required="true"/>
            </div>
        </div>
        <div class="row mt-2">
            <div class="col-lg-6">
                <div class="row">
                    <div class="col-lg-12">
                        <label class="fw-bold">Ngày khởi hành </label>
                        <label class="text-danger">(*)</label>
                    </div>
                </div>

                <label>Ngày khởi hành</label>
                <div class="row">
                    <div class="col-lg-4">
                        <form:select path="startDay" items="${day}" cssClass="form-select" required="true"/>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="row">
                    <div class="col-lg-12">
                        <label class="fw-bold">Ngày kết thúc </label>
                        <label class="text-danger">(*)</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4">
                        <form:select path="endDay" items="${day}" cssClass="form-select" required="true"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-lg-12">
                <label class="fw-bold">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào? </label>
                <label class="text-danger">(*)</label>
                <form:input path="goDay" cssClass="form-control" required="true"/>
            </div>
        </div>
        <div class="row mt-2">
            <div class="col-lg-12 text-center">
                <form:button class="btn btn-success">
                    Tạo mới
                </form:button>
            </div>
        </div>
    </form:form>
</div>

</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</html>


<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Health Declaration</title>--%>
<%--    <style>--%>
<%--        .align-center {--%>
<%--            text-align: center;--%>
<%--        }--%>
<%--    </style>--%>


<%--</head>--%>
<%--<body>--%>
<%--<h3 class="align-center">TỜ KHAI Y TẾ</h3>--%>
<%--<h5 class="align-center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ--%>
<%--    LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h5>--%>
<%--<h6 class="align-center" style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể--%>
<%--    xử lý hình sự</h6>--%>

<%--&lt;%&ndash;@elvariable id="person" type=""&ndash;%&gt;--%>
<%--<table border="1px">--%>
<%--    <form:form action="/save" modelAttribute="person" method="post">--%>
<%--        <div><label>Họ tên </label>--%>
<%--            <form:input path="fullName"/>--%>
<%--        </div>--%>
<%--        <div><label>Năm sinh</label>--%>
<%--            <form:select path="yearOfBirth" items="${dayOfBirth}"/>--%>
<%--            <label>Giới tính</label>--%>
<%--            <form:select path="gender" items="${gender}"/>--%>
<%--            <label>Quốc tịch</label>--%>
<%--            <form:select path="nationality" items="${country}"/>--%>
<%--        </div>--%>

<%--        <div>--%>
<%--            <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label>--%>
<%--            <form:input path="idCard"/>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <label>Thông tin đi lại</label>--%>
<%--            <form:radiobuttons path="travelInfo" items="${travel}"/>--%>
<%--        </div>--%>
<%--        <div><label>Số hiệu phương tiện</label>--%>
<%--            <form:input path="signalPlate"/>--%>
<%--            <label>Số ghế</label>--%>
<%--            <form:input path="seatNumber"/>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <label>Ngày khởi hành</label>--%>
<%--            <form:select path="startDay" items="${day}"/>--%>
<%--            <form:select path="startMonth" items="${month}"/>--%>
<%--            <form:select path="startYear" items="${year}"/>--%>

<%--            <label>Ngày kết thúc</label>--%>
<%--            <form:select path="endDay" items="${day}"/>--%>
<%--            <form:select path="endMonth" items="${month}"/>--%>
<%--            <form:select path="endYear" items="${year}"/>--%>

<%--        </div>--%>
<%--        <label>Trong vòng 14 ngày qua, anh/chị có đến tỉnh/thành phố nào?</label>--%>
<%--        <form:textarea path="travel14DaysInfo"/>--%>
<%--        <button type="submit" value="save">Save</button>--%>
<%--    </form:form>--%>
<%--</table>--%>

<%--</body>--%>
<%--</html>--%>
