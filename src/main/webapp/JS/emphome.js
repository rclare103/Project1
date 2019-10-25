class Reimbursement{
    constructor(reID, eventType, eventDate, cost, dsStatus, dhStatus, bcStatus){
        this.reID = reID;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.cost = cost;
        this.dsStatus = dsStatus;
        this.dhStatus = dhStatus;
        this.bcStatus = bcStatus;
    }
}


var reList;
function displayReimbursementList(reList){
    let table = document.getElementById("reTable");
    
    for (re of reList){
        table.appendChild(addRow(re)); 
    }    
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

/*
function getStatus(re){
    let status = "";
    console.log("re.bcStatus: " + re.bcStatus);
    console.log("re.dhStatus: " + re.dhStatus);
    console.log("re.dsStatus: " + re.dsStatus);
    if (re.bcStatus === "approved" && re.dhStatus === "approved"){
        if (re.dsStatus === "approved"){
            status = "approved";
        }
        
    } else if (re.bcStatus === "urgent"|| re.dhStatus == "urgent"){
        status = "urgent";
    } else if (re.dsStatus === "urgent"){
        status = "urgent";
    } else {
        status = "pending";
    }

    return status;
}
*/
function addRow(re){
    let newRow = document.createElement("tr");
    let reIDCol = document.createElement("td");
    console.log(re.rID);
    reIDCol.innerHTML = re.rID;
    let type = document.createElement("td");
    type.innerHTML = re.eventType;
    let date = document.createElement("td");
    date.innerHTML = re.eventDate;
    let costcol = document.createElement("td");
    costcol.innerHTML = re.cost;
    let dsstatuscol = document.createElement("td");
    dsstatuscol.innerHTML = re.dsStatus;
    let dhstatuscol = document.createElement("td");
    dhstatuscol.innerHTML = re.dhStatus;
    let bcstatuscol = document.createElement("td");
    bcstatuscol.innerHTML = re.bcStatus;
    newRow.appendChild(reIDCol);
    newRow.appendChild(type);
    newRow.appendChild(date);
    newRow.appendChild(costcol);
    newRow.appendChild(dsstatuscol);
    newRow.appendChild(dhstatuscol);
    newRow.appendChild(bcstatuscol);
    return newRow;
}

function getReimbursements() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if (xhr.readyState === 4){
            if (xhr.status === 200){
                reList = JSON.parse(xhr.responseText);
                displayReimbursementList(reList);
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

window.onload = function(){
    this.getReimbursements();
}