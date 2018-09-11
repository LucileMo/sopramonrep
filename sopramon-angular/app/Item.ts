<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	xmlns:sec="http://www.thymeleaf.org/extras/spring-security"
	layout:decorator="layout-sopramon.html">

<head>

<meta charset="UTF-8" />



<title>Bienvenue Sopramon !</title>


</head>

<body>

	<header>
		<h1 layout:fragment="custom-title">Menu Sopramon</h1>
	</header>

	<section>
		<div layout:fragment="custom-content">
			<div class="combat">
				<h3>Mode Combat</h3>


				<button type="button" class="btn btn-danger">
					<a href="Combat">Go</a>
				</button>
			</div>
			<div class="items">



				<h3>Vos items</h3>


				<table>

					<thead>
						<tr>
							<th scope="col">Nom</th>
							<th scope="col">Prix</th>
							<th scope="col">Capacite</th>
							<th sec:authorize="hasRole('ROLE_ADMIN')">Actions</th>

						</tr>
					</thead>

					<tr th:each="item : ${ items }"}>

						<td>[[${ item.nom }]]</td>

						<td>[[${ item.prix }]]</td>

						<td>[[${ item.capacite }]]</td>
						<td><a th:href="@{/moditems(id=${ item.id })}"
							class="btn btn-primary">Modifier</a> <a
							th:href="@{/deleteitems(id=${ item.id })}" class="btn btn-danger">Supprimer</a>




						</td>

					</tr>



					</tbody>
				</table>

			</div>

		</div>
	</section>

	<footer>Copyright Sopramon &copy; &reg;</footer>


</body>
</html>
