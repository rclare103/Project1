class Reimbursement {
    constructor(rID, eventType, eventDate, cost, dsStatus, dhStatus, bcStatus) {
        this.rID = rID;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.cost = cost;
        this.dsStatus = dsStatus;
        this.dhStatus = dhStatus;
        this.bcStatus = bcStatus;
    }
}

window.onload = function () {
    this.getReimbursements();
    //this.setTimeout(this.getMessages(), 1000);
    //alert("hello");
}

var reList;
var messageList;
var reIDList = new Array();

function displayReimbursementList(reList) {
    let table = document.getElementById("reTable");

    for (re of reList) {
        reIDList.push(re.rID)
        table.appendChild(addRow(re));
    }
}

function getReimbursements() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                reList = JSON.parse(xhr.responseText);
                displayReimbursementList(reList);
            } else {
                document.getElementById("reHeader").innerHTML = "Your reimbursements: failed to load";
            }
        } else {
            document.getElementById("reHeader").innerHTML = "Fetching Request";
        }
    }
    xhr.open("GET", "emphome", true);
    xhr.send();
}

function addRow(re) {
    let newRow = document.createElement("tr");
    let reIDCol = document.createElement("td");
    reIDCol.innerHTML = re.rID;
    let type = document.createElement("td");
    type.innerHTML = re.eventType;
    let date = document.createElement("td");
    date.innerHTML = re.eventDate;
    let costcol = document.createElement("td");
    costcol.innerHTML = re.estimatedReimbursement;
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

function getMessages() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                messageList = JSON.parse(xhr.responseText);
                displayMessages(messageList);
            } else {
                document.getElementById("reHeader").innerHTML = "Your messages: failed to load";
            }
        } else {
            document.getElementById("reHeader").innerHTML = "Fetching Messages";
        }
    }
    xhr.open("POST", "message", true);
    xhr.send();
}

function viewMessages() {

    getMessages();
    let x = document.getElementById("viewMessage");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}


function displayMessages(messageList) {
    let messTable = document.getElementById("messTable");
    for (message of messageList) {
        if (reIDList.includes(message.rID)) {
            messTable.appendChild(addMessageRow(message));
        }
    }
}

function addMessageRow(message) {
    let newRow = document.createElement("tr");
    let reIDCol = document.createElement("td");
    reIDCol.innerHTML = message.rID;
    let dsMessageCol = document.createElement("td");
    dsMessageCol.innerHTML = message.dsMessage;
    let dhMessageCol = document.createElement("td");
    dhMessageCol.innerHTML = message.dhMessage;
    let bcMessageCol = document.createElement("td");
    bcMessageCol.innerHTML = message.bcMessage;
    newRow.appendChild(reIDCol);
    newRow.appendChild(dsMessageCol);
    newRow.appendChild(dhMessageCol);
    newRow.appendChild(bcMessageCol);
    return newRow;
}