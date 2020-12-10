<%@ include file= "header.jsp" %>

<div class="container">

	<h1>Location Form</h1>
	
	<div class="card-body">

		<%-- will select the form we use, update or insert --%>
		<c:if test="${ location != null }">
			<form action="update_location" method="get">
			<h1>Update Location</h1>
		</c:if>

		<c:if test="${ location == null }">
			<form action="/insert_location" method="get">
			<h1>Create Location</h1>
		</c:if>
				
				
		<%-- hidden input we can use to pass in a value we want --%>
		<c:if test="${location != null}">
			<input type="hidden" name="location_id" value="<c:out value='${location.id}' />" />
		</c:if>
				
		<!-- item field -->
					
		
		<fieldset class="form-group">
			<label>Name</label>
			<input type="text" value="<c:out value='${ location.name }'/>" 
				class="form-control" name="name" required>
					
		</fieldset>
				
		<fieldset class="form-group">
					
			<label>Address</label>
			<input type="text" value="<c:out value='${ location.address }'/>" 
				class="form-control" name="address" required>
					
		</fieldset>
				
		<fieldset class="form-group">
					
			<label>City</label>
			<input type="text" value="<c:out value='${ location.city }'/>" 
				class="form-control" name="city" required>
					
		</fieldset>
		<fieldset class="form-group">
					
			<label>State</label>
			<input type="text" value="<c:out value='${ location.state }'/>" 
				class="form-control" name="state" required>
					
		</fieldset>
		<fieldset class="form-group">
					
			<label>Zip Code</label>
			<input type="number" value="<c:out value='${ location.zip }'/>" 
				class="form-control" name="zip" required>
					
		</fieldset>
		<fieldset class="form-group">
					
			<label>Phone Number</label>
			<input type="text" value="<c:out value='${ location.phone }'/>" 
				class="form-control" name="phone" required>
					
		</fieldset>
				

		<button type="submit" class="btn btn-success">Save</button>

		</form>


		</div>
	
	

</div>

<%@ include file= "footer.jsp" %>