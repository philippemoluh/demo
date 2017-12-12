<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/view/template/header.jsp" %>
  
<div class="ccaintainer-wrapper">
 <div class="container">
    <div class ="page-header"> 
      <h1>Product Inventory Page</h1>

      <p class ="lead">This is the Product Inventory Page</p>       
    </div>
    <table class="table table-striped table-hover">
      <thead>
       <tr class="bg-success">
         <th>Photo Thumb</th>
         <th>Product Name</th>
         <th>category</th>
         <th>Condition</th>
         <th>Price</th> 
         <th></th>     
       </tr>
      </thead>
      <c:forEach items="${products}" var="product" >
        <tr>
            <td><img src="#" alt="image" /></td>
            <td>${product.productName}</td>
            <td>${product.productCategory}</td>
            <td>${product.productCondition}</td>
            <td>${product.productPrice} USD</td>
            <td><a href="<c:url value= "/productList/viewProduct/${product.productId}" />"><span class="glyphicon glyphicon-info-sign"></span></a>
                <a href="<c:url value= "/admin/productInventory/deleteProduct/${product.productId}" />"><span class="glyphicon glyphicon-remove"></span></a>
            </td>
        </tr>
      </c:forEach>
          
    </table>
    <a href="<c:url value="/admin/productInventory/addProduct" />" class="btn btn-primary" >Add Product</a>
<%@include file="/WEB-INF/view/template/footer.jsp" %>
