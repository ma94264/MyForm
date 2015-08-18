<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" hola_ext_inject="ready">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/signin.css" />"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body hola-ext-player="1">

	<div class="container">

		<c:if test="${param.error != null}">
			<p>Invalid username / password</p>
		</c:if>
		<c:url var="loginUrl" value="/login" />
		<form action="${loginUrl}" method="post">

			<tr>
				<td colspan="2" style="color: red">${message}</td>
			</tr>
			<label for="inputText" class="sr-only">Username</label> <input
				type="text" name="username" id="inputText" class="form-control"
				placeholder="username" required="" autofocus=""> <label
				for="inputPassword" class="sr-only">Password</label> <input
				type="password" name="password" id="inputPassword"
				class="form-control" placeholder="password" required="">
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">下载客户列表</button>

		</form>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<!-- <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script> -->


</body>
</html>