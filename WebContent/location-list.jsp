<%@ include file= "header.jsp" %>

<div class="container">

	<h1>Location List</h1>
	<br>
	<br>
	
	<table class="table table-striped">
		
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Item</th>
				<th scope="col">Quantity</th>
				<th scope="col">Description</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		
		<tbody>
			
			<c:forEach var="product" items="${allProducts}">
				<tr>
				<td>
					<c:out value="${ product.id }" />
				</td>
				<td>
					<c:out value="${ product.item }" />
				</td>
				<td>
					<c:out value="${ product.qty }" />
				</td>
				<td>
					<c:out value="${ product.description }" />
				</td>
				<td>
					<a href="edit?id=<c:out value='${ product.id }' />">
						<button class="btn btn-primary">Edit</button>
					</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="delete?id=<c:out value='${ product.id }' />">
						<button class="btn btn-danger">Delete</button>
					</a>
				</td>
				</tr>
			
			</c:forEach>
		
		</tbody>
	
	</table>

</div>

<%@ include file= "footer.jsp" %>