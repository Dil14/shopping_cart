<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container-wrapper">

    <div class="container">




        <div class="page-header">
            <h2>Customer Checkout Information</h2>
            <p>Please fill out the Necessary Details</p>
        </div>
        <form:form commandName="order" >


            <h3>Shipping Address</h3>
            <div class="form-group">
                <label for="streetname">Street Name</label>
                <form:input path="cart.customer.shippingAddress.streetName" id="streetname" cssClass="form-control"/>
            </div>

            <div class="form-group">
                <label for="aptnumber">Apartment Number</label>
                <form:input path="cart.customer.shippingAddress.apartmentNumber" id="aptnumber" cssClass="form-control"/>
            </div>

            <div class="form-group">
                <label for="city">City</label>
                <form:input path="cart.customer.shippingAddress.city" id="city" cssClass="form-control"/>
            </div>

            <div class="form-group">
                <label for="State">State</label>
                <form:input path="cart.customer.shippingAddress.state" id="State" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label for="country">Country</label>
                <form:input path="cart.customer.shippingAddress.country" id="country" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label for="zipcode">Zip Code</label>
                <form:input path="cart.customer.shippingAddress.zipcode" id="zipcode" cssClass="form-control"/>
            </div>

            <div class="form-group">
                <input type="hidden" name="_flowExecutionkey"/>
                <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Previous</button>
                <input type="submit" value="Next" class="btn btn-default" name="_eventId_shippingDetailCollected"/>
                <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
            </div>



        </form:form>
    </div>
</div>