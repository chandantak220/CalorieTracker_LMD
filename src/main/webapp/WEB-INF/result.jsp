<jsp:include page='common/jsp/Include.jsp' />
<html>
<head>
<title>Result Page</title>
<script src="/js/common.js"></script>
</head>
<body>
	<h1>Result</h1>
	<div class="form-group row justify-content-end">
     <label class="col-sm-3 col-form-label">UserName:</label>
     <div class="col-sm-3"><label >${userData.username}</label></div>
    <label class="col-sm-3 col-form-label">UserWeight:</label>
     <div class="col-sm-3"><label >${userData.weight}</label></div>
    </div>
        <a href="/addUserPage">Submit another message</a>
    
</body>
</html>