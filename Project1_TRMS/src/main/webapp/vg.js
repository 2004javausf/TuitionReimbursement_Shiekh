window.onload= function(){
    console.log("in onload");
    document.getElementById("vgFormSubmit").addEventListener("click",postVG,false);
//    document.getElementById("vgSubmitGet").addEventListener("click",getVG,false);
}
//function checkPassword(){
//    if(document.getElementById('password').value == 'hello'){
//     alert('Correct Password!'); 
//       location.href = "vg.html";
//      } else {
//      alert('Wrong Password!');
//       return false;
//     }
//    }


//function loadVG(vg){
//    document.getElementById("empName").innerHTML=vg.empName;
//    document.getElementById("date").innerHTML=vg.date;
//    document.getElementById("cost").innerHTML=vg.cost;
//    document.getElementById("gradingFormat").innerHTML=vg.gradingFormat;
//    document.getElementById("event").innerHTML=vg.event;
//}

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