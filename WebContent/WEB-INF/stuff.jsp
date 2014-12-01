<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>David's AppDirect demo</title>
</head>
<body>
	<h1>Subscribers List</h1>
	<table>
		<th>Account identifier</th>
		<th>Status</th>
		<th>Edition</th>
	</table>

	<c:forEach items="${UserAccounts.getAccounts()}" var="userAccount">
		<tr>
			<td>${userAccount.id}</td>
			<td>${userAccount.status}</td>
			<td>${userAccount.edition}</td>
		</tr>
	</c:forEach>
</body>
</html>