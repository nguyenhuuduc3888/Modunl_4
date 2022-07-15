<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Them moi employee</h1>
<%--@elvariable id="employee" type=""--%>
<form:form method="POST" action="/add" modelAttribute="employee">
    <table>
        <tr>
            <td><form:label path="id">Employee ID </form:label></td>
            <td><form:input path="id"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="name">Employee Name </form:label></td>
            <td><form:input path="name"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="contactNumber">Employee Contact Number </form:label></td>
            <td><form:input path="contactNumber"></form:input></td>
        </tr>   <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
