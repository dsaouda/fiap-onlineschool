<%@page import="br.com.fiap.dsaouda.javaweb.model.Usuario"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
    <title>Admin - Online School</title>

    <!-- Page styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="<c:url value="/plugins/getmdl/material.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/plugins/getmdl/components.css"/>">
    <link rel="stylesheet" href="<c:url value="/plugins/getmdl-select/getmdl-select.min.css"/>">
    
    <link rel="stylesheet" href="<c:url value="/css/styles.css"/>">
    
    <style>
    	a {
    		text-decoration: none;
    	}
    </style>
    
    <script src="<c:url value="/plugins/jquery/jquery-3.1.1.min.js"/>"></script>
    <script src="<c:url value="/plugins/getmdl/material.min.js"/>"></script>
    <script src="<c:url value="/plugins/getmdl-select/getmdl-select.min.js"/>"></script>
  </head>
  <body>
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header has-tabs is-upgraded">

      <div class="mdl-layout__header mdl-layout__header--waterfall">
        <div class="mdl-layout__header-row">
          <span class="mdl-layout-title">
            Online School
          </span>
          <!-- Add spacer, to align navigation to the right in desktop -->
          <div class="mdl-layout-spacer"></div>

          ${usuarioSession.getNome()}&nbsp;&nbsp;<a href="<c:url value="/logout" />">(Sair)</a>

        </div>
      </div>

      <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">
          Online School
        </span>
        <nav class="mdl-navigation">
          <a class="mdl-navigation__link" href="<c:url value="/admin/home" />">Home</a>
          <a class="mdl-navigation__link" href="<c:url value="/admin/escola" />">Escolas</a>
          <a class="mdl-navigation__link" href="<c:url value="/admin/curso" />">Cursos</a>
          <a class="mdl-navigation__link" href="<c:url value="/admin/usuario" />">Usu�rios</a>
        </nav>
      </div>

      <main class="ds-content mdl-layout__content">