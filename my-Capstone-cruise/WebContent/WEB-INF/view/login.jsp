<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Login</title>
	
	<!-- reference our style sheet -->
	<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/favicon1.ico">
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/index.css" />
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/login.css" />
	<style type="text/css">
		body {
		    background-image:
		      url(${pageContext.request.contextPath}/resources/images/392452.png);
		    background-repeat: no-repeat;
		    background-size: cover;
		    position: relative;
	  	}
	</style>
</head>

<body>

      <nav class="container">
        <a href="${pageContext.request.contextPath}/">Very Good Cruise Company</a>
        <div id="rightContainer">
            <a href="${pageContext.request.contextPath}/login">Login</a>
            <a href="${pageContext.request.contextPath}/register">Register</a>
        </div>
    </nav>


<div id="container" class="login">
		<h1>Login
        	<hr>
      	</h1>
		<form:form action="validateCustomer" modelAttribute="customer" method="POST" id="loginInputContainer">		
			<table>
				<tbody>
					<tr>
						<td><form:input class="loginInput" path="email" placeHolder="Email"/></td>
					</tr>
					<tr>
						<td><form:input class="loginInput" path="password" placeHolder="Password"/></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input id="loginButton" type="submit" value="Login" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<div style="clear; both;"></div>
	</div>

</body>

</html>


