<%@ page import="tdtu.edu.vn.lab05.Model.user" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>Danh sách sản phẩm</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #f8f8f8">

<div class="container-fluid p-5">
  <div class="row mb-5">
    <div class="col-md-6">
      <h3>Product Management</h3>
    </div>
    <div class="col-md-6 text-right">
      <%

        user user = (user) request.getAttribute("User");

        if (user != null) {
      %>
      Xin chào <span class="text-danger"><%= user.getUserName() %></span> | <a href="login.jsp">Logout</a>
    </div>
  </div>
  <div class="row rounded border p-3">
    <div class="col-md-4">
      <h4 class="text-success">Thêm sản phẩm mới</h4>
      <form action="add" class="mt-3" method="post" >
        <div class="form-group">
          <label for="product-name">Tên sản phẩm</label>
          <input class="form-control" type="text" placeholder="Nhập tên sản phẩm" id="product-name" name="name">
        </div>
        <div class="form-group">
          <label for="price">Giá sản phẩm</label>
          <input class="form-control" type="number" placeholder="Nhập giá bán" id="price" name="price">
        </div>
        <div class="form-group">
          <button class="btn btn-success mr-2">Thêm sản phẩm</button>
        </div>

        <div class="alert alert-danger">
          Vui lòng nhập tên sản phẩm
        </div>
      </form>
    </div>
    <div class="col-md-8">
      <h4 class="text-success">Danh sách sản phẩm</h4>
      <p>Chọn một sản phẩm cụ thể để xem chi tiết</p>
      <table class="table table-striped">
        <thead>
        <tr>
          <th>STT</th>
          <th>Tên sản phẩm</th>
          <th>Giá</th>
          <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${listProduct}" >

        <tr>
          <td><c:out value="${product.id}" /></td>
          <td><c:out value="${product.name}"  /></td>
          <td><c:out value="${product.price}" /></td>
          <td><a href="edit?id=<c:out value='${product.id}' />">Edit</a>
            &nbsp;&nbsp;&nbsp;&nbsp; <a
                    href="delete?id=<c:out value='${product.id}' />">Delete</a></td>
        </tr>
        </c:forEach>
<%--        <tr>--%>
<%--          <td></td>--%>
<%--          <td><a href="#"><%=request.getAttribute("name") %></a></td>--%>
<%--          <td><%=request.getAttribute("email") %></td>--%>
<%--          <td>--%>
<%--            <a href="#">Chỉnh sửa</a> |--%>
<%--            <a href="#">Xóa</a>--%>
<%--          </td>--%>
<%--        </tr>--%>
        <%--                <tr>--%>
        <%--                    <td>2</td>--%>
        <%--                    <td><a href="#">Macbook Pro 2020</a></td>--%>
        <%--                    <td>$2,400</td>--%>
        <%--                    <td>--%>
        <%--                        <a href="#">Chỉnh sửa</a> |--%>
        <%--                        <a href="#">Xóa</a>--%>
        <%--                    </td>--%>
        <%--                </tr>--%>
        </tbody>
      </table>
      <%
      } else {
      %>
        <p>No user data available.</p>
      <%
        }
      %>
    </div>
  </div>
</div>
<script>
  // Add the following code if you want the name of the file appear on select
  $(".custom-file-input").on("change", function() {
    var fileName = $(this).val().split("\\").pop();
    $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
  });
</script>
</body>
</html>
