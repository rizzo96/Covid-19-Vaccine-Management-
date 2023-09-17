<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Contacts</title>
</head>
<body>
<c:forEach items="${contacts}" var="contact">
<input type="hidden" name="id" value="${contact.id}">
<h2><a href="DisplayContact">Contacts</a> - ${contact.name}</h2>
<form action="AddContact" method="post">
<table border="1">
<tr>
<th>Name</th>
<td>${contact.name}</td>
</tr>
<tr>
<th>Phone</th>
<td>${contact.phone}</td>
</tr>
<tr>
<td><input type="text" name="new"></td>
<td><input type="text" name="value"></td>
<td><button>Add</button></td>
</tr>
</table>
</form>
</c:forEach>
</body>
</html>