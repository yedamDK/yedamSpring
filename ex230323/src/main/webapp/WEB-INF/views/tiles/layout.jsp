<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</head>
<body>
	<header>
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</header>
	<main>
		<tiles:insertAttribute name="main"></tiles:insertAttribute>
	</main>

	<div class="container">
		<footer
			class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
			<p class="col-md-4 mb-0 text-body-secondary">&copy; 2023 Company,
				Inc</p>

			<a href="/"
				class="col-md-4 d-flex align-items-center justify-content-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
				<svg class="bi me-2" width="40" height="32">
						<use xlink:href="#bootstrap" /></svg>
			</a>

			<ul class="nav col-md-4 justify-content-end">
				<li class="nav-item"><a href="#"
					class="nav-link px-2 text-body-secondary">Home</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link px-2 text-body-secondary">Features</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link px-2 text-body-secondary">Pricing</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link px-2 text-body-secondary">FAQs</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link px-2 text-body-secondary">About</a></li>
			</ul>
		</footer>
	</div>

</body>
</html>