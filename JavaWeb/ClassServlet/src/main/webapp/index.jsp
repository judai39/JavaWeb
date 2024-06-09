<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>题库管理</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>题号</th>
            <th>题目内容</th>
            <th>答案</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${questions}" var="question">
            <tr>
                <td>${question.id}</td>
                <td>${question.topic}</td>
                <td>${question.answer}</td>
                <td>
                    <a href="del.do?id=${question.id}">删除</a>
                    <a href="edit.do?id=${question.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="add.do">新增</a>
</body>
</html>
