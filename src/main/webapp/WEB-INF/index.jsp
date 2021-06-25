<jsp:include page='common/jsp/Include.jsp' />

<html>
<head>
<title>Welcome to Calorie Tracker</title>
<script src="/js/common.js"></script>
</head>

<body onload="setDate(null)">

	<div class="p-3 mb-2 bg-light text-dark center">
		<h1>Welcome To Calorie Tracker Application</h1>
	</div>
	<div class="p-3 mb-2 bg-success text-white center">
		<h2>User Information Form</h2>
	</div>
	
	<div id="drag-and-drop-preview" class="container">
	
   <form id="userForm" action="" method="POST" novalidate="novalidate" data-fv-no-icon="true" class="form-horizontal has-validator fv-plugins-bootstrap fv-plugins-framework">
      <div><input name="fg-form-token" type="hidden" value="178253882660cd9168cd9f14.74051513"><input name="fg-form" type="hidden" value="1"></div>
      <div class="form-group row justify-content-end">
         <label for="username" class="col-sm-4 col-form-label">User Name</label>
         <div class="col-sm-8"><input id="username" name="username" form="userForm" type="text" value="" placeholder="Enter Full Name" style="text-align:right;" class="form-control" maxlength="30"></div>
      </div>
      <div class="form-group row justify-content-end">
         <label for="weight" class="col-sm-4 col-form-label">Weight(in Kg)</label>
         <div class="col-sm-8"><input id="weight" name="weight" type="text" placeholder="Enter Weight in Kilograms" class="form-control" style="text-align:right;" onkeypress="return isValidNumber_NewBrowser(event);" maxlength="3"></div>
      </div>
      <div class="form-group row justify-content-end">
         <label for="height" class="col-sm-4 col-form-label">Height (in cm)</label>
         <div class="col-sm-8"><input id="height" name="height" type="text" value="" placeholder="Enter Height in centimeters" class="form-control" maxlength="3" style="text-align:right;" onkeypress="return isValidNumber_NewBrowser(event);"></div>
      </div>
      <div class="form-group row justify-content-end">
         <label class="main-label col-sm-4 col-form-label">Gender</label>
         <div class="col-sm-8">
            <div class="form-check form-check-inline"><input type="radio" id="Gender_0" name="gender" value="M" class="form-check-input"><label for="Gender_0" class="form-check-label">Male</label></div>
            <div class="form-check form-check-inline"><input type="radio" id="Gender_1" name="gender" value="F" class="form-check-input"><label for="Gender_1" class="form-check-label">Female</label></div>
         </div>
      </div>
      <div class="form-group row justify-content-end">
         <label for="dob" class="col-sm-4 col-form-label">Date of Birth</label>
         <div class="col-sm-4"><input id="dob" name="dob" type="date" value="" placeholder="Enter Date of Birth" class="form-control" onblur="ageCalculation('dob','currentDate','age')"></div>
		 <label for="dob" class="col-sm-2 col-form-label">Your Age</label>
		  <div class="col-sm-2"><input id="age" name="age" type="text" value="" placeholder="Age" class="form-control" readOnly="true"></div>
      </div>
      <div class="form-group row text-center justify-content-end">
         <div class=" col-sm-12">
            <div class="btn-group">
				<button type="reset" name="btn-group-1-button-1" value="" class="btn btn-warning">Reset</button>
				<button type="button" form="userForm" name="btn-group-1-button-2" value="" class="btn btn-primary" onclick="checkValidationsAndSave(userForm)">Submit</button>
				<button type="button" form="userForm" name="btn-group-1-button-2" value="" class="btn btn-success" onclick="openHomePage()">Go to HomePage</button>
			</div>
         </div>
      </div>
      <div></div>
      <input type="hidden" id="currentDate">
   </form>
</div>
</body>

</html>