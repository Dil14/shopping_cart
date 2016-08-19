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

            <div class="form-group">
                <label for="name">Customer Name</label>
                <form:input path="cart.customer.customerName" id="name" cssClass="form-control"/>

            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <form:input path="cart.customer.customerEmail" id="email" cssClass="form-control"/>
            </div>

            <div class="form-group">
                <label for="phone">Phone Number</label>
                <form:input path="cart.customer.customerPhone" id="phone" cssClass="form-control"/>
            </div>

            <h3>Billing Address</h3>
            <div class="form-group">
                <label for="streetname">Street Name</label>
                <form:input path="cart.customer.billingAddress.streetName" id="streetname" cssClass="form-control"/>
            </div>

            <div class="form-group">
                <label for="aptnumber">Apartment Number</label>
                <form:input path="cart.customer.billingAddress.apartmentNumber" id="aptnumber" cssClass="form-control"/>
            </div>

            <div class="form-group">
                <label for="city">City</label>
                <form:input path="cart.customer.billingAddress.city" id="city" cssClass="form-control"/>
            </div>

            <div class="form-group">
                <label for="State">State</label>
                <form:input path="cart.customer.billingAddress.state" id="State" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label for="country">Country</label>
                <form:input path="cart.customer.billingAddress.country" id="country" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label for="zipcode">Zip Code</label>
                <form:input path="cart.customer.billingAddress.zipcode" id="zipcode" cssClass="form-control"/>
            </div>

            <div class="form-group">
                <input type="hidden" name="_flowExecutionKey"/>
                <input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected"/>
               <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
            </div>



        </form:form>
    </div>
</div>

<br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/>
<br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/>
<br/> <br/> <br/> <br/> <br/> <br/>


<%@include file="/WEB-INF/views/template/footer.jsp"%>
