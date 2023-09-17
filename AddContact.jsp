<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contacts</title>
</head>
<body>
<h2><a href="DisplayContact">Contacts</a> - Add A Contact</h2>
<form action="AddContact" method="post">
<table border="1">
<tr>
<th>Name:</th>
<td><input type="text" name="name"></td>
</tr>
<tr>
<th>Phone:</th>
<td><input type="text" name="phone"></td>
</tr>
<tr>
<td colspan="2"><button>Add</button></td>
</tr>
</table>
</form>
</body>
</html>