<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/templates/header.jsp" />

<h2>${escola.nome}</h2>
${escola.observacao}

<h4>Cadastro Curso</h4>

<form method="post">
	<div>
		<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ${errors.nome.isInvalid()}">
			<input class="mdl-textfield__input" type="text" value="${curso.nome}" id="nome" name="nome"> 
			<label class="mdl-textfield__label"	for="nome">Nome do curso</label>				
			<span class="mdl-textfield__error">${errors.nome.getMessage()}</span>
		</div>
	</div>
	
	<div>
		<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ${errors.cargaHoraria.isInvalid()}">
			<input class="mdl-textfield__input" type="number" value="${curso.cargaHoraria}" id="cargaHoraria" name="cargaHoraria"> 
			<label class="mdl-textfield__label"	for="cargaHoraria">Carga Horária</label>				
			<span class="mdl-textfield__error">${errors.cargaHoraria.getMessage()}</span>
		</div>
	</div>
	
	<div>
		<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ${errors.sobre.isInvalid()}">
			<textarea class="mdl-textfield__input" rows="3" id="sobre" name="sobre">${curso.sobre}</textarea>
			<label class="mdl-textfield__label" for="sobre">Sobre</label>
			<span class="mdl-textfield__error">${errors.sobre.getMessage()}</span>
		</div>
	</div>
	
	<div style="padding-top: 10px;">
		<button	class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored">Salvar</button>			
		<a href="../curso?escola=${escola.uuid}" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">Voltar</a>	
	</div>
</form>

<c:import url="/WEB-INF/templates/footer.jsp" />