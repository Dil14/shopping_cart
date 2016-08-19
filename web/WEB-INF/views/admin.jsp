<%--
  Created by IntelliJ IDEA.
  User: Dilipan
  Date: 6/23/2016
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper">
    <div class="container">
    
        <div class="page-header">
            <h3>Administrator Page </h3>
            <p>Perform Administrator Level Actions!!</p>
        </div>
        <c:if test="${not empty pageContext.request.userPrincipal.name}">
        <h2>Welcome ${pageContext.request.userPrincipal.name}



        </h2>

        </c:if>
        <hr/>
        <h4>
        <a href="<c:url value="/admin/productInventory"/>" >Product Inventory</a>
            <br/>
        </h4>
        <p>View Product Inventory</p>

        <br/>
        <br/>
<hr/>
        <h4>
            <a href="<c:url value="/admin/customerManagement"/>" >Customer Management</a>
            <br/>
        </h4>
        <p>View the Customer Details</p>

    </div>
    
</div>


<%@include file="/WEB-INF/views/template/footer.jsp"%>