<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="h" %>

<c:import url="/WEB-INF/templates/header.jsp" />

<h4>Cursos</h4>


<c:if test="${escolas.size() == 0}">
<div class="mdl-components__warning">
	Nenhuma escola cadastrada! <a href="<c:url value="/admin/escola"/>">Clique aqui</a> para cadastrar uma escola para só então cadastrar um curso.
</div>
</c:if>

<c:if test="${escolas.size() > 0}">

<h5>Escolha uma escola para o cadastro do curso</h5>

<ul class="demo-list-three mdl-list">
  <c:forEach items="${escolas}" var="escola">
  <li class="mdl-list__item mdl-list__item--three-line">
    <span class="mdl-list__item-primary-content">
      <i class="material-icons mdl-list__item-avatar">account_balance</i>
      <span>${escola.nome}</span>
      <span class="mdl-list__item-text-body">
        ${escola.observacao}
      </span>
    </span>
    <span class="mdl-list__item-secondary-content">
      <a class="mdl-list__item-secondary-action" href="./curso?escola=${escola.uuid}"><i class="material-icons">done</i></a>
    </span>
  </li>
  </c:forEach>
  
</ul>
</c:if>

<c:import url="/WEB-INF/templates/footer.jsp" />