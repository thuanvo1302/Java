<%@ page import="tdtu.edu.vn.lab05.Model.product" %><%--
  Created by IntelliJ IDEA.
  User: VIVOBOOK
  Date: 10/21/2023
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit</title>
    <meta charset="UTF-8">
    <title>Register</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css    ">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<%

    product p = (product) request.getAttribute("Product");


%>
<h4 class="text-success">Sửa sản phẩm mới</h4>
<form action="edit" method="post" >
    <div class="form-group">
        <label for="product-name">Tên sản phẩm</label>
        <input class="form-control" type="text" placeholder="Nhập tên sản phẩm" id="product-name" name="name" value="<%= p.getName() %>">
    </div>
    <div class="form-group">
        <label for="price">Giá sản phẩm</label>
        <input class="form-control" type="text" placeholder="Nhập giá bán" id="price" name="price" value="<%= p.getPrice() %>">
    </div>
    <div class="form-group">
        <button class="btn btn-success mr-2">Sửa sản phẩm</button>
    </div>
</form>
</body>

</html>
