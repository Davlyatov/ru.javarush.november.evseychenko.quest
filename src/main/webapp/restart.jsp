<%--
  Created by IntelliJ IDEA.
  User: Davlyatov
  Date: 30.03.2023
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/my.css" type="text/css"/>
    <title>Квест игра</title>
</head>
<body class="center">
<h1>${header1}</h1>
${img}
<p>${p1}</p>
<p>${p2}</p>
<form method="post">
    <button name="answer" value="restart">Начать заново</button>
</form>
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
