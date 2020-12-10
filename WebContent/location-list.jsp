<%@ include file= "header.jsp" %>

<div class="container">

	<h1>Location List</h1>
	<br>
	<br>
	
	<table class="table table-striped">
		
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Name</th>
				<th scope="col">Address</th>
				<th scope="col">City</th>
				<th scope="col">State</th>
				<th scope="col">Zip</th>
				<th scope="col">Phone</th>
			</tr>
		</thead>
		
		<tbody>
			
			<c:forEach var="location" items="${allLocations}">
				<tr>
				<td>
					<c:out value="${ location.id }" />
				</td>
				<td>
					<c:out value="${ location.name }" />
				</td>
				<td>
					<c:out value="${ location.address }" />
				</td>
				<td>
					<c:out value="${ location.city }" />
				</td>
				<td>
					<c:out value="${ location.state }" />
				</td>
				<td>
					<c:out value="${ location.zip }" />
				</td>
				<td>
					<c:out value="${ location.phone }" />
				</td>
				<td>
					<a href="edit?id=<c:out value='${ location.id }' />">
						<button class="btn btn-primary">Edit</button>
					</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="delete?id=<c:out value='${ location.id }' />">
						<button class="btn btn-danger">Delete</button>
					</a>
				</td>
				</tr>
			
			</c:forEach>
		
		</tbody>
	
	</table>

</div>

<%@ include file= "footer.jsp" %>