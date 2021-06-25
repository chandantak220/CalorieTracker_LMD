<jsp:include page='common/jsp/Include.jsp' />
<html>
<head>
<title>Welcome to Calorie Tracker</title>
<script src="/js/common.js"></script>
</head>

<body onload="">

	<div class="p-3 mb-2 bg-light text-dark center">
		<h1>Welcome To Calorie Tracker Application</h1>
	</div>
	<div class="p-3 mb-2 bg-success text-white center">
		<h2>Import Data</h2>
	</div>
	
	<div id="drag-and-drop-preview" class="container">
	
   <form id="uploadData" action="" method="POST" enctype="multipart/form-data" novalidate="novalidate" data-fv-no-icon="true" class="form-horizontal has-validator fv-plugins-bootstrap fv-plugins-framework">
   <div class="form-group row justify-content-end">
         <label for="username" class="col-sm-4 col-form-label">Upload Food Data File </label><small>(.xls)</small>
         <div class="col-sm-7"><input id="foodData" name="uploadFile" accept=".xls" form="userForm" type="file" class="form-control" maxlength="30"></div>
      </div>
      <div class="form-group row justify-content-end">
         <label for="weight" class="col-sm-4 col-form-label">Upload Activity Data File </label><small>(.xls)</small>
         <div class="col-sm-7"><input id="activityData" name="uploadFile" type="file" accept=".xls" class="form-control"></div>
      </div>
      <div class="form-group row text-center justify-content-end">
         <div class=" col-sm-12">
            <div class="btn-group">
				<button type="reset" name="btn-group-1-button-1" value="" id="resetButton" class="btn btn-warning">Reset</button>
				<button type="button" form="userForm" name="btn-group-1-button-2" id="uploadButton" value="" class="btn btn-primary" onclick="uploadData('uploadData','uploadFile')">Upload Data</button>
				<button type="button" form="userForm" name="btn-group-1-button-2" id="homePageButton" value="" class="btn btn-success" onclick="openHomePage()">Go to HomePage</button>
			</div>
         </div>
      </div>
   </form>
   </div>
</body>
</html>