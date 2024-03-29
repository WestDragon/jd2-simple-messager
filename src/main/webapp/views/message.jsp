<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
                    <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Главная страница входа</title>
    </head>
    <body>
<c:choose>
    <c:when test="${requestScope.success}">
            <p style="color:green;">Сообщение успешно отправленно. Отправляй ещё раз</p>
    </c:when>
    <c:when test="${requestScope.error}">
            <p style="color:red;">${requestScope.message}</p>
    </c:when>
    <c:otherwise>
        <p>${sessionScope.user.fio}, быстрее отправь сообщение!</p>
    </c:otherwise>
</c:choose>
        <form action="${pageContext.request.contextPath}/api/message" method="POST">
            <table>
                <tbody>
                    <tr>
                        <td>Recipient:</td>
                        <td>
                            <input type="text" name="recipient" value="${param.recipient}">
                        </td>
                    </tr>
                    <tr>
                        <td>Text:</td>
                        <td>
                            <input type="text" name="text" value="${param.text}">
                        </td>
                    </tr>
                </tbody>
            </table>
            <p><input type="submit" value="Send" /><input type="button" onclick="location.href='${pageContext.request.contextPath}/';" value="index" /></p>
        </form>
    </body>
</html>