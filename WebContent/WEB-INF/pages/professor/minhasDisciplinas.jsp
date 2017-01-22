<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="h" %>

<c:import url="/WEB-INF/templates/professor/header.jsp" />
	
	<h2 class="header orange-text">Minhas Disciplinas</h2>
	
	<div class="row">
		<c:forEach items="${disciplinas}" var="disciplina">
			
			<div class="col s12">
				<div class="card blue-grey darken-1">
					<div class="card-content white-text">
						<span>${disciplina.curso.nome}</span><br>
						<span class="card-title">${disciplina.nome}</span>
						<div>${disciplina.conteudoProgramaticoMarkdown}</div>
					</div>
					<div class="card-action">
						<a href="<c:url value="/professor/avaliar?disciplina=${disciplina.uuid}" />">
							Avaliar <span style="font-size: 20px;">${disciplina.curso.matriculas.size()}</span> aluno(s)
						</a>
					</div>
				</div>
			</div>
			
		</c:forEach>
	</div>

<c:import url="/WEB-INF/templates/professor/footer.jsp" />