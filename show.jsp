<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<h2>Welcome ${sessionScope.user.username}!</h2> <br>
<div class="links">
	
	<a href="BookController.do?action=addbook">add new book</a>
	
	<c:if test="${user.profile == 'admin'}">
	<a href="UserManagementController.do?action=adduser">add new user</a>
	</c:if>
	
	<a href="Logoutcontroller">Logout</a>
</div>


<table>
	<tr>
		<th>id</th>
		<th>isbn</th>
		<th>title</th>
		<th>author</th>
		<th>publish date</th>
		<th>price</th>
		<c:if test="${user.profile == 'admin' || user.profile == 'mgr'}">
		<th>Update</th>
		</c:if>
		
		<c:if test="${user.profile == 'admin'}">
		<th>Delete</th>
		</c:if>
		
	</tr>
	<c:forEach var="book" items="${books}">
	
	<tr>
		<td>${book.id}</td>
		<td><c:out value="${book.isbn}"></c:out> </td>
		<td><c:out value="${book.title}"></c:out> </td>
		<td><c:out value="${book.author}"></c:out> </td>
		<td><c:out value="${book.pubDate}"></c:out> </td>
		<td><c:out value="${book.price}"></c:out> </td>
		
		<c:if test="${user.profile == 'admin' || user.profile == 'mgr'}">
		<td><a href="BookController.do?action=updatebook&id=${book.id}">Update</a></td>
		</c:if>
		<c:if test="${user.profile == 'admin'}">
		<td><a href="BookController.do?action=deletebook&id=${book.id}">Delete</a></td>
		</c:if>
	</tr>
	</c:forEach>
</table>
</body>
</html>


