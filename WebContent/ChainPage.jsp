<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="utf-8">
<title>The Captain's Location</title>
<link rel="stylesheet" href="SteakHouse.css" type="text/css" />
</head>

<body class="container-fluid" style="overflow-x: scroll">
	<!-- Navigation Bar at top in nav -->
	<div class="topnav">

		<a class="active"> The Captain's <br>Steakhouse
		</a> <a href="#home">Home</a>

		<div class="dropdown">
			<button class="dropbtn">Locations</button>
			<div class="dropdown-content">
				<a href="#chainpage"> </a> <a href="#chainpage"> </a> <a
					href="#chainpage"> </a> <a href="#chainpage"> </a> <a
					href="#chainpage"> </a>
			</div>
		</div>

		<a href="#reservations">Reservations</a> <a href="#order">Order
			Online</a> <b><button id="login" type="button" class="loginsignup">Login</button></b>
		<b><button id="signup" type="button" class="loginsignup">Sign
				Up</button></b>
	</div>


	<!-- START OF MAIN PAGE CONTENT -->
	<main>

		<h1></h1>


		<p>
			<br> <br> <br> <br>
		</p>
		<h2 style="text-align: center">Menu</h2>

		<div class="container">
			<table>
				<thead>
					<h2>Appetizer</h2>
				</thead>
				<tbody>
					<c:forEach var="product" items="${allProducts}">
						<td><c:out value="${ product.id }" /></td>
						<td><c:out value="${ product.item }" /></td>
						<td><c:out value="${ product.cost }" /></td>
						<td><a href="edit?id=<c:out value='${ product.id }' />">
								<button class="btn btn-primary">Edit</button>
						</a>&nbsp;
						<td><a href="edit?id=<c:out value='${ product.id }' />">
								<button class="btn btn-danger">Delete</button>
						</a></td>
					</c:forEach>
				</tbody>
			</table>
			<!--
					<h2>Entree</h2>
					<h2>Dessert</h2>
			-->
		</div>

		<section class="row">
			<article id="article1" class="col-8">
				<!-- Inline styling - highest precedence -->
				<p class="group1" style="color: rgba(36, 82, 150, 0.938);">
					Connect with us on <br /> [Insert emblems here] <br />
				</p>
				<p>Did you enjoy your food? Leave us a good review!</p>
			</article>
			<!-- aside doensn't position, we must use CSS -->
			<!-- Semantic elements make more readable html but don't 
            perform and functionality on their own -->
			<aside class="col-4">
				<p>
					<em>FAQs<br>(C) TEAM3, LLC. All rights reserved.
					</em>
				</p>

			</aside>
		</section>

		<!-- The Modal -->
		<div id="myModal" class="modal">
			<div class="modal-content">
				<span class="close">&times;</span>
				<form action="#">
					<div class="form-group">
						<label for="email">Email address:</label> <input type="email"
							class="form-control" placeholder="Enter email" id="email">
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label> <input type="password"
							class="form-control" placeholder="Enter password" id="pwd">
					</div>
					<div class="form-group-b">
						<label class="form-check-label"> <input
							class="form-check-input" type="checkbox"> Remember me
						</label>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</main>

	<script>
		// Get the modal
		var modal = document.getElementById("myModal");

		// Get the button that opens the modal
		var btn = document.getElementById("login");
		var btn2 = document.getElementById("signup");

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];

		// When the user clicks on the button, open the modal
		btn.onclick = function() {
			modal.style.display = "block";
		}
		btn2.onclick = function() {
			modal.style.display = "block";
		}

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
			modal.style.display = "none";
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}

		var slideIndex = 0;
		showSlides();

		function showSlides() {
			var i;
			var slides = document.getElementsByClassName("mySlides");
			for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";
			}
			slideIndex++;
			if (slideIndex > slides.length) {
				slideIndex = 1
			}
			slides[slideIndex - 1].style.display = "block";
			setTimeout(showSlides, 5000); // Change image every 2 seconds
		}
	</script>

</body>
</html>