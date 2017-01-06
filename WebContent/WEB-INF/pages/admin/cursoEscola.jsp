<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="h" %>

<c:import url="/WEB-INF/templates/header.jsp" />

<h2>${escola.nome}</h2>
${escola.observacao}

<h4>Cursos</h4>

<a href="<c:url value="/admin/curso/cadastro?escola=${escola.uuid}" />" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">
	<i class="material-icons">note_add</i>
 	Adicionar novo curso
</a>

<a href="<c:url value="/admin/curso" />" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">
	<i class="material-icons">swap_horiz</i>
 	Selecionar outra escola
</a>



<c:if test="${cursos.size() == 0}">
<div class="mdl-components__warning">
	Nenhum curso cadastrado!!!
</div>
</c:if>

<c:if test="${cursos.size() > 0}">
	<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="width: 600px;">
		<thead>
			<tr>
				<th>ID</th>
				<th class="mdl-data-table__cell--non-numeric">Nome</th>
				<th class="mdl-data-table__cell--non-numeric">Carga Horária</th>
				<th class="mdl-data-table__cell--non-numeric">Sobre</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cursos}" var="curso">
			<tr>
				<td>${curso.id}</td>
				<td class="mdl-data-table__cell--non-numeric">${curso.nome}</td>
				<td class="mdl-data-table__cell--non-numeric">${curso.cargaHoraria}h</td>
				<td class="mdl-data-table__cell--non-numeric">
					<i class="icon material-icons" title="${curso.sobre}">info</i>
				</td>
				<td class="mdl-data-table__cell--non-numeric">
					<div class="mdl-spinner mdl-js-spinner is-active remove-${curso.id}" style="display: none;"></div>
					
					<button id="menu-acoes-${curso.id}"
					        class="mdl-button mdl-js-button mdl-button--icon">
					  <i class="material-icons">more_vert</i>
					</button>
					
					<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect" for="menu-acoes-${curso.id}">
					 
						<li class="mdl-menu__item link" data-href="<c:url value="./curso/cadastro?uuid=${curso.uuid}&escola=${escola.uuid}" />">
							<i class="material-icons">border_color</i>
							Editar
						</li>
						
						<li class="mdl-menu__item show-dialog" data-curso-id="${curso.id}" data-url="<c:url value="./curso/cadastro?uuid=${curso.uuid}"/>">
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
			
	  		$('.remove-' + $self.data('cursoId')).show();
	  		$self[0].outerHTML = '';
	  		
			$.ajax({
			    url: url,
			    type: 'DELETE',
			    success: function(result) {
			    	window.location.href = "./curso?escola=${escola.uuid}";
			    }
			});
		});
	  	
	  	
	  	dialog.querySelector('.no').addEventListener('click', function() {
			dialog.close();
		});
	  	
	});
	 
	
	
	
</script>

<c:import url="/WEB-INF/templates/footer.jsp" />