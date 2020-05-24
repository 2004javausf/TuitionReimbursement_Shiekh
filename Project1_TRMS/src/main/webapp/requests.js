window.onload= function(){
    console.log("in onload");
    document.getElementById("getForm").addEventListener("click",getRequests,false);
}
function getRequests(){
console.log("in get requests");
let formID=document.getElementById("requestForm").value;
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
xhrr.open("GET","http://localhost:8080/Project1_TRMS/grs?formID="+ formID ,true);

xhrr.send();
}
function loadTable(fm){
	document.getElementById("empName").innerHTML=fm.empName;
}