<%@ include file="header.jsp"%>

<div class="container">

	<h1>Chef Form</h1>

	<div class="card-body">

		<%-- will select the form we use, update or insert --%>
		<c:if test="${ chef != null }">
			<form action="update_chef" method="get">
				<h1>Update Chef</h1>
		</c:if>

		<c:if test="${ chef == null }">
			<form action="insert_chef" method="get">
				<h1>Create Chef</h1>
		</c:if>


		<%-- hidden input we can use to pass in a value we want --%>
		<c:if test="${chef != null}">
			<input type="hidden" name="chef_id"
				value="<c:out value='${chef.chef_id}' />" />
		</c:if>

		<!-- item field -->


		<fieldset class="form-group">
			<label>First Name</label> <input type="text"
				value="<c:out value='${ chef.first_name}'/>" class="form-control"
				name="first_name" required>

		</fieldset>

		<fieldset class="form-group">

			<label>Last Name</label> <input type="text"
				value="<c:out value='${ chef.last_name}'/>" class="form-control"
				name="last_name" required>

		</fieldset>


		<button type="submit" class="btn btn-success">Save</button>

		</form>


	</div>



</div>

<%@ include file="footer.jsp"%>