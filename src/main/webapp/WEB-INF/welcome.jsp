<jsp:include page='common/jsp/Include.jsp' />
<html>
<head>
<title>Welcome to Calorie Tracker</title>
<script src="/js/common.js"></script>
</head>
<body style="text-align:center;">
<form action="" method="POST">
	<div class="p-3 mb-2 bg-light text-dark"><h1>Welcome To Calorie Tracker Application</h1></div>
	<div class="p-3 mb-2 bg-success text-white"><h2>Click Below to proceed further</h2></div>
	
	<nav class="navbar navbar-expand-md" >
    <div class="collapse navbar-collapse" id="main-navigation">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="javascript:OpenPage('AddUser')">Add User</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="javascript:OpenPage('FetchUser')">Fetch Users List</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="javascript:OpenPage('ImportData')">Upload Food-Activity Data</a>
            </li>
        </ul>
    </div>
</nav>
</form>
</body>
