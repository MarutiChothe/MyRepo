<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.book {
    border: 1px solid #000;
    float: left;
    height: 250px;
    margin: 10px;
    padding: 10px;
    width: 142px;
}
.book:hover {
    border: 1px solid #f00;
}
.book_img {
    height: 164px;
    width: 120px;
}
.btns_dv{
	clear:both;
}
</style>
<script type="application/javascript">
var det = 0;
var data_file = "http://localhost:8080/EmployeeJAXRSRestService/rest/employees";
function loadJSON(val)
{
	det = val;
	if(det == 1){
		data_file = "http://localhost:8080/EmployeeJAXRSRestService/rest/books";
	}else {
		data_file = "http://localhost:8080/EmployeeJAXRSRestService/rest/employees";
	}
   var http_request = new XMLHttpRequest();
   try{
      // Opera 8.0+, Firefox, Chrome, Safari
      http_request = new XMLHttpRequest();
   }catch (e){
      // Internet Explorer Browsers
      try{
         http_request = new ActiveXObject("Msxml2.XMLHTTP");
      }catch (e) {
         try{
            http_request = new ActiveXObject("Microsoft.XMLHTTP");
         }catch (e){
            // Something went wrong
            alert("Your browser broke!");
            return false;
         }
      }
   }
   http_request.onreadystatechange  = function(){
      if (http_request.readyState == 4  )
      {
        // Javascript function JSON.parse to parse JSON data
        var jsonObj = JSON.parse(http_request.responseText);
      	if(det == 1){
      		processJsonBook(jsonObj);
    	}else {
    		processJson(jsonObj);
    	}
      	
      }
   }
   http_request.open("GET", data_file, true);
   http_request.send();
}

/* function processJsonBook(jsonObj){
	if(jsonObj == null || jsonObj.book == null || jsonObj.book == undefined){
		document.getElementById("contnt").innerHTML = "There are some issues while retrieving result / No Result found";
	}else if(jsonObj.book != null && jsonObj.book[0] != null){
		var result = "";
		var count = jsonObj.book.length;
		for(i = 0; i < count; i++){
			result = result+
			"<br/><br/><br/><span>author: "+jsonObj.book[i].author+
			"</span>"+"<br/><span>img_url: <img src='"+jsonObj.book[i].img_url+"' width='100px' height='100px' /></span>";
		}
		document.getElementById("contnt").innerHTML = result;
	}else if(jsonObj.book != null){
		var result = "<br/><br/><br/><span>author: "+jsonObj.book.author+
		"</span>"+"<br/><span>img_url: "+jsonObj.book.img_url+"</span>";
		document.getElementById("contnt").innerHTML = result;
	}else{
		document.getElementById("contnt").innerHTML = "No Result found";
	}
} */


function processJsonBook(jsonObj){
	if(jsonObj == null || jsonObj.book == null || jsonObj.book == undefined){
		document.getElementById("contnt").innerHTML = "There are some issues while retrieving result / No Result found";
	}else if(jsonObj.book != null && jsonObj.book[0] != null){
		var result = "";
		var count = jsonObj.book.length;
		for(i = 0; i < count; i++){
			result = result+ "<div class='book'>"+
			"<div class='book_img'><img width='100%' height='100%' src='"+jsonObj.book[i].img_url+"'></div>"+
			"<div class='book_dtl'>"+
			"<div><span>author: "+jsonObj.book[i].author+"</span></div>"+
			"<div><span>height: "+jsonObj.book[i].height+"</span></div>"+
			"<div><span>instock: "+jsonObj.book[i].instock+"</span></div>"+
			"<div><span>isbn: "+jsonObj.book[i].isbn+"</span></div>"+
			"</div>"+
			"</div>";
		}
		document.getElementById("contnt").innerHTML = result;
	}else if(jsonObj.book != null){
		var result = "<br/><br/><br/><span>author: "+jsonObj.book.author+
		"</span>"+"<br/><span>img_url: "+jsonObj.book.img_url+"</span>";
		document.getElementById("contnt").innerHTML = result;
	}else{
		document.getElementById("contnt").innerHTML = "No Result found";
	}
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
<div class="btns_dv">
	<input type="button" value="Load Employees" onclick="{loadJSON(0)}" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="LoadBooks" onclick="{loadJSON(1)}" />
</div>
</body>
</html>