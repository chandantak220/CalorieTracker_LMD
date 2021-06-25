<jsp:include page='common/jsp/Include.jsp' />
<html>
<head>
<title>List of Users</title>
<script src="/js/common.js"></script>
</head>
<body class="center" onload="loadUsersData()">
	<form action="/User/FetchAll" method="POST">
		<div class="p-3 mb-2 bg-light text-dark">
			<h1>Welcome To Calorie Tracker Application</h1>
		</div>
		<div class="p-3 mb-2 bg-success text-white">
			<h2>Here are the saved Users Information</h2>
		</div>
		<div class=" col-sm-12">
            <div class="btn-group"><button type="button" form="userForm" name="btn-group-1-button-2" value="" class="btn btn-success" onclick="openHomePage()">Go to HomePage</button></div>
            </div>
        
		<table class="table">
			<thead>
				<tr>
					<th scope="col">UserID.</th>
					<th scope="col">User Name</th>
					<th scope="col">Weight</th>
					<th scope="col">Height</th>
					<th scope="col">Age</th>
					<th scope="col"></th>
					
				</tr>
			</thead>
			<tbody id="dataBody">
			</tbody>
		</table>
	</form>
</body>