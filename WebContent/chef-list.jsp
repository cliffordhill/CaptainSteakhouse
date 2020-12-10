<%@ include file="header.jsp"%>

<div class="container">

	<h1>Chef Information</h1>
	<br> <br> 
	<a href="new_chef">
		<button class="btn btn-primary">Add Chef</button>
	</a> <br> <br>


	<table class="table table-striped">

		<thead>
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col"></th>
				
			</tr>
		</thead>

		<tbody>

			<c:forEach var="chef" items="${allChefs}">
				<tr>
					<td><c:out value="${ chef.first_name }" /></td>
					<td><c:out value="${ chef.last_name }" /></td>
				
					<td><a
						href="edit_chef?id=<c:out value='${ chef.chef_id }' />">
							<button class="btn btn-primary">Edit</button>
					</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="delete_chef?id=<c:out value='${ chef.chef_id }' />">
							<button class="btn btn-danger">Delete</button>
					</a></td>
				</tr>

			</c:forEach>

		</tbody>

	</table>

</div>

<%@ include file="footer.jsp"%>