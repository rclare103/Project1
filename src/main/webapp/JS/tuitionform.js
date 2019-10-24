function getEventType(){
    let eventType = document.getElementsByName("eventType");
    for (i of eventType){
        if (i.checked){
            return i.value;
        }
    }
}

function getCost(){
    let constant = 0;
    let eventType = this.getEventType();
    let cost = document.getElementById("cost").value;
    if (eventType === "university_cost"){
        constant = .8;
    } elseif (eventType === "seminar"){
        constant = .6;
    } elseif (eventType === "certification_preparation_class"){
        constant = .75;
    } elseif (eventType === "certification"){
        constant = 1;
    } elseif (eventType === "technical_training"){
        constant = .9;
    } else {
        constant = .3;
    }

    return constant * cost;
}

function displayCost(){
    document.getElementById("estimate").innerHTML = `${cost}`
}

window.onload = function(){
    document.getElementsByName("eventType").addEventListener("click", this.getCost);
}