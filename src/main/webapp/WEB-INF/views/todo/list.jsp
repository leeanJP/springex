<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

  <title>Hello, world!</title>
</head>
<body>
  <div class="card-body">
    <h5 class="card-title">title</h5>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Tno</th>
          <th scope="col">Title</th>
          <th scope="col">Writer</th>
          <th scope="col">DueDate</th>
          <th scope="col">Finished</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${dtoList}" var="dto">
          <tr>
            <th scope="row"><c:out value="${dto.tno}"/> </th>
            <td><c:out value="${dto.title}"/> </td>
            <td><c:out value="${dto.writer}"/> </td>
            <td><c:out value="${dto.dueDate}"/> </td>
            <td><c:out value="${dto.finished}"/> </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>
