var et;
var emp;
window.onload= function(){
	
    this.getLogin();
    this.getGF();
    this.getET();
    
    document.getElementById("vgFormSubmit").addEventListener("click",postVG,false);
    

    document.getElementById("event").addEventListener("change",calculateRP,false);
   document.getElementById("cost").addEventListener("change",calculateRP,false);
}

function getGF(){
    console.log("in getGF");
    //let vgid=document.getElementById("vgIDInput").value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            gf=JSON.parse(xhr.responseText);
            loadGF(gf);
        }
    }
    xhr.open("GET","http://localhost:8080/Project1_TRMS/grading",true);
    xhr.send();
}
function loadGF(gf){
    for (var i=0; i<gf.length;i++){
        document.getElementById("gradingFormat").options[i+1] = new Option(gf[i].gradingFormat,gf[i].gradingFormat);
    }
}

function getET(){
    console.log("in getET");
    //let vgid=document.getElementById("vgIDInput").value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
             et=JSON.parse(xhr.responseText);
            loadET(et);
        }
    }
    xhr.open("GET","http://localhost:8080/Project1_TRMS/event",true);
    xhr.send();
}

function loadET(et){
    for (var i=0; i<et.length;i++){
        document.getElementById("event").options[i+1] = new Option(et[i].eventType,et[i].eventType);
    }
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
	document.getElementById("name").value=emp.employeeName;
}
//function getSupervisor(){
//console.log("in get supervisor");
//let formID=emp.employeeID;
////let vgid=document.getElementById("vgIDInput").value;
//var xhr = new XMLHttpRequest();
//xhr.onreadystatechange=function(){
//  console.log("in ORSC"+xhr.readyState);
//  if(xhr.readyState==4 && xhr.status==200){
//      console.log(xhr.responseText);
//       supervisor=JSON.parse(xhr.responseText);
//      loadSupervisor(supervisor);
//  }
//}
//xhr.open("GET","http://localhost:8080/Project1_TRMS/vg"+formID,true);
//xhr.send();
//}
//function loadSupervsior(supervisor){
//console.log(supervisor.length);
//
//}

function calculateRP(){
	
    var cost = document.getElementById("cost").value;
    console.log(cost);
    var sel = document.getElementById("event");
    if(sel.value != 'SELECT'){
    	var i=0;
    	console.log(sel.value);
    	if(sel.value=='UNIVERSITY COURSES'){
    		i=0;
    	}
    	else if(sel.value=='SEMINARS'){
    		i=1;
    	}
    	else if(sel.value=='CERTIFICATION PREPARATION CLASSES'){
    		i=2;
    	}
    	else if(sel.value=='CERTIFICATION'){
    		i=3;
    	}
    	else if(sel.value=='TECHNICAL TRAINING'){
    		i=4;
    	}
    	else if(sel.value=='OTHERS'){
    		i=5;
    	}
        var percent = et[i].eventPercentage;
        console.log(percent);
        var pr = ((cost*percent)/100);
        console.log(pr);

        document.getElementById("projectedReimbursement").value = pr;
    }
}


function jsonBuilder(){
    var elements= document.getElementById("vgForm").elements;
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

function postVG(){
    console.log("in postVG");
 
    var xhr= new XMLHttpRequest();
    xhr.onreadystatechange= function(){
        console.log( "in ORSC "+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
        }
    }
    xhr.open("POST","http://localhost:8080/Project1_TRMS/vg",true);
    var payload=jsonBuilder();
    xhr.send(payload);
}