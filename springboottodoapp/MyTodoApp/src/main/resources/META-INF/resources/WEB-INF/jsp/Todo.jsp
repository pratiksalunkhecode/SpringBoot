<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h1>
		Your Todos
		<h1>
			<table class="table">
				<thead>
					<tr>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Done</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${Todos}" var="todo">
						<tr>
							<td>${todo.description}</td>
							<td>${todo.targateDate}</td>
							<td>${todo.done}</td>

							<td><a href="delete-todo?id=${todo.id}"
								class="btn btn-warning"> Delete</a></td>
							<td><a href="update-todo?id=${todo.id}"
								class="btn btn-success"> Update</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add-todo" class="btn btn-success">Add Todo</a>
			<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
			<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</div>
</body>
</html>