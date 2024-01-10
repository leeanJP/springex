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
        <div class="input-group mb-3">
            <span class="input-group-text">TNO</span>
            <input type="text" name="tno" class="form-control"
                    value="<c:out value="${dto.tno}"></c:out>" readonly>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Title</span>
            <input type="text" name="title" class="form-control"
                    value="<c:out value="${dto.title}"></c:out>" readonly>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">DueDate</span>
            <input type="date" name="dueDate" class="form-control"
                    value="<c:out value="${dto.dueDate}"></c:out>" readonly>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Writer</span>
            <input type="text" name="writer" class="form-control"
                    value="<c:out value="${dto.writer}"></c:out>" readonly>
        </div>
        <div class="form-check">
            <label class="form-check-label">
                finished &nbsp;
                <input type="checkbox" name="finished" class="form-check-control"
                        ${dto.finished?"checked":""} disabled>
            </label>
        </div>

        <div class="my-4">
            <div class="float-end">
                <button type="button" id="modify" class="btn btn-primary">Modify</button>
                <button type="button" id="list" class="btn btn-primary">List</button>
            </div>
        </div>
    </div>

    <script>
        document.querySelector('#modify').addEventListener('click', function (){
            self.location = '/todo/modify?tno=${dto.tno}'
        },false);

        document.querySelector('#list').addEventListener('click', function (){
            self.location = '/todo/list';
        },false);
    </script>




</body>
</html>
