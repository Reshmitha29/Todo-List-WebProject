<%@include file="common/header.jspf" %>
<body>
<%@include file="common/navigation.jspf" %>
	<div class="container">
		<div>
			<h1>Your Todos</h1>
			<div class="table">
			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Done?</th>
						<th> </th>
						<th> </th>
						
					
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDAte}</td>
							<td>${todo.done}</td>
							<td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete ${todo.id}</a>   </td>
							<td> <a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a> </td>
						
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add-todo" class="btn btn-success">Add Todo</a>
			</div>

		</div>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>

	</div>
</body>

</html>

