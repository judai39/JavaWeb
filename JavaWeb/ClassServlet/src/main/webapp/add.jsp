<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>题库系统</title>
  </head>
  <body>
  <form method="post" action="add.do">
      <table>
          <caption>新建题目</caption>
          <tr>
              <td>题目</td>
              <td><input type="text" name="topic"></td>
          </tr>
          <tr>
              <td>答案</td>
              <td>
                  <input type="radio" name="answer" value="true">对
                  <input type="radio" name="answer" value="false">错
              </td>
          </tr>
          <tr>
              <td>
                  <input type="submit">
              </td>
          </tr>
      </table>
  </form>
  </body>
</html>
