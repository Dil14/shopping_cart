<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container-wrapper">

    <div class="container">




    <div class="page-header">
        <h2>Customer Registration Page</h2>
        <p>Please fill out the Necessary Details</p>
    </div>
    <form:form action="${pageContext.request.contextPath}/register" method="post" commandName="customer" id="details">

        <div class="form-group">
            <label for="name">Customer Name</label>
            <form:input path="customerName" id="name" cssClass="form-control"/>
            <form:errors path="customerName" cssStyle="color:red;font-family: 'Lucida Console'"/>

        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <form:input path="customerEmail" id="email" cssClass="form-control"/>
            <span class="error">${Email_error}</span>
            <form:errors path="customerEmail" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="phone">Phone Number</label>
            <form:input path="customerPhone" id="phone" cssClass="form-control"/>
            <form:errors path="customerPhone" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="username">Username</label>
            <form:input path="username" id="username" cssClass="form-control"/>
            <span class="error">${Username_error}</span>
            <form:errors path="username" cssClass="error"/>

        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <form:password path="password" id="password" cssClass="form-control"/>
            <form:errors path="password" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="confirmpass">Confirm Password</label>
            <input type="password"  id="confirmpass" class="form-control"/>
            <div id="matchpass"></div>
        </div>
        <h3>Billing Address</h3>
        <div class="form-group">
            <label for="streetname">Street Name</label>
            <form:input path="billingAddress.streetName" id="streetname" cssClass="form-control"/>
            <form:errors path="billingAddress.streetName" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="aptnumber">Apartment Number</label>
            <form:input path="billingAddress.apartmentNumber" id="aptnumber" cssClass="form-control"/>
            <form:errors path="billingAddress.apartmentNumber" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="city">City</label>
            <form:input path="billingAddress.city" id="city" cssClass="form-control"/>
            <form:errors path="billingAddress.city" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="State">State</label>
            <form:input path="billingAddress.state" id="State" cssClass="form-control"/>
            <form:errors path="billingAddress.state" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="country">Country</label>
            <form:input path="billingAddress.country" id="country" cssClass="form-control"/>
            <form:errors path="billingAddress.country" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="zipcode">Zip Code</label>
            <form:input path="billingAddress.zipcode" id="zipcode" cssClass="form-control"/>
            <form:errors path="billingAddress.zipcode" cssClass="error"/>
        </div>

        <h3>Shipping Address</h3>
        <div class="form-group">
            <label for="streetnam">Street Name</label>
            <form:input path="shippingAddress.streetName" id="streetnam" cssClass="form-control"/>
            <form:errors path="shippingAddress.streetName" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="aptno">Apartment Number</label>
            <form:input path="shippingAddress.apartmentNumber" id="aptno" cssClass="form-control"/>
            <form:errors path="shippingAddress.apartmentNumber" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="scity">City</label>
            <form:input path="shippingAddress.city" id="scity" cssClass="form-control"/>
            <form:errors path="shippingAddress.city" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="sState">State</label>
            <form:input path="shippingAddress.state" id="sState" cssClass="form-control"/>
            <form:errors path="shippingAddress.state" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="scountry">Country</label>
            <form:input path="shippingAddress.country" id="scountry" cssClass="form-control"/>
            <form:errors path="shippingAddress.country" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="szipcode">Zip Code</label>
            <form:input path="shippingAddress.zipcode" id="szipcode" cssClass="form-control"/>
            <form:errors path="shippingAddress.zipcode" cssClass="error"/>
        </div>


        <div class="form-group">

            <input type="submit" value="Create Account" class="btn btn-default"/>
            <a href="<c:url value="/"/>" class="btn btn-default">Cancel </a>
        </div>



    </form:form>
    </div>
</div>

<br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/>
<br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/>
<br/> <br/> <br/> <br/> <br/> <br/>


<%@include file="/WEB-INF/views/template/footer.jsp"%>
