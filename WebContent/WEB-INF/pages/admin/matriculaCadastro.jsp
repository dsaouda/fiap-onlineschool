<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="h" %>

<c:import url="/WEB-INF/templates/header.jsp" />

<h2>${curso.nome}</h2>

<h4>Matrículas</h4>

<c:if test="${usuarios.size() == 0}">
<div class="mdl-components__warning">
	Não existem usuários disponíveis para matrícula.
</div>
</c:if>

<c:if test="${usuarios.size() > 0}">
	Somente usuários não matrículados são exibidos.

	<form method="post">
		<ul class="mdl-list">
			<c:forEach items="${usuarios}" var="usuario">
				<li class="mdl-list__item mdl-list__item--two-line">
					<span class="mdl-list__item-primary-content"> 
						<i class="material-icons  mdl-list__item-avatar">person</i>
						<span>${usuario.nome}</span>
						<span class="mdl-list__item-sub-title">${usuario.email}</span>
					</span> 
					
					<span class="mdl-list__item-secondary-action"> 
						<label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="checkbox-matricular-${usuario.id}"> 
							<input type="checkbox" id="checkbox-matricular-${usuario.id}" name="usuarios" value="${usuario.id}" class="mdl-checkbox__input" />
						</label>
					</span>
				</li>
			</c:forEach>
			
		</ul>
		
		<button	class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored">Matricular</button>
	</form>
</c:if>

<c:import url="/WEB-INF/templates/footer.jsp" />