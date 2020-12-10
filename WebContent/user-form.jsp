<%@ include file= "header.jsp" %>

<div class="container">

	<h1>User Form</h1>
	
	<div class="card-body">

		<%-- will select the form we use, update or insert --%>
		<c:if test="${ user != null }">
			<form action="update_user" method="get">
			<h1>Update User</h1>
		</c:if>

		<c:if test="${ user == null }">
			<form action="insert_user" method="get">
			<h1>Create User</h1>
		</c:if>
				
				
		<%-- hidden input we can use to pass in a value we want --%>
		<c:if test="${user != null}">
			<input type="hidden" name="user_id" value="<c:out value='${user.id}' />" />
		</c:if>
				
		<!-- item field -->
					
		
		<fieldset class="form-group">
			<label>Username</label>
			<input type="text" value="<c:out value='${ user.username }'/>" 
				class="form-control" name="username" required>
					
		</fieldset>
				
		<fieldset class="form-group">
					
			<label>Password</label>
			<input type="text" value="<c:out value='${ user.password }'/>" 
				class="form-control" name="password" required>
					
		</fieldset>
				
		
				

		<button type="submit" class="btn btn-success">Save</button>

		</form>


		</div>
	
	

</div>

<%@ include file= "footer.jsp" %>