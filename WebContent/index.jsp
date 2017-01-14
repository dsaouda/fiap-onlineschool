<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>FIAP OnlineSchool</title>

	<link rel="stylesheet" href="<c:url value="/plugins/bootstrap/bootstrap.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/plugins/bootstrap/cover.css"/>">
  </head>

  <body>

    <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">FIAP Online School</h3>
              <nav>
                <ul class="nav masthead-nav">
                  <li><a href="<c:url value="/admin/login" />">Admin</a></li>
                  <li><a href="<c:url value="/aluno/login" />">Aluno</a></li>
                  <li><a href="<c:url value="/professor/login" />">Professor</a></li>
                </ul>
              </nav>
            </div>
          </div>

          <div class="inner cover">
            <h1 class="cover-heading">Java na WEB</h1>
            
            <p class="lead">
            	O sistema está dividido em 3 partes. Admin, Aluno e Professor. Para realizar acesso em um dos 3 perfis utilize os seguintes acessos: (usuário / senha): 
            </p>

            <p>
            	admin
            	<br>admin@fiap.com.br / 1234

            	<br><br>aluno
				<br>aluno@fiap.com.br / 1234

				<br><br>professor
				<br>professor@fiap.com.br / 1234
				<br><br>
            </p>

            <p class="lead">
              <a href="https://github.com/dsaouda/fiap-onlineschool" class="btn btn-lg btn-default">Mais informações</a>
            </p>
          </div>

          <div class="mastfoot">
            <div class="inner">
              <p>Diego Henrique Sousa Saouda, RM 31364</p>
            </div>
          </div>

        </div>

      </div>

    </div>

  </body>
</html>
