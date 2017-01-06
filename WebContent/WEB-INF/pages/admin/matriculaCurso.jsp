<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/templates/header.jsp" />

<h2>${curso.nome}</h2>

<h4>Matriculas</h4>

<a href="<c:url value="/admin/matricula/cadastro?curso=${curso.uuid}" />" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">
	<i class="material-icons">note_add</i>
 	novo aluno
</a>

<a href="<c:url value="/admin/curso?escola=${curso.escola.uuid}" />" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">
	<i class="material-icons">swap_horiz</i>
 	Selecionar outro curso
</a>



<c:if test="${matriculas.size() == 0}">
<div class="mdl-components__warning">
	Nenhuma matricula realizada!!!
</div>
</c:if>

<c:if test="${matriculas.size() > 0}">
	<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="width: 600px;">
		<thead>
			<tr>
				<th>Número</th>
				<th class="mdl-data-table__cell--non-numeric">Aluno</th>
				<th class="mdl-data-table__cell--non-numeric">Matrícula</th>
				<th class="mdl-data-table__cell--non-numeric">Cancelar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${matriculas}" var="matricula">
			<tr>
				<td>${matricula.codigo}</td>
				<td class="mdl-data-table__cell--non-numeric">
					${matricula.aluno.nome}
					<br>
					${matricula.aluno.email}
				</td>
				<td class="mdl-data-table__cell--non-numeric">
					<fmt:formatDate value="${matricula.matriculadoEm}" pattern="dd/MM/yyyy HH:mm"/>
				</td>
				<td class="mdl-data-table__cell--non-numeric">
				
					<div class="mdl-spinner mdl-js-spinner is-active remove-${matricula.id}" style="display: none;"></div>
					<i style="cursor: pointer;" class="material-icons show-dialog" 
						data-matricula-id="${matricula.id}" 
						data-url="<c:url value="./matricula/cadastro?uuid=${matricula.uuid}"/>">cancel</i>
				</td>
			</tr>
			</c:forEach>
	
		</tbody>
	</table>
</c:if>

<dialog class="mdl-dialog">
	<h4 class="mdl-dialog__title">Cancelar a matrícula</h4>
	<div class="mdl-dialog__content">
		<p>Você está certo que deseja cancelar a matrícula desse aluno?</p>
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
			
	  		$('.remove-' + $self.data('matriculaId')).show();
	  		$self[0].outerHTML = '';
	  		
			$.ajax({
			    url: url,
			    type: 'DELETE',
			    success: function(result) {
			    	window.location.href = "./matricula?curso=${curso.uuid}";
			    }
			});
		});
	  	
	  	
	  	dialog.querySelector('.no').addEventListener('click', function() {
			dialog.close();
		});
	  	
	});
	 
	
	
	
</script>

<c:import url="/WEB-INF/templates/footer.jsp" />