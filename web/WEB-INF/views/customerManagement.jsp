<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper">


    <div class="container">

        <div class="page-header">
            <h1>Customer List</h1>
            <p class="lead" >View the Entire Customer List</p>
        </div>

        <table class="table table-strip table-hover">
            <thead>
            <tr class="bg-success">
                <th>Customer ID</th>
                <th>Customer Name</th>
                <th> Phone Number </th>
                <th>Email</th>
                <th> Enabled </th>
                <th></th>

            </tr>
            </thead>
            <c:forEach var="customer" items="${customerList}">
                <tr>
                    <td>${customer.customerId}</td>
                    <td>${customer.customerName}</td>
                    <td>${customer.customerPhone}</td>
                    <td>${customer.customerEmail}</td>
                    <td>${customer.enabled}</td>

                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>



