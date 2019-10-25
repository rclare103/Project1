
class Message{
    constructor(rID, dsMessage, dhMessage, bcMessage){
        this.rID = rID;
        this.dsMessage = dsMessage;
        this.dhMessage = dhMessage;
        this.bcMessage = bcMessage;
    }
}

var reIDList = new Array();
var messageList;
var reList;

function displayReimbursementList(reList){
    let table = document.getElementById("reTable");
    
    for (re of reList){
        table.appendChild(addRow(re)); 
    }    
}

function addRow(re){
    let newRow = document.createElement("tr");
    let reIDCol = document.createElement("td");
    console.log(re.rID);
    reIDCol.innerHTML = re.rID;
    let userIDCol = document.createElement("td");
    userIDCol.innerHTML = re.userID;
    console.log(re.userID);
    let type = document.createElement("td");
    type.innerHTML = re.eventType;
    let date = document.createElement("td");
    date.innerHTML = re.eventDate;
    let cost = document.createElement("td");
    cost.innerHTML = re.cost;
    let descriptioncol = document.createElement("td");
    descriptioncol.innerHTML = re.description;
    let justificationcol = document.createElement("td");
    justificationcol.innerHTML = re.justification;
    let dsstatus = document.createElement("td");
    dsstatus.innerHTML = re.dsStatus;
    let dhstatus = document.createElement("td");
    dhstatus.innerHTML = re.dhStatus;
    let bcstatus = document.createElement("td");
    bcstatus.innerHTML = re.bcStatus;
    newRow.appendChild(reIDCol);
    newRow.appendChild(userIDCol);
    newRow.appendChild(type);
    newRow.appendChild(date);
    newRow.appendChild(cost);
    newRow.appendChild(descriptioncol);
    newRow.appendChild(justificationcol);
    newRow.appendChild(dsstatus);
    newRow.appendChild(dhstatus);
    newRow.appendChild(bcstatus);
    return newRow;
}

function getReimbursements() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if (xhr.readyState === 4){
            if (xhr.status === 200){
                displayReimbursementList(JSON.parse(xhr.responseText));
            } else{
                document.getElementById("reHeader").innerHTML = "Your reimbursements: failed to load";
            }
        } else{
            document.getElementById("reHeader").innerHTML = "Fetching Request";
        }
    }
    xhr.open("GET", "dhhome", true);
    xhr.send();
}

function getMessages(){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if (xhr.readyState === 4){
            if (xhr.status === 200){
                messageList = JSON.parse(xhr.responseText);
            } else{
                document.getElementById("reHeader").innerHTML = "Your messages: failed to load";
            }
        } else{
            document.getElementById("reHeader").innerHTML = "Fetching Messages";
        }
    }
    xhr.open("POST", "message", true);
    xhr.send();
}

function displayMessages(){
    let messTable = document.getElementById("messTable");
    for (message of messageList) {
        if (reIDList.includes(message.rID)) {
            messTable.appendChild(addMessageRow(message));
        }
    }
}

function showHideApprove(){
    let x = document.getElementById("approval");
    if (x.style.display === "none"){
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

function showHideMessage(){
    let x = document.getElementById("message");
    if (x.style.display === "none"){
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

function viewMessages(){
    let x = document.getElementById("viewMessage");
    if (x.style.display === "none"){
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}
function addMessageRow(message) {
    let newRow = document.createElement("tr");
    let reIDCol = document.createElement("td");
    reIDCol.innerHTML = message.rID;
    let bcMessageCol = document.createElement("td");
    bcMessageCol.innerHTML = message.bcMessage;
    newRow.appendChild(reIDCol);
    newRow.appendChild(bcMessageCol);
    return newRow;
}
window.onload = function(){
    this.getReimbursements();
    this.setTimeout(this.getMessages(), 1000);
}