<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/templates/header.jsp" />

<h4>Cadastro Escola</h4>

<form method="post">
	<div>
		<div
			class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
			<input class="mdl-textfield__input" type="text" value="${escola.nome}" id="nome"
				name="nome"> <label class="mdl-textfield__label"
				for="nome">Nome da Escola</label>
		</div>
	</div>

	<div>
		<div
			class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
			<textarea class="mdl-textfield__input" rows="3" id="observacao"
				name="observacao">${escola.observacao}</textarea>
			<label class="mdl-textfield__label" for="observacao">Observações</label>
		</div>
	</div>

	<div>
		<button
			class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored">
			Salvar</button>
			
		<a href="../escola" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">
			Voltar
		</a>	
	</div>
</form>

<c:import url="/WEB-INF/templates/footer.jsp" />