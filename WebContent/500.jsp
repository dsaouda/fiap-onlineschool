<%@page import="br.com.fiap.dsaouda.javaweb.exception.MensagemException"%>
<%@ page isErrorPage="true" import="java.io.*" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
	<title>Erro interno</title>

	<!-- Page styles -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="<c:url value="/plugins/getmdl/material.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/plugins/getmdl/components.css"/>">
    <link rel="stylesheet" href="<c:url value="/plugins/getmdl-select/getmdl-select.min.css"/>">
    
    <link rel="stylesheet" href="<c:url value="/css/styles.css"/>">
    
    <style>
    	.errors {
    		display: none;
    		width: 1000px;
    		margin: 0 auto;
    	}
    </style>
    
    <script src="<c:url value="/plugins/jquery/jquery-3.1.1.min.js"/>"></script>
    <script src="<c:url value="/plugins/getmdl/material.min.js"/>"></script>
    <script src="<c:url value="/plugins/getmdl-select/getmdl-select.min.js"/>"></script>
</head>
<body>
	
	<br>
	<div class="mdl-components__warning" style="font-size: 30px; text-align: center; padding: 50px; background-color: #efa28f;">
		<% if (exception instanceof MensagemException) { %>
			<span style="font-size: 15px;"><%= exception.getMessage() %></span>
		<% } else {  %>	
		OPS! 
		<br><span style="font-size: 15px;">Ocorreu um erro no servidor. Estamos analisando o problema.</span>
		<% } %>
	</div>
	
	<div style="text-align: center;">
		<br>
		<a href="#" onclick="history.back();" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">Voltar para página anterior</a>
	</div>
	
	<div style="text-align: center;">
		<br><br>
		<a href="#" class="btn-show-errors">Exibir / Ocultar erros</a>
	</div>
	
	<div class="errors" style="display: none;">
		<strong>Message: <%= exception.getMessage() %></strong>

		<br><br><strong>StackTrace:</strong>
		<pre><%
				StringWriter stringWriter = new StringWriter();
				PrintWriter printWriter = new PrintWriter(stringWriter);
				exception.printStackTrace(printWriter);
				out.println(stringWriter);
				printWriter.close();
				stringWriter.close();
			%>
		</pre>
	</div>
	
	<script>
		$('.btn-show-errors').click(function() {
			$('.errors').toggle();
		});
	</script>
</body>
</html>