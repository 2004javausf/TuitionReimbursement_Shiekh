var emp;
window.onload= function(){
	console.log("in login load");
//	 document.getElementById("reimbursements").addEventListener("click",getLogin,false);
//	console.log(emp.employeeID);
//	 document.getElementById("id").value=emp.employeeID;
//	 document.getElementById("name").value=emp.employeeName;
//	this.getLogin();
	
    
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
xhrr.open("GET","http://localhost:8080/Project1_TRMS/grs?formID="+formID ,true);

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

        for (var h = 0; h < col.length; h++) {
        	if (h==6){
        		continue;
        	}
            var th = document.createElement("th");      // table header.
            th.innerHTML = col[h];
            tr.appendChild(th);
        }

        // add json data to the table as rows.
        for (var i = 0; i < er.length; i++) {

            tr = table.insertRow(-1);

            for (var j = 0; j < col.length; j++) {
            	if (j==6){
            		continue;
            	}
                var tabCell = tr.insertCell(-1);
                tabCell.innerHTML = er[i][col[j]];
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
