<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>

<form:form action="update" method="post" modelAttribute="mailbox">
    <table border="1px">
        <tr>
            <td><strong>Languages: </strong></td>
            <td>
                <form:select path="languages" items="${listLanguages}"></form:select>
            </td>
        </tr>
        <tr>
            <td><strong>Page Size: </strong></td>
            <td>Show
                <form:select path="pageSize" items="${listPageSize}"></form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <td><strong>Spams Filter: </strong></td>
            <td>
                <form:checkbox path="spamsFilter" value="enable"/> Enable spams filter
            </td>
        </tr>
        <tr>
            <td><strong>Signature: </strong></td>
            <td>
                <form:textarea path="signature"></form:textarea>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Update</button>
                <button type="reset">Cancel</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
