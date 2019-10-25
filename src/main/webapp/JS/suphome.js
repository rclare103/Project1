class Reimbursement{
    constructor(reID, eventType, eventDate, eventCost, status){
        this.reID = reID;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.eventCost = eventCost;
        this.Status = status;
    }
}

class Message{
    constructor(rID, dsMessage, dhMessage, bcMessage){
        this.rID = rID;
        this.dsMessage = dsMessage;
        this.dhMessage = dhMessage;
        this.bcMessage = bcMessage;
    }
}

window.onload = function(){
    this.getMessages();
}
var messageList;

function displayReimbursementList(reList){
    let table = document.getElementById("reTable");
    
    for (re of reList){
        table.appendChild(addRow(re)); 
    }    
}

function getStatus(re){
    let status = "";
    if (re.bcStatus === "approved" && re.dhStatus === "approved"){
        if (re.dsStatus === "approved"){
            status = "approved";
        }
        
    } else if (re.bcStatus === "urgent"|| re.dhStatus == "urgent"){
        status = "urgent";
    } else if (re.dsStatus = "urgent"){
        status = "urgent";
    } else {
        status = "pending";
    }

    return status;
}

function addRow(re){
    let newRow = document.createElement("tr");
    let reIDCol = document.createElement("td");
    reIDCol.innerHTML = re.rID;
    let type = document.createElement("td");
    type.innerHTML = re.eventType;
    let date = document.createElement("td");
    date.innerHTML = re.eventDate;
    let cost = document.createElement("td");
    cost.innerHTML = re.cost;
    let status = document.createElement("td");
    status.innerHTML = getStatus(re);
    newRow.appendChild(reIDCol);
    newRow.appendChild(type);
    newRow.appendChild(date);
    newRow.appendChild(cost);
    newRow.appendChild(status);

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
    xhr.open("GET", "emphome", true);
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
            document.getElementById("reHeader").innerHTML = "Fetching Request";
        }
    }
    xhr.open("POST", "message", true);
    xhr.send();
}

function displayMessages(){
    let rIDmess = document.getElementById("rIDmess").value;
    let messTable = document.getElementById("messTable");
    for (message of MessageList){
        if (message.rID === rIDmess){
            let newRow = document.createElement("tr");
            let reIDCol = document.createElement("td");
            reIDCol.innerHTML = message.rID;
            let dhMessageCol = document.createElement("td");
            dhMessageCol.innerHTML = message.dhMessage;
            let bcMessageCol = document.createElement("td");
            bcMessageCol.innerHTML = message.bcMessage;
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

window.onload = function(){
    this.getReimbursements();
}