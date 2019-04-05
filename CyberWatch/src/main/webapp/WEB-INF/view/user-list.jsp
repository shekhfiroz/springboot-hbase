
<!DOCTYPE html>
<html>
<head>
<title>Users Listing</title>
</head>
<body>

	<h1>User Listing</h1>

	<div class="row-area" th:each="user ${userList}">
		<div class="column2 tariff-date" style="width: 20%;">
			<span th:text="${user.name}"></span>
		</div>
		<div class="column2 tariff-date" style="width: 20%;">
			<span th:text="${user.email}"></span>
		</div>
		<div class="column2 tariff-date" style="width: 20%;">
			<span th:text="${user.password}"></span>
		</div>
	</div>
</body>
</html>