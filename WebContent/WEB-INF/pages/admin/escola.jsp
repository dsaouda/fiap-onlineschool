<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/templates/header.jsp"/>

<h4>Escola</h4>

<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
    <thead>
      <tr>
        <th>ID</th>
        <th class="mdl-data-table__cell--non-numeric">Escola</th>
        <th class="mdl-data-table__cell--non-numeric">Observações</th>
        <th>Ações</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>1</td>
        <td class="mdl-data-table__cell--non-numeric">FIAP</td>
        <td class="mdl-data-table__cell--non-numeric">Escola de tecnologia</td>
        <td class="mdl-data-table__cell--non-numeric">

            <i class="material-icons">border_color</i>
            <i class="material-icons">delete</i>

        </td>
      </tr>

    </tbody>
</table>

<c:import url="/WEB-INF/templates/footer.jsp"/>