<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="h" %>

<c:import url="/WEB-INF/templates/professor/header.jsp" />
	
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
						<th class="center">Média</th>
						<th class="center">Status</th>
					</tr>
				</thead>
		
				<tbody>
					<tr>
						<td>
							Diego Henrique Sousa Saouda <br>diegosaouda@gmail.com
						</td>
						
						<td>
							<div class="input-field ds-input-number">
								<input class="center" name="projeto1[]" type="number" min="0" max="10">
							</div>
						</td>
						
						<td>
							<div class="input-field ds-input-number">						
								<input class="center" name="atividadePratica[]" type="number" min="0" max="10">
							</div>
						</td>
						
						<td>
							<div class="input-field ds-input-number">
								<input class="center" name="projeto2[]" type="number" min="0" max="10">
							</div>
						</td>
						
						
						<td>
							<div class="input-field ds-input-number">
								<input type="number" class="center" readonly value="0">
							</div>
						</td>
						
						<td>
							<div class="input-field ds-input-number">
								<input type="text" class="center" readonly value="-">
							</div>
						</td>
						
						
					</tr>
					
				</tbody>
			</table>
		</div>
		
		<div class="row">
			<button type="submit" class="waves-effect waves-light btn">
				<i class="material-icons left">cloud</i>
				Salvar Notas
			</button>
		</div>
		
	</form>


<c:import url="/WEB-INF/templates/professor/footer.jsp" />