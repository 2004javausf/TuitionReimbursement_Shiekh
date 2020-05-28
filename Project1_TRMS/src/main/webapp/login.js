//var attempt=3;
//function validate(){
//
//var username = document.getElementById("username").value;
//var password = document.getElementById("password").value;
//if ( username == "Formget" && password == "formget#123"){
//alert ("Login successfully");
//window.location = "vg.html"; // Redirecting to other page.
//return false;
//}
//else{
//	attempt --;// Decrementing by one.
//	alert("You have left "+attempt+" attempt;");
//	// Disabling fields after 3 attempts.
//	if( attempt == 0){
//	document.getElementById("username").disabled = true;
//	document.getElementById("password").disabled = true;
//	document.getElementById("submit").disabled = true;
//	return false;
//	}
//	}
//}

window.onload=function(){
    console.log("in load");
    var login = '<%= session.getAttribute("login") %>';
	console.log(login);
	var session = '<%= Session["login"] %>';
	console.log(session);
	this.getLogin();
}

function getLogin(){
    console.log("in getLogin");
//    let uName=document.getElementById("uName").value;
//    let uPassword=document.getElementById("uPassword").value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
           var emp=JSON.parse(xhr.responseText);
            console.log(emp);
            loadLogin(emp);
        }
    }
    xhr.open("GET","http://localhost:8080/Project1_TRMS/login",true);
//    var payload=jsonBuilder();
    xhr.send();
}

function loadLogin(emp){
	
	var emp = emp;
	console.log(emp);
	var login = '<%= session.getAttribute("login") %>';
	console.log(login);

    document.getElementById("eID").innerHTML=emp.employeeID;
   document.getElementById("fname").innerHTML=emp.employeeName;
//    document.getElementById("lname").innerHTML=emp.lName;
//    document.getElementById("uname").innerHTML=emp.uname;
//    document.getElementById("upass").innerHTML=emp.uPassword;
//    document.getElementById("email").innerHTML=emp.email;
//    document.getElementById("title").innerHTML=emp.title;
//    document.getElementById("dept").innerHTML=emp.dept;

}