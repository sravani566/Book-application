<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding Book</title>
<style>
body {font-family: Arial}
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

<form action="BookController.do" method="post">
<input type="hidden" name="id" value="0" readonly>
      
	  <table>
	  	<tr>
	  		<td><label for="isbnId"><b>Enter ISBN:</b></label></td>	
	  		<td><input type="text" name="isbn" id="isbnId"required></td>
	  	</tr>
	  	
	  	<tr>
	  		<td><label for="titleId"><b>Enter title:</b></label></td>	
	  		<td><input type="text" name="title" id="titleId"required></td>
	  	</tr>
	  	
	  	<tr>
	  		<td><label for="authorId"><b>Enter author name:</b></label></td>	
	  		<td><input type="text" name="author" id="authorId"required></td>
	  	</tr>
	  	
		  	
	  	<tr>
	  		<td><label for="priceId"><b>Enter price:</b></label></td>	
	  		<td><input type="text" name="price" id="priceId" required></td>
	  	</tr>
	  	
	  	<tr>
	  		
	  		<td><button type="submit">add book</button></td>
	  	</tr>
    </table>
</form>
</body>
</html>
