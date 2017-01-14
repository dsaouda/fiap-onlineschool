<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:import url="/WEB-INF/templates/header.jsp" />

<h3>Dashboard</h3>

Seja Bem Vindo ao Sistema Online School

<h4>Últimos Eventos</h4>

<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
	<thead>
		<tr>
			<th class="mdl-data-table__cell--non-numeric">Data</th>
			<th class="mdl-data-table__cell--non-numeric">Usuário</th>
			<th class="mdl-data-table__cell--non-numeric">Perfil</th>
			<th class="mdl-data-table__cell--non-numeric">Método</th>
			<th class="mdl-data-table__cell--non-numeric">URI</th>
			<th class="mdl-data-table__cell--non-numeric">Query/Info</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ultimosEventos}" var="evento">
			<tr>
				<td class="mdl-data-table__cell--non-numeric">
					<fmt:formatDate value="${evento.dataEvento}" pattern="dd/MM/yyyy HH:mm"/>
				</td>
				<td class="mdl-data-table__cell--non-numeric">
					<c:out value="${evento.usuario.nome}" default="Usuário Anônimo" />
					<br>${evento.usuario.email}
				</td>
				<td class="mdl-data-table__cell--non-numeric">
					<c:out value="${evento.usuario.nome}" default="-" />
				</td>
				<td class="mdl-data-table__cell--non-numeric">${evento.metodo}</td>
				<td class="mdl-data-table__cell--non-numeric" title="${evento.url}">
					${fn:substring(evento.url, 0, 60)}
				</td>
				<td class="mdl-data-table__cell--non-numeric" title="${evento.info}">
					${fn:substring(evento.info, 0, 60)}
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>



<c:import url="/WEB-INF/templates/footer.jsp" />