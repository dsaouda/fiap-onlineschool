<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="h" %>

<c:import url="/WEB-INF/templates/professor/header.jsp" />
	
	<h2 class="header orange-text">Meus Cursos</h2>
	
	<c:forEach items="${cursos}" var="curso">
	
		<div class="row">
			<div class="col s12 m12">
				<div class="card blue-grey darken-1">
					<div class="card-content white-text">
						<span class="card-title">${curso.nome}</span>
						<div>${curso.sobre}</div>
					</div>
					<div class="card-action">
						<a href="<c:url value="/professor/minhas-disciplinas?curso=${curso.uuid}" />">
							Listar disciplinas
						</a>
					</div>
				</div>
			</div>
		</div>
		
	</c:forEach>

<c:import url="/WEB-INF/templates/professor/footer.jsp" />