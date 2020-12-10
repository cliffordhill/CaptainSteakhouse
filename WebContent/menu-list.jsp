<%@ include file="header.jsp"%>

<div class="container">

	<h1>Menu List</h1>
	<br> <br> 
	<a href="new_menu">
		<button class="btn btn-primary">Add Menu Item</button>
	</a> <br> <br>


	<table class="table table-striped">

		<thead>
			<tr>
				<th scope="col">Category</th>
				<th scope="col">Dish</th>
				<th scope="col">Price</th>
				<th scope="col"></th>
			</tr>
		</thead>

		<tbody>

			<c:forEach var="menu" items="${allMenu}">
				<tr>
					<td><c:out value="${ menu.category_name }" /></td>
					<td><c:out value="${ menu.item_name}" /></td>
					<td><c:out value="${ menu.price}" /></td>
					<td><a
						href="edit_location?id=<c:out value='${ menu.menu_id }' />">
							<button class="btn btn-primary">Edit</button>
					</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="delete_location?id=<c:out value='${ menu.menu_id }' />">
							<button class="btn btn-danger">Delete</button>
					</a></td>
				</tr>

			</c:forEach>

		</tbody>

	</table>

</div>

<%@ include file="footer.jsp"%>