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
    <form:form modelAttribute="person" method="post" action="/edit">
       <div >
           <form:hidden path="id"></form:hidden>
       </div>
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
                    Update
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