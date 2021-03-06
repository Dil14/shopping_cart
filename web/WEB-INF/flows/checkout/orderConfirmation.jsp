<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>

<div class="container-wrapper">

    <div class="container">




        <div class="page-header">
            <h2>Order</h2>
            <p class="lead">Order Confirmation</p>
        </div>

        <div class="container">
            <div class="row">
        <form:form commandName="order"  cssClass="form-horizontal">


            <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-10 col-sm-offset-1 col-md-offset-3">
                <div class="text-center">
                    <h1>Receipt</h1>
                </div>
            <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <address>
                        <strong>Shipping Address</strong>
                        ${order.cart.customer.shippingAddress.streetName}
                        <br/>
                            ${order.cart.customer.shippingAddress.apartmentNumber}
                        <br/>
                            ${order.cart.customer.shippingAddress.city},${order.cart.customer.shippingAddress.state}
                        <br/>
                            ${order.cart.customer.shippingAddress.country},${order.cart.customer.shippingAddress.zipcode}
                    </address>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                 <p>Shipping Date: <fmt:formatDate value="${now}" type="date"/> </p>

                </div>

            </div>
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <address>
                            <strong>Billing Address</strong>
                                ${order.cart.customer.billingAddress.streetName}
                            <br/>
                                ${order.cart.customer.billingAddress.apartmentNumber}
                            <br/>
                                ${order.cart.customer.billingAddress.city},${order.cart.customer.billingAddress.state}
                            <br/>
                                ${order.cart.customer.billingAddress.country},${order.cart.customer.billingAddress.zipcode}
                        </address>
                    </div>
                    </div>
                <div class="row">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                        <th>Product</th>
                        <th>#</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="cartItem" items="${order.cart.cartItems}">
                            <tr>
                                <td class="col-md-9"><em>${cartItem.product.productName}</em></td>
                                <td class="col-md-1" style="text-align:center">${cartItem.quantity}</td>
                                <td class="col-md-1" style="text-align:center">${cartItem.product.productPrice}</td>
                                <td class="col-md-1" style="text-align:center">${cartItem.totalprice}</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td></td>
                            <td></td>
                            <td class="text-right">
                                <h4><strong>Grand Total</strong></h4>
                            </td>
                            <td class="text-center text-danger">
                                <h4><strong>${order.cart.grandtotal}</strong></h4>
                            </td>

                        </tr>
                        </tbody>
                    </table>
                </div>




                    <div class="form-group">
                <input type="hidden" name="_flowExecutionkey"/>
                <button class="btn btn-default" name="_eventId_backToCollectShippingDetail">Previous</button>
                <input type="submit" value="Submit Order" class="btn btn-default" name="_eventId_orderConfirmed"/>
                <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
            </div>


            </div>
        </form:form>
            </div>
        </div>
    </div>
</div>