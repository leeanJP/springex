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
    <button type="button" id="register" class="btn btn-primary">등록</button>
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
        <c:forEach items="${responseDTO.dtoList}" var="dto">
          <tr>
            <th scope="row"><c:out value="${dto.tno}"/> </th>
            <td>
              <a href="/todo/read?tno=${dto.tno}&${pageRequestDTO.link}" class="text-decoration-none">
              <c:out value="${dto.title}"/>
              </a>
            </td>
            <td><c:out value="${dto.writer}"/> </td>
            <td><c:out value="${dto.dueDate}"/> </td>
            <td><c:out value="${dto.finished}"/> </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <div class="d-flex justify-content-center">
      <ul class="pagination flex-wrap">
        <c:if test="${responseDTO.prev}">
          <li class="page-item">
            <a class="page-link" data-num="${responseDTO.start -1}">이전</a>
          </li>
        </c:if>

        <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
          <li class="page-item ${responseDTO.page == num ? "active" : ""}">
            <a class="page-link" data-num="${num}">${num}</a>
          </li>
        </c:forEach>

        <c:if test="${responseDTO.next}">
          <li class="page-item">
            <a class="page-link" data-num="${responseDTO.end +1}">다음</a>
          </li>
        </c:if>
      </ul>
    </div>

  </div>

  <script>
    document.querySelector('#register').addEventListener('click',function (){
      location.href = "/todo/register";
    })

    document.querySelector('.pagination').addEventListener('click', function (e){
      e.preventDefault();
      e.stopPropagation();

      const target = e.target;
      if(target.tagName !== 'A'){
        return
      }
      const num = target.getAttribute('data-num');
      location.href = `/todo/list?page=\${num}`;
    },false)
  </script>
</body>
</html>
