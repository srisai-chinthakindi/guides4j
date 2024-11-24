<html>
<head>
<title>login</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
	<h1>guides4J</h1>
	<h4>Featuring ToDo WebApplication</h4>
	<hr>

	<pre>${loginErrorMessage}</pre>

	<form method="post" class="form-group">
		<div>
			Name: <input type="text" name="name"> Password: <input
				type="password" name="pass"> <input type="submit"
				class="btn btn-danger">
		</div>
	</form>
</body>
</html>