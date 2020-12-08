<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="BookController.do" method="post">

	<input type="hidden" name="id" value="${book.id}" readonly>
      
	  <table>
	  	<tr>
	  		<td><label for="isbnId"><b>Enter ISBN:</b></label></td>	
	  		<td><input type="text" name="isbn" value="${book.isbn}" readonly></td>
	  	</tr>
	  	
	  	<tr>
	  		<td><label for="titleId"><b>Enter title:</b></label></td>	
	  		<td><input type="text" name="title" value="${book.title }" readonly></td>
	  	</tr>
	  	
	  	<tr>
	  		<td><label for="authorId"><b>Enter author name:</b></label></td>	
	  		<td><input type="text" name="author" value="${book.author}" readonly></td>
	  	</tr>
	  	
	  
	  	
	  	<tr>
	  		<td><label for="priceId"><b>Enter price:</b></label></td>	
	  		<td><input type="text" name="price"  value="${book.price}"></td>
	  	</tr>
	  	
	  	<tr>
	  		
	  		<td><button type="submit">update book</button></td>
	  	</tr>
    </table>
</form>
</body>
</html>

