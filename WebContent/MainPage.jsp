<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Captain's Steakhouse</title>
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
				<a href="#chainpage"> 
				</a> <a href="#chainpage">
				</a> <a href="#chainpage"> 
				</a> <a href="#chainpage">
				</a> <a href="#chainpage">
				</a>
			</div>
		</div>

		<a href="#reservations">Reservations</a> 
		<a href="#order">Order Online</a> 
		<b><button id="login" type="button" class="loginsignup">Login</button></b>
		<b><button id="signup" type="button" class="loginsignup">Sign Up</button></b>
	</div>

	<!-- START OF MAIN PAGE CONTENT -->
	<main>
		<h1>Enjoy a night out!</h1>

		<!-- Slideshow container -->
		<div class="slideshow-container">

			<!-- Full-width images with number and caption text -->
			<div class="mySlides fade">
				<img
					src="https://natashaskitchen.com/wp-content/uploads/2020/03/Pan-Seared-Steak-4-728x1092.jpg"
					style="width: 70%" alt="NY Strip">
			</div>

			<div class="mySlides fade">
				<img
					src="https://i0.wp.com/www.spainonafork.com/wp-content/uploads/2019/01/calamari2-11.png?fit=750%2C750&ssl=1"
					style="width: 70%" alt="Calamari">
			</div>

			<div class="mySlides fade">
				<img
					src="https://natashaskitchen.com/wp-content/uploads/2020/05/Pefect-Cheesecake-7.jpg"
					style="width: 70%" alt="Cheesecake">
			</div>
		</div>
		<br>

		<!-- The dots/circles -->
		<div style="text-align: center">
			<span class="dot" onclick="currentSlide(1)"></span> <span class="dot"
				onclick="currentSlide(2)"></span> <span class="dot"
				onclick="currentSlide(3)"></span>
		</div>


		<section class="row">
			<article id="article1" class="col-8">
				<!-- Inline styling - highest precedence -->
				<p class="group1" style="color: rgba(36, 82, 150, 0.938);">
					Connect with us on <br /> [Insert emblems here] <br />
				</p>
				<p>Did you enjoy your food? Leave us a good review!</p>
			</article>

			<aside class="col-4">
				<p>
					<em>FAQs<br>(C) TEAM3, LLC. All rights reserved.
					</em>
				</p>
			</aside>
		</section>

		<!-- The Login Modal -->
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

		<!-- The Sign Up Modal -->
		<div id="mysignupModal" class="modal">
			<div class="modal-content">
				<span class="close">&times;</span>
				<form action="#">
					<div class="form-group">
						<label for="email">Email address:</label> 
						<input type="email"
							class="form-control" placeholder="Enter email" id="email">
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label> 
						<input type="password"
							class="form-control" placeholder="Enter password" id="pwd">
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