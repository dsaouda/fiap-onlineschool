<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="h" %>

<c:import url="/WEB-INF/templates/aluno/header.jsp" />
	
	<h1 class="ui center aligned icon header">
		<i class="circular student icon"></i>
	 	${curso.nome}
	</h1>
	
	<h3>Conteúdo <i class="wait icon"></i> ${curso.cargaHoraria} HORAS-AULA (H/A)</h3>
	<h1><i class="circular newspaper icon"></i> Disciplinas</h1>
		
	<c:forEach items="${disciplinas}" var="disciplina">
		<h3 class="ui block header">
		  ${disciplina.nome}
		</h3>
		
		<p><strong>Professor</strong> ${disciplina.professor.nome}</p>
		<a href="<c:url value="/aluno/disciplinas?curso=${matricula.curso.uuid}" />" class="ui positive button">Conteúdo Programático</a>
		
	</c:forEach>
	

<c:import url="/WEB-INF/templates/aluno/footer.jsp" />