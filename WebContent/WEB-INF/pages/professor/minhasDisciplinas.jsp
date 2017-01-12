<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="h" %>

<c:import url="/WEB-INF/templates/professor/header.jsp" />
	
	<h2 class="header orange-text">Minhas Disciplinas</h2>
	
	<c:forEach items="${disciplinas}" var="disciplina">
	
		<div class="row">
			<div class="col s12 m6">
				<div class="card blue-grey darken-1">
					<div class="card-content white-text">
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
		</div>
		
	</c:forEach>

<c:import url="/WEB-INF/templates/professor/footer.jsp" />