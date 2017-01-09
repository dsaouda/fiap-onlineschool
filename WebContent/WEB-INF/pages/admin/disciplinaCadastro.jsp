<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/templates/header.jsp" />

<h3>${curso.nome}</h3>

<h4>Cadastro Disciplina</h4>

<form method="post">
	<div>
		<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ${errors.nome.isInvalid()}">
			<input class="mdl-textfield__input" type="text" value="${disciplina.nome}" id="nome" name="nome"> 
			<label class="mdl-textfield__label"	for="nome">Nome da disciplina</label>				
			<span class="mdl-textfield__error">${errors.nome.getMessage()}</span>
		</div>
	</div>
	
	<div>
		<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ${errors.conteudoProgramatico.isInvalid()}">
			<textarea class="mdl-textfield__input" rows="3" id="conteudoProgramatico" name="conteudoProgramatico">${disciplina.conteudoProgramatico}</textarea>
			<label class="mdl-textfield__label" for="conteudoProgramatico">Conteúdo Programático</label>
			<span class="mdl-textfield__error">${errors.conteudoProgramatico.getMessage()}</span>
		</div>
		
		<a href="https://guides.github.com/features/mastering-markdown/" target="_blank" title="Esse campo aceita Markdown">
			<i class="material-icons" style="vertical-align: top;">info</i>
		</a>
	</div>
	
	
	<div>
		<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ${errors.professor.isInvalid()}">
			<select class="mdl-textfield__input" id="professor" name="professor">
				<option></option>
				<c:forEach items="${professores}" var="professor">
                	<option value="${professor.uuid}"<c:if test="${disciplina.professor.uuid == professor.uuid}"> selected</c:if>>${professor.nome}</option>
                </c:forEach>
			</select> 
			<label class="mdl-textfield__label"	for="professor">Professor</label>				
			<span class="mdl-textfield__error">${errors.professor.getMessage()}</span>
		</div>
	</div>
	
	<div style="padding-top: 10px;">
		<button	class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored">Salvar</button>			
		<a href="../disciplina?curso=${curso.uuid}" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">Voltar</a>	
	</div>
</form>

<c:import url="/WEB-INF/templates/footer.jsp" />