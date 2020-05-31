var emp;
window.onload= function(){
	console.log("in login load");
	 document.getElementById("acceptRequest").addEventListener("click",postInfo,false);
	 document.getElementById("rejectRequest").addEventListener("click",postRejectBenco,false);
//	console.log(emp.employeeID);
//	 document.getElementById("id").value=emp.employeeID;
//	 document.getElementById("name").value=emp.employeeName;
	this.getLogin();
//	 document.getElementById("vgFormSubmit").addEventListener("click",postVG,false);	
}
		function jsonBuilder(){
		    var elements= document.getElementById("acceptForm").elements;
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

		function postInfo(){
		    console.log("in post Info");
		 
		    var xhr= new XMLHttpRequest();
		    xhr.onreadystatechange= function(){
		        console.log( "in ORSC "+xhr.readyState);
		        if(xhr.readyState==4 && xhr.status==200){
		            console.log(xhr.responseText);
		        }
		    }
		    xhr.open("POST","http://localhost:8080/Project1_TRMS/grading",true);
		    var payload=jsonBuilder();
		    xhr.send(payload);
		}
	
function jsonBuilderReject(){
	
    var elements= document.getElementById("rejectForm").elements;
    var obj={};
    for(var i=0; i<elements.length-1;i++){
        var item=elements.item(i);
        obj[item.name]=item.value;
        console.log(obj);
    }
    var json1=JSON.stringify(obj);
    console.log(json1);
    return json1;
}

function postRejectBenco(){
    console.log("in post reject");
 
    var xhr= new XMLHttpRequest();
    xhr.onreadystatechange= function(){
        console.log( "in ORSC "+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
        }
    }
    xhr.open("POST","http://localhost:8080/Project1_TRMS/myform",true);
    var payload1=jsonBuilderReject();
    xhr.send(payload1);
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
            getRequests(emp);
//            loadLogin(emp);
        }
    }
    xhr.open("GET","http://localhost:8080/Project1_TRMS/login",true);

    xhr.send();
}

//function loadLogin(emp){
//	
//	console.log(emp);
//
//    document.getElementById("eID").innerHTML=emp.employeeID;
//   document.getElementById("fname").innerHTML=emp.employeeName;
//
//
//}
function getRequests(emp){
	console.log(emp.employeeID);
console.log("in get requests");
let formID=emp.employeeID;
//let formID=document.getElementById("requestForm").value;
var	xhrr= new XMLHttpRequest();
xhrr.onreadystatechange= function(){
  console.log( "in ORSC "+xhrr.readyState);
  if(xhrr.readyState==4 && xhrr.status==200){
      console.log(xhrr.responseText);
      var fm= JSON.parse(xhrr.responseText);
      console.log(fm);
      loadTable(fm);
  }
}
xhrr.open("GET","http://localhost:8080/Project1_TRMS/accept?formID="+formID ,true);

xhrr.send();
}
function loadTable(er){
    var col = [];
    console.log(er.length);
    for (var c = 0; c < er.length; c++) {
    	
        for (var key in er[c]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }
    console.log(col);
    var table = document.createElement("table");

        // Create table header row using the extracted headers above.
        var tr = table.insertRow(-1);                   // table row.

        for (var h = 0; h < col.length-2; h++) {
//        	if (h==6){
//        		continue;
//        	}
            var th = document.createElement("th");      // table header.
            th.innerHTML = col[h];
            tr.appendChild(th);
        }

        // add json data to the table as rows.
        for (var i = 0; i < er.length; i++) {

            tr = table.insertRow(-1);

            for (var j = 0; j < col.length-2; j++) {
            	var tabCell = tr.insertCell(-1);
//              	 if (j==6){
//               		continue;
//               	}
              	if(j==2){
                  	var d = er[i][col[j]];
                	var date = new Date(d).toLocaleDateString();
                  	console.log(date);
                  	tabCell.innerHTML = date;
                  }

                  else {
                  tabCell.innerHTML = er[i][col[j]];
                  }
            }
        }

        // Now, add the newly created table with json data, to a container.
        var divShowData = document.getElementById('showData');
        divShowData.innerHTML = "";
        divShowData.appendChild(table);
   
}




//function getSupervisor(){
//    console.log("in get supervisor");
//  let formID=emp.employeeID;
//    //let vgid=document.getElementById("vgIDInput").value;
//    var xhr = new XMLHttpRequest();
//    xhr.onreadystatechange=function(){
//        console.log("in ORSC"+xhr.readyState);
//        if(xhr.readyState==4 && xhr.status==200){
//            console.log(xhr.responseText);
//             supervisor=JSON.parse(xhr.responseText);
//            loadSupervisor(supervisor);
//        }
//    }
//    xhr.open("GET","http://localhost:8080/Project1_TRMS/vg"+formID,true);
//    xhr.send();
//}
//function loadSupervsior(supervisor){
//	console.log(supervisor.length);
//    
//}
