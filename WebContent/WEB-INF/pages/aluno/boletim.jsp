<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="h" %>

<c:import url="/WEB-INF/templates/aluno/header.jsp" />
	
	<h1 class="ui center aligned icon header">
		<i class="circular student icon"></i>
	 	Boletim
	</h1>
	
<table class="ui celled striped table">
	<thead>
		<tr>
			<th colspan="6">${curso.nome}</th>
		</tr>
		<tr>
			<th>Disciplina</th>
			<th>Projeto 1</th>
			<th>Atividade Pr�tica</th>
			<th>Projeto 2</th>
			<th>M�dia</th>
			<th>Status</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${notas}" var="nota">
			<tr>
				<td class="collapsing">
					${nota.disciplina.nome} 
					<br><span class="ds-obs">${nota.disciplina.professor.nome}</span>
				</td>
				<td>
					<fmt:formatNumber value="${nota.projeto1}" pattern="##.##" />				
				</td>
				<td>
					<fmt:formatNumber value="${nota.atividadePratica}" pattern="##.##" />					
				</td>
				<td>
					<fmt:formatNumber value="${nota.projeto2}" pattern="##.##" />
				</td>
				<td>
					<fmt:formatNumber value="${nota.media}" pattern="##.##" />					
				</td>
				<td>${nota.status}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<c:import url="/WEB-INF/templates/aluno/footer.jsp" />