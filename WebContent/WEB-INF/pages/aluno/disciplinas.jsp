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
		<a data-id="${disciplina.id}" href="#" class="ui positive button">Conteúdo Programático</a>

		<div class="ui modal ${disciplina.id}">
			<i class="close icon"></i>
			<div class="header">Conteúdo Programático</div>
			<div class="image content">
				<div class="description">
					<div class="ui header">Detalhe</div>
					${disciplina.conteudoProgramaticoMarkdown}
				</div>
			</div>
		</div>
	
</c:forEach>

<script>
	$('.ui.positive.button').click(function(e) {
		e.preventDefault();
		$('.ui.modal.'+$(this).data('id')).modal('show');
	});
</script>	

<c:import url="/WEB-INF/templates/aluno/footer.jsp" />