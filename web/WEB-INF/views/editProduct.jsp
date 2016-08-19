<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper">
    <div class="container">

        <div class="page-header">
            <h3>Edit Product</h3>
            <p>Please Update the Correct Information</p>
        </div>
<form:form action="${pageContext.request.contextPath}/admin/productInventory/editProduct/${productId}" method="post" commandName="product"
enctype="multipart/form-data">
    <div class="form-group">
        <label for="name">Name</label>
        <form:input path="productName" id="name" value="${product.productName}" class="form-control"/>
        <form:errors path="productName" id="name"  cssStyle="color:red;font-family: 'Lucida Console'"   data-dismiss="alert"  />
    </div>
<div class="form-group">
    <label for="category">Category</label>
    <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"  value="Instrument"/>Instrument</label>
    <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="Recorder"/>Recorder</label>
    <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="Accessory"/>Accessory</label>
    <form:errors path="productCategory" id="category"  cssStyle="color:red;font-family: 'Lucida Console'"  />
</div>
    <div class="form-group">
        <label for="description">Description</label>
        <form:input path="productDescription" id="description" value="${product.productDescription}" class="form-control"/>
        <form:errors path="productDescription" id="description"  cssStyle="color:red;font-family: 'Lucida Console'"   />
    </div>
<div class="form-group">
    <label for="price">Price</label>
        <form:input path="productPrice" id="price" value="${product.productPrice}" class="form-control"/>
    <form:errors path="productPrice" id="price" cssStyle="color:red;font-family: 'Lucida Console'"  />
</div>
    <div class="form-group">
        <label for="condition">Condition</label>
        <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="New"/>New</label>
        <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="Used"/>Used</label>
        <br/>
        <form:errors path="productCondition" id="condition" cssStyle="color:red;font-family: 'Lucida Console'"  />

    </div>
    <div class="form-group">
        <label for="status">Status</label>
        <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="In Stock"/>In Stock</label>
        <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="Not Available"/>Not Available</label>
        <br/>
        <form:errors path="productStatus" id="status" cssStyle="color:red;font-family: 'Lucida Console'"  />
    </div>
    <div class="form-group">
        <label for="units">Units in Stock</label>
        <form:input path="unitInStock" id="units" value="${product.unitInStock}" class="form-control"/>
        <form:errors path="unitInStock" id="units" cssStyle="color:red;font-family: 'Lucida Console'"  />
    </div>
    <div class="form-group">
        <label for="manufacturer">Manufacturer</label>
        <form:input path="productManufacturer" id="manufacturer" value="${product.productManufacturer}" class="form-control" />
        <form:errors path="productManufacturer" id="manufacturer" cssStyle="color:red;font-family: 'Lucida Console'"  />
    </div>
    <div class="form-group">
        <label for="upload">Upload Image</label>
        <form:input path="productImage" id="upload" type="file" class="form-input-large" onchange="PreviewImage();"/>

        <div class="form-group">
            <img id="preview" src="<c:url value="/resources/images/${product.productId}.png"/>" style="width: 300px;height: 200px"/>
        </div>
    </div>
    <div class="form-group">
        <input  value="Submit" class="btn btn-default" type="submit"/>
        <input  type="reset" value="Cancel" class="btn btn-default"/>
    </div>

</form:form>
    </div>

</div>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

<%@include file="/WEB-INF/views/template/footer.jsp"%>