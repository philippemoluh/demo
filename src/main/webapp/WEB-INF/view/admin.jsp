<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/view/template/header.jsp" %>
  
<div class="ccaintainer-wrapper">
 <div class="container">
    <div class ="page-header"> 
      <h1>Administrator Page</h1>

      <p class ="lead"> this is an administrator Page</p>       
    </div>
    <h3>
      <a href="<c:url value="admin/productInventory" />">Product Inventory</a>
    </h3>
    <p> Hier you can view an Modify the Product Inventory</p>
    

<%@include file="/WEB-INF/view/template/footer.jsp" %>
