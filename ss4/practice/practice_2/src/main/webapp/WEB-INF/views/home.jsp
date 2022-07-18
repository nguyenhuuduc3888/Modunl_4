<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Home</h3>
<form:form action="login" method="post" modelAttribute="login">
    <fieldset>
        <legend>Login</legend>
        <table>
            <tr>
                <td><form:label path="account"> Account: </form:label></td>
                <td><from:input path="account"/></td>

            </tr>
            <tr>
                <td><form:label path="password"> PassWord: </form:label></td>
                <td><from:input path="password"/></td>

            </tr>
            <tr>
                <td></td>
                <td><from:button>Login </from:button></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
