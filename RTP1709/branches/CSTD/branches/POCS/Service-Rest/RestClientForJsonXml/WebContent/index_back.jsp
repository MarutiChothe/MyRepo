<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="jquery-2.1.1.min.js" ></script>
<script type="application/javascript">
function loadJSON()
{  
	var data_file = "http://localhost:8080/EmployeeJAXRSRestService/rest/employees";
	$.getJSON(data_file,function(data){
		//var jsonObj = JSON.parse(data);
		processJson(data);
	});
	/* $.getJSON(data_file,function(result){
		var jsonObj = JSON.parse(result);
		processJson(jsonObj);
	}); */
}

function processJson(jsonObj){
	if(jsonObj == null || jsonObj.employee == null || jsonObj.employee == undefined){
		document.getElementById("contnt").innerHTML = "There are some issues while retrieving result / No Result found";
	}else if(jsonObj.employee != null && jsonObj.employee[0] != null){
		var result = "";
		var count = jsonObj.employee.length;
		for(i = 0; i < count; i++){
			result = result+"<br/><br/><br/><span>FirstName: "+jsonObj.employee[i].firstName+"</span>"+"<br/><span>LastName: "+jsonObj.employee[i].lastName+"</span>";
		}
		document.getElementById("contnt").innerHTML = result;
	}else if(jsonObj.employee != null){
		var result = "<br/><br/><br/><span>FirstName: "+jsonObj.employee.firstName+"</span>"+"<br/><span>LastName: "+jsonObj.employee.lastName+"</span>";
		document.getElementById("contnt").innerHTML = result;
	}else{
		document.getElementById("contnt").innerHTML = "No Result found";
	}
}
</script>


<title>Insert title here</title>
</head>
<body>


<div id="contnt">
		no content here
</div>

<input type="button" value="submit" onclick="{loadJSON()}" />

</body>
</html>