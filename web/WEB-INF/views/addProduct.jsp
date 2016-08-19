<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">

    <div class="container">

        <div class="page-header">
            <h3> Add Product</h3>
            <p>New products can be added</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct" method="post"
                   commandName="product" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Name  </label>
                <form:input path="productName" id="name" class="form-control"/>
                <form:errors path="productName"  cssStyle="color:red;font-family: 'Lucida Console'"    />

            </div>
            <div class="form-group">
                <label for="category">Category</label>
                <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="Instrument"/>Instrument </label>
                <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="Recorder"/>Recorder </label>
                <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="Accessory"/>Accessory </label>
                <br/>
                <form:errors path="productCategory"  cssStyle="color:red;font-family: 'Lucida Console'"  />
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <form:textarea path="productDescription" id="description" class="form-control"/>
                <form:errors path="productDescription"  cssStyle="color:red;font-family: 'Lucida Console'" />
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <form:input path="productPrice" id="price" class="form-control"/>
                <form:errors path="productPrice" id="price" cssStyle="color:red;font-family: 'Lucida Console'"  />
            </div>
            <div class="form-group">
                <label for="condition">Condition</label>
                <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="New"/>New</label>
                <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="Used"/>Used</label>
                <br/>
                <form:errors path="productCondition"  cssStyle="color:red;font-family: 'Lucida Console'"  />
            </div>
            <div class="form-group">
                <label for="status">Status</label>
                <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="In Stock"/>In Stock</label>
                <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="Not Available"/>Not Available</label>
                <br/>
                <form:errors path="productStatus"  cssStyle="color:red;font-family: 'Lucida Console'"  />
            </div>
            <div class="form-group">
                <label for="units">Units in Stock</label>
                <form:input path="unitInStock" id="units" class="form-control"/>
                <form:errors path="unitInStock"  cssStyle="color:red;font-family: 'Lucida Console'"  />
            </div>
            <div class="form-group">
                <label for="manufacturer">Manufacturer</label>
                <form:input path="productManufacturer" id="manufacturer" class="form-control"/>
                <form:errors path="productManufacturer"  cssStyle="color:red;font-family: 'Lucida Console'"  />
            </div>
            <div class="form-group">
                <label for="upload">Upload Image</label>
                <form:input path="productImage" id="upload" type="file" class="form-input-large" onchange="PreviewImage();" />
            </div>

        <div class="form-group">
            <img id="preview"  src="<c:url value="/resources/images/upload_image.png"/>" alt="Upload Image"  style="width: 300px;height: 200px"/>
        </div>

    </div>
            <div class="form-group">

                <input  value="Submit" class="btn btn-default" type="submit"/>
                <input  type="reset" value="Cancel" class="btn btn-default"/>
            </div>
        </form:form>
</div>
    </div>
</div>
<br/>
<br/>
<br/>
<%@include file="/WEB-INF/views/template/footer.jsp"%>