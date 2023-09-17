<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contacts</title>
</head>
<body>
<h2>Contacts</h2>
<p><a href="AddContact">Add a Contact</a></p>
<table border="1">
<c:forEach items="${contacts}" var="contact">
<tr>
<td><a href="ContactList?id=${contact.id}">${contact.name}</a></td>
<td>${contact.phone}</td>
</tr>
</c:forEach>
</table>
</body>
</html>