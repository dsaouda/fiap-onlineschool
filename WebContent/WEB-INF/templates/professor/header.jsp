<%@page import="br.com.fiap.dsaouda.javaweb.model.Usuario"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0" />
<title>Professor</title>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="<c:url value="/plugins/materialize/css/materialize.css"/>"
	type="text/css" rel="stylesheet" media="screen,projection" />
<style>
.ds-input-number {
	width: 100px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<nav class="light-blue lighten-1" role="navigation">
		<div class="nav-wrapper container">
			<a id="logo-container" href="#" class="brand-logo">OnlineSchool -
				Professor</a>

			<ul class="right hide-on-med-and-down">
				<li>
					<% Usuario usuario = (Usuario)session.getAttribute("usuario"); %>	
	          		Professor ${usuario.getNome()}
	          		&nbsp;
	          		&nbsp;
				</li>
				<li><a href="<c:url value="/logout" />">Logout</a></li>
			</ul>

			<ul id="nav-mobile" class="side-nav">
				<li><a href="<c:url value="/logout" />">Logout</a></li>
			</ul>
			<a href="#" data-activates="nav-mobile" class="button-collapse"><i
				class="material-icons">menu</i></a>
		</div>
		
	</nav>
	<div class="container">