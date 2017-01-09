<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/templates/header.jsp" />

<h4>Escolas</h4>

<a href="<c:url value="/admin/escola/cadastro" />" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">
	<i class="material-icons">note_add</i>
 	Adicionar nova escola
</a>


<c:if test="${escolas.size() == 0}">
<div class="mdl-components__warning">
	Nenhuma escola cadastrada!!!
</div>
</c:if>

<c:if test="${escolas.size() > 0}">
	<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
		<thead>
			<tr>
				<th>ID</th>
				<th class="mdl-data-table__cell--non-numeric">Escola</th>
				<th class="mdl-data-table__cell--non-numeric">Observações</th>
				<th>Total Cursos</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${escolas}" var="escola">
			<tr>
				<td>${escola.id}</td>
				<td class="mdl-data-table__cell--non-numeric">${escola.nome}</td>
				<td class="mdl-data-table__cell--non-numeric">${escola.observacao}</td>
				<td>${escola.cursos.size()}</td>
				<td class="mdl-data-table__cell--non-numeric">
					<div class="mdl-spinner mdl-js-spinner is-active remove-${escola.id}" style="display: none;"></div>
					
					<button id="menu-acoes-${escola.id}"
					        class="mdl-button mdl-js-button mdl-button--icon">
					  <i class="material-icons">more_vert</i>
					</button>
					
					<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect" for="menu-acoes-${escola.id}">
					 
						<li class="mdl-menu__item link" data-href="<c:url value="./curso/cadastro?escola=${escola.uuid}" />">
							<i class="material-icons">note_add</i>
							Curso
						</li>
						
						<li class="mdl-menu__item link" data-href="<c:url value="./escola/cadastro?uuid=${escola.uuid}" />">
							<i class="material-icons">border_color</i>
							Editar
						</li>
						
						<li class="mdl-menu__item show-dialog" data-escola-id="${escola.id}" data-url="<c:url value="./escola/cadastro?uuid=${escola.uuid}"/>">
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
			
	  		$('.remove-' + $self.data('escolaId')).show();
	  		$self[0].outerHTML = '';
	  		
			$.ajax({
			    url: url,
			    type: 'DELETE',
			    success: function(result) {
			    	window.location.href = "./escola";
			    }
			});
		});
	  	
	  	
	  	dialog.querySelector('.no').addEventListener('click', function() {
			dialog.close();
		});
	  	
	});
	 
	
	
	
</script>

<c:import url="/WEB-INF/templates/footer.jsp" />