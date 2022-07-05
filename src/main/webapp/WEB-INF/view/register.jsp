<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.container {
	padding: 50px;
	background-color: #e4e3e1;
}

input[type=text], input[type=password], textarea {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: orange;
	outline: none;
}

hr {
	border: 1px solid black	;
	margin-bottom: 25px;
}

.registerbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}

div {
	padding: 5px 0;
}
</style>
</head>
<body style="background-color:#e2e4c0;">
	<div class="text-center">
		<h1 style="color: red;"font-family:georgia,garamond,serif;font-size:16px;font-style:italic;">NIRVANA
			Inn</h1>
		<hr size="4" width="100%" color="red">
	</div>

	<form method="POST" action="/register-user">
		<div class="container">
			<center>
				<h2>Register user here</h2>
			</center>
			<hr>
			<label><b>UserName</b> </label> <input type="text" name="userName"
				placeholder="Username" size="10" required /> <label> <label
				for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required>

				<button type="submit" class="registerbtn">Register</button>
	</form>
</body>
</html>
