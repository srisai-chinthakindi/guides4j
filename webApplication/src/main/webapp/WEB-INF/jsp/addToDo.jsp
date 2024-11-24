

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="common/header.jspf"%>


<body>
	<div class="container ">
		<form:form method="post" modelAttribute="todo">
			<div class="mb-3">
				<label class="form-label">Task</label>
				<form:input path="name" type="text" class="form-control"
					required="required" />
				<form:errors path="name" cssClass="text-danger small" />
			</div>
			<div class="mb-3">
				<label class="form-label">Date</label>
				<form:input type="date" path="createdAt" class="form-control" />
			</div>
			<button type="submit" class="btn btn-dark w-100">Submit</button>
		</form:form>
	</div>

<%@ include file="common/footer.jspf"%>