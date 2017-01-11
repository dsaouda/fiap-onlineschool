<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
		<title>${headerLogin} - Online School</title>
		
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
	    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	    <link rel="stylesheet" href="<c:url value="/plugins/getmdl/material.min.css"/>">
	    <link rel="stylesheet" href="<c:url value="/plugins/getmdl/components.css"/>">
	    <link rel="stylesheet" href="<c:url value="/plugins/getmdl-select/getmdl-select.min.css"/>">
	    
	    <link rel="stylesheet" href="<c:url value="/css/styles.css"/>">
	    
	    <script src="<c:url value="/plugins/getmdl/material.min.js"/>"></script>
	</head>
	<body>
		<div style="margin: 0 auto; margin-top: 100px;" class="mdl-card mdl-shadow--6dp">
			<div class="mdl-card__title mdl-color--primary mdl-color-text--white">
				<h2 class="mdl-card__title-text">Login - ${headerLogin}</h2>
			</div>
			
			<form method="post">
				<c:if test="${error != null}">
					<div class="mdl-color-text--red-A700 mdl-components__warning">
						${error}
					</div>
				</c:if>
				
				<div class="mdl-card__supporting-text">
					<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" id="email" name="email" />
						<label class="mdl-textfield__label" for="email">E-mail</label>
					</div>
					
					<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="password" id="senha" name="senha" />
						<label class="mdl-textfield__label" for="senha">Senha</label>
					</div>
				</div>
	
				<div class="mdl-card__actions mdl-card--border">
					<button type="submit" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Entrar</button>
				</div>
			</form>
		</div>
	</body>
</html>