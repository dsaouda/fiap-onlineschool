<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="h" %>

<c:import url="/WEB-INF/templates/professor/header.jsp" />
	
	<c:if test="${mensagem.trim().isEmpty() == false}">
		<div class="card-panel blue lighten-1">${mensagem}</div>
	</c:if>
	
	<h2 class="header orange-text">Avaliar alunos</h2>
	<h5>${disciplina.nome}</h5>

	<form method="post">
		<div class="row">
			<table class="bordered highlight">
				<thead>
					<tr>
						<th>Aluno</th>
						<th class="center">Projeto 1</th>
						<th class="center">Atividade Prática</th>
						<th class="center">Projeto 2</th>
						<th class="center" title="Valor informativo. Não editável">
							Média
							<i class="material-icons">info_outline</i>
						</th>
						<th class="center" title="Valor informativo. Não editável">
							Status
							<i class="material-icons">info_outline</i>
						</th>
					</tr>
				</thead>
		
				<tbody>
					<c:forEach items="${avaliacoes}" var="avaliacao">
						<tr>
							<td>
								<input type="hidden" value="${avaliacao.usuario.id}" name="usuario">
								${avaliacao.usuario.nome} 
								<br>${avaliacao.usuario.email}
							</td>
							
							<td>
								<div class="input-field ds-input-number">
									<input class="center" name="projeto1[${avaliacao.usuario.id}]" value="${avaliacao.nota.projeto1}" type="number" step="any" min="0" max="10">
								</div>
							</td>
							
							<td>
								<div class="input-field ds-input-number">						
									<input class="center" name="atividadePratica[${avaliacao.usuario.id}]" value="${avaliacao.nota.atividadePratica}" type="number" step="any" min="0" max="10">
								</div>
							</td>
							
							<td>
								<div class="input-field ds-input-number">
									<input class="center" name="projeto2[${avaliacao.usuario.id}]" value="${avaliacao.nota.projeto2}" type="number" step="any" min="0" max="10">
								</div>
							</td>
							
							
							<td>
								<div class="input-field ds-input-number orange lighten-5">
									<input type="number" class="center" readonly value="${avaliacao.nota.media}">
								</div>
							</td>
							
							<td>
								<div class="input-field ds-input-number orange lighten-5">
									<input type="text" class="center" readonly value="${avaliacao.nota.status}">
								</div>
							</td>
							
							
						</tr>
					</c:forEach>					
				</tbody>
			</table>
		</div>
		
		<div class="row">
			<button type="submit" class="waves-effect waves-light btn">
				<i class="material-icons">save</i>
				Salvar Notas
			</button>
			
			<a href="./minhas-disciplinas" class="waves-effect orange lighten-1 btn">
				<i class="material-icons left">backspace</i>
				Voltar
			</a>
		</div>
		
	</form>


<c:import url="/WEB-INF/templates/professor/footer.jsp" />