<%@ include file= "header.jsp" %>

<div class="container">

	<h1>Product Form</h1>
	
	<div class="card-body">

		<%-- will select the form we use, update or insert --%>
		<c:if test="${ product != null }">
			<form action="update" method="get">
			<h1>Update Product</h1>
		</c:if>

		<c:if test="${ product == null }">
			<form action="insert" method="get">
			<h1>Create Product</h1>
		</c:if>
				
				
		<%-- hidden input we can use to pass in a value we want --%>
		<c:if test="${product != null}">
			<input type="hidden" name="id" value="<c:out value='${location.id}' />" />
		</c:if>
				
		<!-- item field -->
		<fieldset class="form-group">
					
			<label>Item</label>
			<input type="text" value="<c:out value='${ location.item }'/>" 
				class="form-control" name="item" required>
					
		</fieldset>
				
		<fieldset class="form-group">
					
			<label>Quantity</label>
			<input type="number" value="<c:out value='${ location.qty }'/>" 
				class="form-control" name="qty" required>
					
		</fieldset>
				
		<fieldset class="form-group">
					
			<label>Description</label>
			<input type="text" value="<c:out value='${ location.description }'/>" 
				class="form-control" name="description" required>
					
		</fieldset>
				

		<button type="submit" class="btn btn-success">Save</button>

		</form>


		</div>
	
	

</div>

<%@ include file= "footer.jsp" %>