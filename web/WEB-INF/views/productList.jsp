<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper">


    <div class="container">

        <div class="page-header">
        <h1>All Products</h1>
        <p class="lead" >Product List</p>
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
            <c:forEach var="product" items="${product}">
            <tr>
                <td><img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" style="width:100px"/></td>
                <td>${product.productName}</td>
                <td>${product.productCondition}</td>
                <td>${product.productManufacturer}</td>
                <td>${product.productPrice} USD</td>
                <td><a href="<spring:url value="/product/viewProducts/${product.productId}"/>"><span class="glyphicon glyphicon-info-sign"/></a></td>
            </tr>
            </c:forEach>
        </table>
        </div>
    </div>

        <%@include file="/WEB-INF/views/template/footer.jsp"%>



