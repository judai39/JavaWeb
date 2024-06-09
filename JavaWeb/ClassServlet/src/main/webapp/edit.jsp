<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>题库管理</title>
</head>
<body>
<%--设置post传输方式的唯一手段--%>
<form method="post" action="edit.do">
    <table>
        <caption>修改题目</caption>
        <tr>
            <td>编号</td>
            <td><input type="text" name="id" readonly value="${question.id}"></td>
        </tr>
        <tr>
            <td>题目</td>
            <td><input type="text" name="topic" value="${question.topic}"></td>
        </tr>
        <tr>
            <td>答案</td>
            <td>
                <c:if test="${question.answer}">
                    <input type="radio" name="answer" value="true" checked>对
                    <input type="radio" name="answer" value="false" checked>错
                </c:if>
                <c:if test="${!question.answer}">
                    <input type="radio" name="answer" value="true" checked>对
                    <input type="radio" name="answer" value="false" checked>错
                </c:if>
            </td>
        </tr>
        <tr>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
