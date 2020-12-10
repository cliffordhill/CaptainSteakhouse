<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body style="background-color:brown;">
<head>
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

		<li class="nav -item">
			<a class="nav-link" href="<%= request.getContextPath() %>/list_locations">Locations</a>
			</li>
					<li class="nav -item">
			<a class="nav-link" href="<%= request.getContextPath() %>/list_Menu">Menu</a>
			</li>
					<li class="nav -item">
			<a class="nav-link" href="<%= request.getContextPath() %>/list_Chefs">Chefs</a>
			</li>
		<li class="nav -item">
			<a class="nav-link" href="<%= request.getContextPath() %>/list_Chefs">Users</a>
			</li>

	</div>
		     
<main>
		<h1>Enjoy our food!</h1>

		<!-- Slideshow container -->
		<div class="slideshow-container">

			<!-- Full-width images with number and caption text -->
			<div class="mySlides fade">
				<img
					src="https://natashaskitchen.com/wp-content/uploads/2020/03/Pan-Seared-Steak-4-728x1092.jpg"
					style="width: 30%"  alt="NY Strip">
			</div>

		
			</div>
		</div>
		<br>

		<!-- The dots/circles -->
		<div style="text-align: center">
			<span class="dot" onclick="currentSlide(1)"></span> <span class="dot"
				onclick="currentSlide(2)"></span> <span class="dot"
				onclick="currentSlide(3)"></span>
				
				
				</div>
	</main>
				</html>