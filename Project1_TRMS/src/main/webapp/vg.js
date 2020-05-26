window.onload= function(){
    console.log("in onload");
    this.getGF();
    this.getET();
  
    document.getElementById("vgFormSubmit").addEventListener("click",postVG,false);
    

//    document.getElementById("eType").addEventListener("change",calculateRP,false);
//    document.getElementById("tFees").addEventListener("change",calculateRP,false);
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
            var et=JSON.parse(xhr.responseText);
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