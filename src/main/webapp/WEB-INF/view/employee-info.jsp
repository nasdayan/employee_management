<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee info</title>
</head>
<body>
    <h2>Employee info</h2>
    <br>
    <form:form action="save-employee" modelAttribute="employee">
        <form:hidden path="id"/>
        Name <form:input path="name"/>
        <br>
        Surname <form:input path="surname"/>
        <br>
        Department <form:input path="department"/>
        <br>
        Salary <form:input path="salary"/>
        <br>
        <input type="submit" value="OK">
        <br>
    </form:form>
</body>
</html>
