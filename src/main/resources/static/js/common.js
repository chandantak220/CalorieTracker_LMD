var appcontext = "http://localhost:8080";
function openHomePage()
{
	document.forms[0].action="/";
	document.forms[0].submit();
}
function setDate(sDate)
{
	var date="";
	var today = null;
	if(sDate==null)
	{
		today = new Date();
	}
	else
	{
		date = document.getElementById(sDate).value;
		today = new Date(date);
	}
	var dd = String(today.getDate()).padStart(2, '0');
	var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
	var yyyy = today.getFullYear();

	today = dd + '/' + mm + '/' + yyyy;
	if(sDate==null)
	{
		document.getElementById("currentDate").value=today;
	}
	else
	{
		return today;
	}
}
function isValidNumber_NewBrowser(evt) { 	
          
        // Only ASCII charactar in that range allowed 
        var ASCIICode = (evt.which) ? evt.which : evt.keyCode 
        if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57)) 
            return false; 
        return true; 
}

function ageCalculation(dob,TodayDate,storefield)
{
 var Year = 0;
 var dOB = document.getElementById(dob).value;
 if(dOB.substring(4,5)=="-")
 {
	dOB=setDate(dob);
 }
 var cDate=document.getElementById(TodayDate).value;
 var CYear =cDate.substring(6,10);
 var dOBYear = dOB.substring(6,10);
 Year = (CYear - dOBYear);

 var CMonth = cDate.substring(3,5);
 var dOBMnth = dOB.substring(3,5);

 var CDay = cDate.substring(0,2);
 var bDay = dOB.substring(0,2);

     if (CMonth > dOBMnth) {
         Year--;
     }
     else if (CMonth === dOBMnth) {
         if (CDay < bDay) {
             Year--;
         }
     }
document.getElementById(storefield).value=Year;
}
function sendData()
{
	document.forms[0].action="/saveUser";
	document.forms[0].method="POST";
	document.forms[0].submit();
}
function OpenPage(sOpen)
{
	if(sOpen=="AddUser")
	{
		document.forms[0].action="/addUserPage";
		document.forms[0].method="POST";
		document.forms[0].submit();
	}
	else if(sOpen=="FetchUser")
	{
		document.forms[0].action="/fetchUserPage";
		document.forms[0].method="POST";
		document.forms[0].submit();
	}
	else if(sOpen=="ImportData")
	{
		document.forms[0].action="/importData";
		document.forms[0].method="POST";
		document.forms[0].submit();
	}
}
function loadUsersData()
{
	var settings = {
			url: "http://localhost:8080/User/fetchAll",
			method: "POST",
			timeout: 0,
			headers: {
		"Content-Type": "application/json; charset=utf-8",
		"Access-Control-Allow-Origin": "*"
	},
			data: null,
	};

	$.ajax(settings).done().always(function(response){
		if(response!=null && response.length>=1)
		{
			var tbody =document.getElementById("dataBody");
			var tr,newCell,newText;
			for(var i=0;i<response.length;i++) {
				
				tr = document.createElement("TR");
				newCell = tr.insertCell(0);
				newText = document.createTextNode(response[i].id);
				newCell.appendChild(newText);
				newCell.setAttribute("id",response[i].id);
				
				newCell = tr.insertCell(1);
				newText = document.createTextNode(response[i].username);
				newCell.appendChild(newText);
				
				newCell = tr.insertCell(2);
				newText = document.createTextNode(response[i].weight);
				newCell.appendChild(newText);
				
				newCell = tr.insertCell(3);
				newText = document.createTextNode(response[i].height);
				newCell.appendChild(newText);
				
				newCell = tr.insertCell(4);
				newText = document.createTextNode(response[i].age);
				newCell.appendChild(newText);
				
				var button = document.createElement("button");
				var buttonText = document.createTextNode("Delete");
				button.appendChild(buttonText);
				button.setAttribute('type','button');
				button.setAttribute('onclick', 'DeleteRow('+response[i].id+')');
				button.classList.add("btn");
				button.classList.add("btn-danger");
				newCell = tr.insertCell(5);
				newCell.style.textAlign="right";
				newCell.style.width="399px";
				newCell.appendChild(button);
				
				var button = document.createElement("button");
				var buttonText = document.createTextNode("Edit Food Details");
				button.appendChild(buttonText);
				button.setAttribute('type','button');
				button.setAttribute('onclick', 'OpenFoodDetails('+response[i].id+')');
				button.classList.add("btn");
				button.classList.add("btn-primary");
				newCell.appendChild(button);
				
//				var button = document.createElement("button");
//				var buttonText = document.createTextNode("Show Food Details");
//				button.appendChild(buttonText);
//				button.setAttribute('type','button');
//				button.setAttribute('onclick', 'OpenFoodDetails('+response[i].id+')');
//				button.classList.add("btn");
//				button.classList.add("btn-success");
//				newCell.appendChild(button);
				
				tbody.append(tr);
				
			}
		}
		else
		{
			alert("No Data Retrieved");
		}
	}
			);
	
}
function OpenFoodDetails(id)
{
	
	window.open(appcontext+"/User/fillFoodDetails/"+id,"Fill Food Details", "width=1280,height=768");
	return false;
}
function DeleteRow(id)
{
	var settings = {
			url: "http://localhost:8080/User/delete/"+id,
			method: "POST",
			timeout: 0,
			headers: {
		"Content-Type": false
	},
			data: null,
	};

	$.ajax(settings).done().always(function(response){
		if(response!=null)
		{
			alert("Data Successfully Deleted");
			window.location.reload(response.responseText);
		}
		else
		{
			alert("An Error Occur in Deletion");
		}
	}
			);
}
function checkValidationsAndSave(form)
{
	var username = document.getElementById("username").value;
	var dob = document.getElementById("dob").value;
	var age = document.getElementById("age").value;
	var height = document.getElementById("height").value;
	var weight = document.getElementById("weight").value;
	var gender = document.getElementsByName("gender");
	
	if(username==null || username=="")
	{
		alert("Please fill UserName");
		return false;
	}
	else if (weight==null || weight=="")
	{
		alert("Please fill Weight");
		return false;
	}
	else if (height==null || height=="")
	{
		alert("Please fill Height");
		return false;
	}
	else if (gender[0].checked==false && gender[1].checked==false)
	{
		alert("Please fill Gender");
		return false;
	}
	else if (dob==null || dob=="")
	{
		alert("Please fill Date of Birth");
		return false;
	}
	else if (age==null || age=="")
	{
		alert("Please fill Age");
		return false;
	}
	else
	{
		getjson(form);
	}

}
function getjson( form )
{	
    var jsonstr='{';
    var data = JSON.stringify( $(form).serializeArray() );
    var obj = $.parseJSON(data);
    $(obj).each(function () {
    jsonstr=jsonstr+'"'+this.name+'":"'+this.value+'",'
      });
    jsonstr += "}";
    jsonstr = jsonstr.replace(',}','}');
    sendData(jsonstr);
}
function sendData(jsonData)
{
		 var settings = {
		   url: "http://localhost:8080/User/save",
		   method: "POST",
		   timeout: 0,
		   headers: {
		   "Content-Type": "application/json; charset=utf-8",
		   "Access-Control-Allow-Origin": "*"
		   },
		   data: jsonData,
		 };
		
		 $.ajax(settings).done().always(function(response){
			 if(response.readyState == 4 && (response.status==200 || response.status==201))
			 {
				 alert("Response is --"+response.responseText);
				 location.reload();
			 }
			 else
			 {
				 alert("Error in Data Save - "+response.statusText);
			 }
		 }
	 );
}
function uploadData(form,fileId)
{
	var fileInput = document.getElementsByName(fileId);
	if(fileInput[0].files.length==0 && fileInput[1].files.length==0)
	{
		alert("Please select at least one file..");
		return false;
	}
	var form1 = new FormData($('#'+form)[0]);
	for(var i=0;i<fileInput.length;i++)
	{
		if(fileInput[i].files.length!=0)
		form1.append("formFile[]", fileInput[i].files[0]);
	}
	document.getElementById("uploadButton").disabled=true;
	document.getElementById("resetButton").disabled=true;
	document.getElementById("homePageButton").disabled=true;
	var settings = {
	  "url": "http://localhost:8080/Import/fileUpload",
	  "method": "POST",
	  "timeout": 0,
	  "processData": false,
	  "mimeType": "multipart/form-data",
	  "contentType": false,
	  "data": form1
	};

	$.ajax(settings).done().always(function (response) {
		if(response=="failure")
		{
			alert("Error in File Import");
			document.getElementById("uploadButton").disabled=false;
			document.getElementById("resetButton").disabled=false;
			document.getElementById("homePageButton").disabled=false;
		}
		else if (response == "success")
		{
			alert("File Successfully Uploaded");
			document.getElementById("uploadButton").disabled=false;
			document.getElementById("resetButton").disabled=false;
			document.getElementById("homePageButton").disabled=false;
			document.getElementById("resetButton").click();
		}
		else if (response == "invalid")
		{
			alert("File Not Valid....Cannot Upload");
			document.getElementById("uploadButton").disabled=false;
			document.getElementById("resetButton").disabled=false;
			document.getElementById("homePageButton").disabled=false;
		}
		else
		{
			alert(response);
		}
	 
	});
}
// code for saving food Data from below
var outRowCount=0;
var inRowCount=0;
function LoadFoodData(inRowCount1,sMode){
	if(sMode=='IN')
	{
		var food = document.getElementById("foodList").value;
		food = food.replace("[", "");
		food = food.replace("]", "");
		var foodList = food.split(",");
		var selectField = document.getElementById("foodData" + inRowCount1);
		for (var i = 0; i < foodList.length; i++) {
			var option = document.createElement("option");
			var optionText = document.createTextNode(foodList[i]);
			option.appendChild(optionText);
			option.setAttribute('value', foodList[i]);
			selectField.appendChild(option);
		}
	}
	else if (sMode=='OUT')
	{
		var ActList = document.getElementById("ActList").value;
		ActList = ActList.replace("[", "");
		ActList = ActList.replace("]", "");
		var activityList = ActList.split(",");
		var selectField = document.getElementById("ActivityData" + inRowCount1);
		for (var i = 0; i < activityList.length; i++) {
			var option = document.createElement("option");
			var optionText = document.createTextNode(activityList[i]);
			option.appendChild(optionText);
			option.setAttribute('value', activityList[i]);
			selectField.appendChild(option);
		}
	}
	}
	function fetchData(data, icount , sMode) {
		if (icount == "inRowCount" || icount == "outRowCount") {
			icount = 0;
		}
		var settings = {
			url : "http://localhost:8080/User/fetchDetails/" + data+"~"+sMode,
			method : "POST",
			timeout : 0,
			headers : {
				"Content-Type" : "application/json; charset=utf-8",
				"Access-Control-Allow-Origin" : "*"
			},
			data : null,
		};

		$.ajax(settings).done().always(function(response) {
					if (response != null) {
						response = JSON.parse(response);
						if(sMode=="Food")
						{
							var foodName = document.getElementById("foodName"+ icount);
							removeAll(foodName);
							//Add the Options to the DropDownList.
							for (var i = 0; i < response.length; i++) {
								var option = document.createElement("option");
								var optionText = document.createTextNode(response[i].foodName);
								option.appendChild(optionText);
								option.setAttribute("value", response[i].foodName);
								option.setAttribute("id", response[i].foodCalories);
								foodName.appendChild(option);
						}
						}
						else if (sMode=="Activity")
						{
							var activityName = document.getElementById("ActivityName"+ icount);
							removeAll(activityName);
							//Add the Options to the DropDownList.
							for (var i = 0; i < response.length; i++) {
								var option = document.createElement("option");
								var optionText = document.createTextNode(response[i].activityName);
								option.appendChild(optionText);
								option.setAttribute("id", response[i].id);
								option.setAttribute("value", response[i].activityName);
								activityName.appendChild(option);
						}
						}	
						
					}

				});
	}
	function removeAll(selectBox) {
		while (selectBox.options.length > 0) {
			selectBox.remove(0);
		}
	}
	function addRowIn() {
		inRowCount++;
		$('#dataBodyIn tbody').append('<tr id="food'+inRowCount+'" style="overflow:auto;"><td scope="col" style="text-align: center;position: relative;"> <input type="checkbox" name="chkin" id="chkin'+inRowCount+'" class="form-check-input" /> </td><td scope="col" style="width:150px"><select id="foodData'+ inRowCount + '" name="foodData" class="form-control" onchange="fetchData(this.value,\''+ inRowCount+ '\',\'Food\')"></select></td><td scope="col" style="width:175px"><select id="foodName'+inRowCount+'" name="foodName" class="form-control" onchange="setCalories(this,\''+inRowCount+'\')" ></select></td><td scope="col"><select id="foodTime'+inRowCount+'" name="foodTime" class="form-control"><option value="B">BreakFast</option><option value="L">Lunch</option><option value="S">Snack</option><option value="D">Dinner</option></select></td><td scope="col" style="width: 115px;"><input type="text" name="calories" id="calories'+inRowCount+'" style="text-align:right;" readOnly=true value="0.0" class="form-control"/></td><td scope="col"><div style="text-align:right;"><button type="button" name="removeRow" id="removeRow'+inRowCount+'"  class="btn btn-danger" onclick="deleteRow('+inRowCount+',\'food\')">DeleteRow</button></div></td></tr>');
		LoadFoodData(inRowCount, 'IN');

	}
	function addRowOut() {
		outRowCount++;
		$('#dataBodyOut tbody').append('<tr id="activity'+outRowCount+'"><td scope="col" style="text-align: center;position: relative;"> <input type="checkbox" name="chkout" id="chk'+outRowCount+'" class="form-check-input" /> </td><td scope="col" style="width:150px"><select id="ActivityData'+outRowCount+'" name="ActivityData" class="form-control" onchange="fetchData(this.value,\''+ outRowCount+ '\',\'Activity\')" ></select></td><td scope="col" style="width:175px"><select id="ActivityName'+outRowCount+'" name="ActivityName" class="form-control" onchange="setMetValue(this)" ></select></td><td scope="col" style="width:162px;"><input type="text" id="ActivityDuration'+outRowCount+'" name="ActivityDuration" onblur="calculateCalories(this,\'gender\',\'weight\',\'height\',\'age\',\''+outRowCount+'\')" class="form-control"/></td><td scope="col" style="width: 115px;"><input type="text" name="actcalories" id="actcalories'+outRowCount+'" style="text-align:right;" readOnly=true class="form-control" value = "0.0" /></td><td scope="col"><div style="text-align:right;"><button type="button" name="removeRow" id="removeRow'+outRowCount+'" class="btn btn-danger" onclick="deleteRow('+outRowCount+',\'activity\')">DeleteRow</button></div></td></tr>');
		LoadFoodData(outRowCount, 'OUT');
	}
	function deleteRow(rowNo,sMode)
	{
		if(rowNo!=0)
		{
			if(sMode=="food")
			{
				var totalCaloriesIn = parseFloat(document.getElementById("totalInCalories").value); 
				var caloriesin = parseFloat(document.getElementById("calories"+rowNo).value);
				totalCaloriesIn = totalCaloriesIn - caloriesin;
				inRowCount--;
				document.getElementById("totalInCalories").value = totalCaloriesIn;
			}
			else if (sMode=="activity")
			{
				var totalCaloriesOut = parseFloat(document.getElementById("totalOutCalories").value); 
				var caloriesOut = parseFloat(document.getElementById("actcalories"+rowNo).value);
				totalCaloriesOut = totalCaloriesOut - caloriesOut;
				outRowCount--;
				document.getElementById("totalOutCalories").value = totalCaloriesOut;
			}
			$('#'+sMode+rowNo).remove(); 
		}
	}
function setCalories(value,iCount)
{
	value = parseFloat(value.options[value.selectedIndex].id);
	if(iCount=="inRowCount")
		iCount=0;
	var caloriesIn = parseFloat(document.getElementById("calories"+iCount).value);
	var totalInCalories = parseFloat(document.getElementById("totalInCalories").value);
	totalInCalories = totalInCalories - caloriesIn;
	totalInCalories = totalInCalories + value;
	document.getElementById("totalInCalories").value = totalInCalories;
	document.getElementById("calories"+iCount).value=value;
}
function saveData()
{
	calculateNetCalories();
	if(document.getElementById("foodDate").value==null || document.getElementById("foodDate").value=="")
	{
		alert("Please Fill Date");
		return false;
	}
	else if((document.getElementById("totalInCalories").value==null || parseFloat(document.getElementById("totalInCalories").value)==0.0) &&
			(document.getElementById("totalOutCalories").value==null || parseFloat(document.getElementById("totalOutCalories").value)==0.0))
	{
		alert("Please Enter At Least One Data ");
		return false;
	}
	var jsonstr='{';
    var data = JSON.stringify( $('form').serializeArray() );
    var obj = $.parseJSON(data);
    $(obj).each(function () {
    jsonstr=jsonstr+'"'+this.name+'":"'+this.value+'",'
      });
    jsonstr += "}";
    jsonstr = jsonstr.replace(',}','}');
   
	var settings = {
			url : "http://localhost:8080/User/saveAllUserFoodData",
			method : "POST",
			timeout : 0,
			headers : {
				"Content-Type" : "application/json; charset=utf-8",
				"Access-Control-Allow-Origin" : "*"
			},
			data : jsonstr,
		};

		$.ajax(settings).done().always(function(response) {
			if(response=="success")
			{
				alert("Data Save Successfully");
				location.reload();
			}
			else
			{
				alert("Error in Data Save");
			}
			});
}
function setMetValue(activity)
{
	activity = activity.options[activity.selectedIndex].id;
	document.getElementById("met").value=activity;
}
function calculateBMR(gender,weight,height,age)
{
	gender = document.getElementById(gender).value.trim();
	weight = parseInt(document.getElementById(weight).value.trim());
	height = parseInt(document.getElementById(height).value.trim());
	age = parseInt(document.getElementById(age).value.trim());
	var bmr = "";
	if(gender=="M")
	{
		bmr = 66.4730 + (13.7516 * weight) + (5.0033 * height) - (6.7550 * age);
	}
	else if (gender=="F")
	{
		bmr = 655.0955 + (9.5634 * weight) + (1.8496 * height) - (4.6756 * age);
	}
	document.getElementById("bmr").value=parseFloat(bmr);
}
function calculateCalories(duration,gender,weight,height,age,outRowCount)
{
	weight = document.getElementById(weight).value.trim();
	var bmr = "";
	var caloriesout="";
	if(outRowCount=="outRowCount")
		outRowCount=0;
	var metValue = document.getElementById("met").value;
	duration = duration.value;
	caloriesout = parseFloat((metValue * weight * duration).toFixed(2));
	totalOutCalory = parseFloat(document.getElementById("totalOutCalories").value);  
	oldcaloriesout = parseFloat(document.getElementById("actcalories"+outRowCount).value);
		totalOutCalory = totalOutCalory - oldcaloriesout;
		totalOutCalory = totalOutCalory + caloriesout;
	document.getElementById("totalOutCalories").value = totalOutCalory;
	document.getElementById("actcalories"+outRowCount).value=caloriesout;
}
function calculateNetCalories()
{
	var totalInCalories = parseFloat(document.getElementById("totalInCalories").value);
	var totaloutCalories = parseFloat(document.getElementById("totalOutCalories").value);
	var bmr = parseFloat(document.getElementById("bmr").value);
	document.getElementById("netCalories").value = (totalInCalories - bmr - totaloutCalories).toFixed(2);
}