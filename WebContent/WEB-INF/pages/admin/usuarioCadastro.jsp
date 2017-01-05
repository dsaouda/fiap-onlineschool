<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/templates/header.jsp" />

<h4>Cadastro Usuário</h4>

<form method="post">
	<div>
		<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ${errors.nome.isInvalid()}">
			<input class="mdl-textfield__input" type="text" value="${usuario.nome}" id="nome" name="nome"> 
			<label class="mdl-textfield__label"	for="nome">Nome da Usuário</label>				
			<span class="mdl-textfield__error">${errors.nome.getMessage()}</span>
		</div>
	</div>
	
	<div>
		<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ${errors.email.isInvalid()}">
			<input class="mdl-textfield__input" type="text" value="${usuario.email}" id="email" name="email"> 
			<label class="mdl-textfield__label"	for="email">Email</label>				
			<span class="mdl-textfield__error">${errors.email.getMessage()}</span>
		</div>
	</div>
	
	<div>
		<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ${errors.plainSenha.isInvalid()}">
			<input class="mdl-textfield__input" type="password" id="senha" name="senha">
			<label class="mdl-textfield__label"	for="senha">Senha</label>			
			<span class="mdl-textfield__error">${errors.plainSenha.getMessage()}</span>
		</div>
		
		
		<i class="material-icons exibir" title="Exibir senha">visibility_off</i>
		
		<c:if test="${usuario.id > 0}">
			<div class="ds-info">Para não modificar a senha deixe o campo em branco</div>
			<br>
		</c:if>
	</div>
	
	<div>
		<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="adminitrador">
		  <input type="radio" id="adminitrador" name="admin" value="true" class="mdl-radio__button" name="options" <c:if test="${usuario.admin == true}"> checked </c:if> />
		  <span class="mdl-radio__label">Adminitrador</span>
		</label>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="comum">
		  <input type="radio" id="comum" name="admin" value="false" class="mdl-radio__button" name="options" <c:if test="${usuario.admin == false || usuario.admin == null}"> checked </c:if> />
		  <span class="mdl-radio__label">Usuário comum (Aluno ou Professor)</span>
		</label>
	</div>
	
	<div style="padding-top: 10px;">
		<button	class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored">Salvar</button>			
		<a href="../usuario" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">Voltar</a>	
	</div>
</form>

<script>
	$('.exibir')
		.css('cursor', 'pointer')
		.mouseup(function() { 
			$(this).text("visibility_off");
			$('#senha').attr('type', 'password'); 
		})
		.mousedown(function() {
			$(this).text("visibility");
			$('#senha').attr('type', 'text'); 
		});
	
</script>

<c:import url="/WEB-INF/templates/footer.jsp" />