<%@ include file="header.jsp"%>

<div class="container">

	<h1>User List</h1>
	<br> <br> 
	<a href="new_user">
		<button class="btn btn-primary">Add User</button>
	</a> <br> <br>


	<table class="table table-striped">

		<thead>
			<tr>
				<th scope="col">Username</th>
				<th scope="col">Password</th>
				<th scope="col"></th>
			</tr>
		</thead>

		<tbody>

			<c:forEach var="user" items="${allUsers}">
				<tr>
					<td><c:out value="${ user.username }" /></td>
					<td><c:out value="${ user.password }" /></td>
					<td><a
						href="edit_user?id=<c:out value='${ user.id }' />">
							<button class="btn btn-primary">Edit</button>
					</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="delete_user?id=<c:out value='${ user.id }' />">
							<button class="btn btn-danger">Delete</button>
					</a></td>
				</tr>

			</c:forEach>

		</tbody>

	</table>

</div>

<%@ include file="footer.jsp"%>