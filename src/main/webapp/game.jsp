<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/my.css" type="text/css"/>
<title>Квест игра</title>
</head>
<body class="center">
<h1>${header1}</h1>
<table border="1">
    <tbody>
    <tr>
        <td colspan="2"><img ${img}></td>
    </tr>
    <tr>
        <td colspan="2"><c:out value="${question}"/></td>
    </tr>
    <tr>
        <form method="post">
            <td><button value=<c:out value="${answer1}"/>  name="answer"><c:out value="${btn1}"/></button></td>
            <td><button value=<c:out value="${answer2}"/>  name="answer"><c:out value="${btn2}"/></button></td>
        </form>
    </tr>
    </tbody>
</table>
<br>
<br>
<br>
<br>
<p>Статистика</p>
<p>Имя: ${name}</p>
<p>Ip: ${ip}</p>
<p>Количество сыгранных игр: ${gameCount}</p>
</body>
</html>