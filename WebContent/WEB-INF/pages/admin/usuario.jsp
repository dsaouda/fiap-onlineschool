<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="h" %>

<c:import url="/WEB-INF/templates/header.jsp" />

<h4>Usuários</h4>

<a href="<c:url value="/admin/usuario/cadastro" />" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">
	<i class="material-icons">note_add</i>
 	Adicionar novo usuário
</a>


<c:if test="${usuarios.size() == 0}">
<div class="mdl-components__warning">
	Nenhum usuário cadastrado!!!
</div>
</c:if>

<c:if test="${usuarios.size() > 0}">
	<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
		<thead>
			<tr>
				<th>ID</th>
				<th class="mdl-data-table__cell--non-numeric">Nome</th>
				<th class="mdl-data-table__cell--non-numeric">Email</th>
				<th class="mdl-data-table__cell--non-numeric">Administrador</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuario.id}</td>
				<td class="mdl-data-table__cell--non-numeric">${usuario.nome}</td>
				<td class="mdl-data-table__cell--non-numeric">${usuario.email}</td>
				<td class="mdl-data-table__cell--non-numeric">
					<h:simNao value="${usuario.admin}"/>
				</td>
				<td class="mdl-data-table__cell--non-numeric">
					<div class="mdl-spinner mdl-js-spinner is-active remove-${usuario.id}" style="display: none;"></div>
					
					<button id="menu-acoes-${usuario.id}"
					        class="mdl-button mdl-js-button mdl-button--icon">
					  <i class="material-icons">more_vert</i>
					</button>
					
					<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect" for="menu-acoes-${usuario.id}">
					 
						<li class="mdl-menu__item link" data-href="<c:url value="./usuario/cadastro?uuid=${usuario.uuid}" />">
							<i class="material-icons">border_color</i>
							Editar
						</li>
						
						<li class="mdl-menu__item show-dialog" data-usuario-id="${usuario.id}" data-url="<c:url value="./usuario/cadastro?uuid=${usuario.uuid}"/>">
							<i class="material-icons">delete</i>
							Remover
						</li>
					 
					</ul>
					
				</td>
			</tr>
			</c:forEach>
	
		</tbody>
	</table>
</c:if>

<dialog class="mdl-dialog">
	<h4 class="mdl-dialog__title">Excluir esse registro?</h4>
	<div class="mdl-dialog__content">
		<p>Você está certo que deseja excluir esse registro?</p>
	</div>
  	
  	<div class="mdl-dialog__actions">
    	<button type="button" class="mdl-button yes">Sim</button>
    	<button type="button" class="mdl-button no">Não</button>
  	</div>
</dialog>
  
<script>
	$('.show-dialog').on('click', function(e) {
		var dialog = document.querySelector('dialog');
		 
		if (! dialog.showModal) {
			dialogPolyfill.registerDialog(dialog);
		}
		
		var $self = $(this);
		var url = $self.data('url');
		
		e.preventDefault();
	  	dialog.showModal();
	  	
	  	dialog.querySelector('.yes').removeEventListener('click', function() {});
	  	dialog.querySelector('.no').removeEventListener('click', function() {});
	  	
	  	dialog.querySelector('.yes').addEventListener('click', function() {
	  		dialog.close();
			
	  		$('.remove-' + $self.data('usuarioId')).show();
	  		$self[0].outerHTML = '';
	  		
			$.ajax({
			    url: url,
			    type: 'DELETE',
			    success: function(result) {
			    	window.location.href = "./usuario";
			    }
			});
		});
	  	
	  	
	  	dialog.querySelector('.no').addEventListener('click', function() {
			dialog.close();
		});
	  	
	});
	 
	
	
	
</script>

<c:import url="/WEB-INF/templates/footer.jsp" />