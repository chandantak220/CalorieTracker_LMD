<jsp:include page='common/jsp/Include.jsp' />
<html>
<head>
<title>Fill Food Details Here</title>
<script src="/js/common.js"></script>
<script type="text/javascript">
</script>
</head>

<body onload="LoadFoodData(0,'IN'),LoadFoodData(0,'OUT'),calculateBMR('gender','weight','height','age');">
	<div class="p-3 mb-2 bg-success text-white center">
		<h2>Fill Food Details Here</h2>
	</div>

	<div id="drag-and-drop-preview" class="container">
		<form id="foodDetailsForm" action="" method="POST"
			novalidate="novalidate" data-fv-no-icon="true"
			class="form-horizontal has-validator fv-plugins-bootstrap fv-plugins-framework">
			<div class="form-group row justify-content-end">
				<label for="username" class="col-sm-6 col-form-label">User Name</label>
				<div class="col-sm-6">
					<input id="username" name="username" form="foodDetailsForm"
						type="text" value="${username}" placeholder="Enter Full Name"
						class="form-control" maxlength="30" readonly=true>
				</div>
			</div>
			<div class="form-group row justify-content-end">
				<label for="foodDate" class="col-sm-6 col-form-label">Select Date</label>
				<div class="col-sm-6">
					<input id="foodDate" name="foodDate" form="foodDetailsForm"
						type="date" placeholder="Enter Date" class="form-control"
						maxlength="30">
				</div>
			</div>
			<div class="form-group row justify-content-end">
					<label for="netCalories" class="col-sm-6 col-form-label">Net Calories</label>
				<div class="col-sm-3">
					<input id="netCalories" name="netCalories" form="foodDetailsForm"
						type="text"  class="form-control" value="0.0" style="text-align:right" readOnly=true>
				</div>
				<div class="col-sm-3">
					<button form="foodDetailsForm" type="button" onclick="calculateNetCalories();" class="btn btn-info" >Calculate Net Calories</button>
				</div>
			</div>
			<h3>Calories In</h3>
			<div class="form-group row justify-content-end tableFixHead" style="height:350px">
			<table class="table" id="dataBodyIn">
			<thead>
				<tr>
					<th scope="col center">Selection</th>
					<th scope="col">Food Group</th>
					<th scope="col">Food Name</th>
					<th scope="col">Food Time</th>
					<th scope="col">Calories</th>
					<th scope="col"><input type="text" id="totalInCalories" name="totalInCalories" class="form-control" value="0.0" readOnly=true style="width: 100px; text-align:right;" /></th>
					<th scope="col" style="text-align:right;"><button type="button" name="addRow" id="addRow0" class="btn btn-primary" onClick="addRowIn()">AddRow(In)</button></th>
				</tr>
				
			</thead>
			<tbody>
				<tr id="food0" style="overflow:auto;">
					<td scope="col" style="text-align: center;position: relative;"> <input type="checkbox" name="chkin" id="chkin0" class="form-check-input"/> </td>
					<td scope="col" style="width:150px"><select id="foodData0" name="foodData" class="form-control" onchange="fetchData(this.value,'inRowCount','Food')"></select></td>
					<td scope="col" style="width:175px"><select id="foodName0" name="foodName" class="form-control" onchange="setCalories(this,'inRowCount')" ></select></td>
					<td scope="col"><select id="foodTime0" name="foodTime" class="form-control">
						<option value="B">BreakFast</option>
						<option value="L">Lunch</option>
						<option value="S">Snack</option>
						<option value="D">Dinner</option></select>
					</td>
					<td scope="col" style="width: 115px;"><input type="text" name="calories" id="calories0" style="text-align:right;" readOnly=true value="0.0" class="form-control"/></td>
					<td scope="col"><div style="text-align:right;">
								<!--<button type="button" name="addRow" id="addRow0" class="btn btn-primary" onClick="addRowIn()">AddRow </button>-->
								<button type="button" name="removeRow" id="removeRow0" class="btn btn-danger" onclick="deleteRow(0,'food')">DeleteRow</button>
								</div>
					</td>
				</tr>
			</tbody>
			</table>
			</div>
			<h3>Calories Out</h3>
			<div class="form-group row justify-content-end tableFixHead" style="height:350px">
			<table class="table" id="dataBodyOut">
			<thead>
				<tr>
					<th scope="col" class="center">Selection</th>
					<th scope="col">Activity Group</th>
					<th scope="col">Activities</th>
					<th scope="col">Duration<small> (in Hours)</small></th>
					<th scope="col">Calories</th>
					<th scope="col"><input type="text" id="totalOutCalories" name = "totalOutCalories" class="form-control" value="0.0" readOnly=true style="width: 100; text-align:right;" /></th>
					<th scope="col"> <button type="button" name="addRow" id="addRow0" class="btn btn-primary" onclick="addRowOut()">AddRow(Out)</button></th>
				</tr>
				
			</thead>
			<tbody>
				<tr id="activity0">
					<td scope="col" style="text-align: center;position: relative;"> <input type="checkbox" name="chkout" id="chkout0" class="form-check-input" /> </td>
					<td scope="col" style="width:150px"><select id="ActivityData0" name="ActivityData" class="form-control" onchange="fetchData(this.value,'outRowCount','Activity')"></select></td>
					<td scope="col" style="width:175px"><select id="ActivityName0" name="ActivityName" class="form-control" onchange="setMetValue(this)" ></select></td>
					<td scope="col" style="width:162px;"><input type="text" id="ActivityDuration0" name="ActivityDuration" onblur="calculateCalories(this,'gender','weight','height','age','outRowCount')" class="form-control" maxlength="2" onkeypress="return isValidNumber_NewBrowser(event);"/></td>
					<td scope="col" style="width: 115px;"><input type="text" name="actcalories" id="actcalories0" style="text-align:right;" value = "0.0" readOnly=true class="form-control"/></td>
					<td scope="col"><div style="text-align:right;">
								<button type="button" name="removeRow" id="removeRow0" class="btn btn-danger" onclick="deleteRow(0,'activity')">DeleteRow</button>
								</div>
					</td>
				</tr>
			</tbody>
			</table>
			</div>
			<div class="form-group row justify-content-end">
			<div class=" col-sm-12 center">
			<button type="button" id="btnSubmit" name="btnSubmit" class="btn btn-success" onclick="saveData()">Save</button>
			</div>
			</div>
			<input type="hidden" name="foodList" id="foodList"
				value="${foodList}" />
			<input type="hidden" name="ActList" id="ActList"
				value="${actList}" />
			<input type="hidden" name="gender" id="gender" value="${gender} "/>
			<input type="hidden" name="weight" id="weight" value="${weight} "/>
			<input type="hidden" name="height" id="height" value="${height} "/>
			<input type="hidden" name="age"    id="age"    value="${age} "/>
			<input type="hidden" name="userid"    id="userid"    value="${userid} "/>
			<input type="hidden" id="met"/>
			<input type="hidden" id="bmr"/>
		</form>
	</div>
</body>

</html>