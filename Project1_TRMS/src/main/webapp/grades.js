window.onload= function(){
	 document.getElementById("uploadGrades").addEventListener("click",uploadGrades,false);
	 this.getLogin();
}
function getLogin(){
    console.log("in getLogin");

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            emp=JSON.parse(xhr.responseText);
            console.log(emp);
            loadLogin(emp);
        }
    }
    xhr.open("GET","http://localhost:8080/Project1_TRMS/login",true);

    xhr.send();
}
function loadLogin(emp){
	console.log(emp.employeeID);
	document.getElementById("id").value=emp.employeeID;
}
function jsonBuilder(){
    var elements= document.getElementById("gradeForm").elements;
    var obj={};
    for(var i=0; i<elements.length-1;i++){
        var item=elements.item(i);
        obj[item.name]=item.value;
        console.log(obj);
    }
    var json=JSON.stringify(obj);
    console.log(json);
    return json;
}

function uploadGrades(){
    console.log("in postVG");
 
    var xhr= new XMLHttpRequest();
    xhr.onreadystatechange= function(){
        console.log( "in ORSC "+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
        }
    }
    xhr.open("POST","http://localhost:8080/Project1_TRMS/status",true);
    var payload=jsonBuilder();
    xhr.send(payload);
}