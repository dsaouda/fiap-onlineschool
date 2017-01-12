<%@page import="br.com.fiap.dsaouda.javaweb.model.Usuario"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

  <title>OnlineSchool - Aluno</title>

  <link rel="stylesheet" type="text/css" href="<c:url value="/plugins/semantic-ui/semantic.min.css" />">
  <link rel="stylesheet" href="<c:url value="/css/styles.css"/>">
  <style type="text/css">
  body {
    background-color: #FFFFFF;
  }
  .ui.menu .item img.logo {
    margin-right: 1.5em;
  }
  .main.container {
    margin-top: 7em;
  }
  .wireframe {
    margin-top: 2em;
  }
  .ui.footer.segment {
    margin: 5em 0em 0em;
    padding: 5em 0em;
  }
  </style>
	
  <script src="<c:url value="/plugins/jquery/jquery-3.1.1.min.js"/>"></script>
  <script src="<c:url value="/plugins/semantic-ui/semantic.min.js"/>"></script>	
</head>
<body>

  <div class="ui fixed inverted menu">
    <div class="ui container">
      <a href="#" class="header item">
        <img class="logo" src="<c:url value="/plugins/semantic-ui/logo.png" />">
        <% Usuario usuario = (Usuario)session.getAttribute("usuario"); %>
        OnlineSchool - Aluno ${usuario.getNome()}
      </a>
      
      <a href="<c:url value="/aluno/meus-cursos" />" class="item">Meus Cursos</a>
      <a href="<c:url value="/logout" />" class="item">Sair</a>
    </div>
  </div>

  <div class="ui main text container">