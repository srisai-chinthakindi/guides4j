<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="common/header.jspf"%>


<div class="container">
	<a href="add-todo" class="h4 btn btn-success">Add ToDo</a>
</div>
<hr>
<div>

	<table class="container table">
		<thead>
			<tr>
				<th>Description</th>
				<th>Created by</th>
				<th>Created At</th>
				<th>Status</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="t" >
				<tr>
					<td>${t.name}</td>
					<td>${t.createdBy}</td>
					<td>${t.createdAt}</td>
					<td>${t.status}</td>
					<td><a class="btn btn-warning" href="delete-todos?id=${t.id}">Delete</a></td>
					<td><a class="btn btn-success" href="update-todos?id=${t.id}">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="common/footer.jspf"%>
