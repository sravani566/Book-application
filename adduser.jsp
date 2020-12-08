<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add user</title>
<style type="text/css">
input[type=text], input[type=password] {
  width: 400px;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 50px;
  margin: 8px 10px;
  border: none;
  cursor: pointer;
  width: 200px;
}
button:hover {
  opacity: 0.8;
}
.container {
  padding: 16px;
}
span.psw {
  float: right;
  padding-top: 16px;
}
</style>

</head>
<body>
<form action="Usercontroller.do" method="post">
<input type="hidden" name="id" value="0" readonly>
	
	
	<table>
		<tr>
			<td>Enter username:</td>
			<td><input type="text" name="username"></td>
		</tr>
		
		<tr>
			<td>Enter password:</td>
			<td><input type="text" name="password"></td>
		</tr>	
		
		<tr>
			<td>Choose profile:</td>
			
			
			<td><select name="profile" id="profileId">
			  <option value="" selected="selected" disabled="disabled">Slect one option</option>
			  <option value="admin">admin</option>
			  <option value="mgr">mgr</option>
			  <option value="emp">emp</option>
			</select> </td>
		</tr>
		
		<tr>
			<td><button type="submit">add user</button></td>
		</tr>
	</table>
	
	
</form>
</body>
</html>
