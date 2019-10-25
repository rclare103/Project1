window.onload = function(){
    this.getAvailableReimbursement();
}

function getEventType(){
    let eventTypes = document.getElementsByName("eventType");
    for (i of eventTypes){
        if (i.checked){
            return i.value;
        }
    }
}

function getAvailableReimbursement(){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                var avail = xhr.responseText;
                document.getElementById("avail").innerHTML = `Your available reimbursement amount is: ` + avail;
            } else {
                //document.getElementById("reHeader").innerHTML = "Your reimbursements: failed to load";
            }
        } else {
            //document.getElementById("reHeader").innerHTML = "Fetching Request";
        }
    }
    xhr.open("GET", "tuitionform", true);
    xhr.send();
}

function getCost(){
    let constant = 0;
    let eventType = this.getEventType();
    let cost = document.getElementById("cost").value;
    if (eventType === "university_course"){
        constant = .8;
    } else if (eventType === "seminar"){
        constant = .6;
    } else if (eventType === "certification_preparation_course"){
        constant = .75;
    } else if (eventType === "certification"){
        constant = 1;
    } else if (eventType === "technical_training"){
        constant = .9;
    } else {
        constant = .3;
    }

    return constant * cost;
}

function displayCost(){
    var eventRe = this.getCost();
    if (eventRe >= avail){
        eventRe = avail;
    }
    document.getElementById('estimate').innerHTML = eventRe;
}
/*
window.onload = function(){
    document.getElementById("estimateRe").addEventListener("click", this.getCost);
}*/