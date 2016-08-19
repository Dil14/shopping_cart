<%--
  Created by IntelliJ IDEA.
  User: Dilipan
  Date: 6/23/2016
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper">
    <div class="container">

        <div class="page-header">

            <h3>Product Inventory</h3>
            <p>Add New Products to the Inventory</p>
        </div>

        <table class="table table-strip table-hover">

            <thead>
            <tr class="bg-success">
                <th>Photo thumb</th>
                <th> ProductName </th>
                <th> ProductCondition </th>
                <th>Manufacturer</th>
                <th> ProductPrice </th>
                <th></th>
            </tr>
            </thead>
            <c:forEach var="product" items="${products}">
            <tr>
               <td><img  src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" style="width: 100%" class="img-rounded"/></td>
                <td>${product.productName}</td>
                <td>${product.productCondition}</td>
                <td>${product.productManufacturer}</td>
                <td>${product.productPrice}</td>
                <td><a href="<c:url value="/admin/productInventory/viewProducts/${product.productId}"/>"><span class="glyphicon glyphicon-info-sign"/></a>
                    <a href="<c:url value="/admin/productInventory/deleteProduct/${product.productId}"/>"><span class="glyphicon glyphicon-remove"/></a>
                    <a href="<c:url value="/admin/productInventory/editProduct/${product.productId}"/>"><span class="glyphicon glyphicon-pencil"/></a>
                </td>
            </tr>
            </c:forEach>
            </table>
        <p>
       <a href="<c:url value="/admin/productInventory/addProduct"/>"><span class="btn btn-primary">Add Product</span></a>
        </p>



<%@include file="/WEB-INF/views/template/footer.jsp"%>