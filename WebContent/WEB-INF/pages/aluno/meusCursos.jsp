<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="h" %>

<c:import url="/WEB-INF/templates/aluno/header.jsp" />
	
	<h1>Meus Cursos</h1>
	
	Abaixo são listados os cursos no qual você está matriculado.
	
	<c:forEach items="${matriculas}" var="matricula">
	
	<h3 class="ui header">${matricula.curso.nome}</h3>
	<p><i class="wait icon"></i> ${matricula.curso.cargaHoraria} HORAS-AULA (H/A)</p>
	<p>${matricula.curso.sobre}</p>

	<div class="ui buttons">
		<a href="<c:url value="/aluno/disciplinas?curso=${matricula.curso.uuid}" />" class="ui button">Disciplinas</a>
		<div class="or" data-text="ou"></div>
		<a href="<c:url value="/aluno/disciplinas?curso=${matricula.curso.uuid}" />" class="ui positive button">Boletim</a>
	</div>
	
	<div class="ui clearing divider"></div>
	
	</c:forEach>

<c:import url="/WEB-INF/templates/aluno/footer.jsp" />