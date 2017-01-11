<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
<title>Página não encontrada</title>

<!-- Page styles -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.min.css">
	
	<link rel="stylesheet" href="https://getmdl.io/assets/components.css">
	<link rel="stylesheet" href="<c:url value="/css/styles.css"/>">
</head>
<body>
	
	<br>
	<div class="mdl-components__warning" style="font-size: 30px; text-align: center; padding: 50px;">
		Página não encontrada
	</div>
	
	<div style="text-align: center;">
		<br>
		<a href="#" onclick="history.back();" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">Voltar para página anterior</a>
	</div>
	
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>
</html>