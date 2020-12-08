<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper">
	<h3>${param.message}</h3>
	<form action="Logincontroller" method="post">
    <div class="container">
      <label for="usernameId"><b>Enter username</b></label>
      <input type="text" placeholder="Enter Username" name="username" id="usernameId"required>
		<br>
      <label for="passwordId"><b>Enter password</b></label>
      <input type="password" placeholder="Enter Password" name="password" id="passwordId" required>
        <br>
      <button type="submit">Login</button>
    </div>
  </form>
 </div>
</body>
</html>
