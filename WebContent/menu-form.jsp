<%@ include file= "header.jsp" %>

<div class="container">

	<h1>Menu Form</h1>
	
	<div class="card-body">

		<%-- will select the form we use, update or insert --%>
		<c:if test="${ location != null }">
			<form action="update_menu" method="get">
			<h1>Update Location</h1>
		</c:if>

		<c:if test="${ location == null }">
			<form action="insert_menu" method="get">
			<h1>Create Location</h1>
		</c:if>
				
				
		<%-- hidden input we can use to pass in a value we want --%>
		<c:if test="${location != null}">
			<input type="hidden" name="menu_id" value="<c:out value='${menu.menu_id}' />" />
		</c:if>
				
		<!-- item field -->
					
		
		<fieldset class="form-group">
			<label>Name</label>
			<input type="text" value="<c:out value='${ menu.category_name}'/>" 
				class="form-control" name="category_name" >
					
		</fieldset>
				
		<fieldset class="form-group">
					
			<label>Dish Name</label>
			<input type="text" value="<c:out value='${ menu.item_name}'/>" 
				class="form-control" name="item_name" required>
					
		</fieldset>
				
		<fieldset class="form-group">
					
			<label>Price</label>
			<input type="number" value="<c:out value='${ menu.price }'/>" 
				class="form-control" name="price" >
					
		</fieldset>
					

		<button type="submit" class="btn btn-success">Save</button>

		</form>


		</div>
	
	

</div>

<%@ include file= "footer.jsp" %>