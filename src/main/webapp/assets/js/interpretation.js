const result = document.getElementById("rep")

const recipient = []
let global = "";

const idIndicElements = document.querySelectorAll(".idIndic");
const dataElements = document.querySelectorAll(".data");

const indicators = Array.from(idIndicElements).map((element, index) => {
    return {
        id: element.value,
        pourcentage: dataElements[index].value
    };
});

console.log(indicators);


$(document).ready(async () => {
    const $overlay = $('<div id="overlay" style="display:none; position: fixed; top: 0; left: 0; width: 100%; height: 100%; background-color: rgba(0, 0, 0, 0.5); z-index: 999;"></div>'); // z-index inférieur au loader
    $('body').append($overlay);
    const $loader = $('<div id="loader" style="display:none; position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); z-index: 1000; border: 16px solid #f3f3f3; border-top: 16px solid #3498db; border-radius: 50%; width: 120px; height: 120px; animation: spin 2s linear infinite;"></div>');
    $('body').append($loader);
    $("#overlay").show();
    $("#loader").show();
    await sendAllDataViaAjax(indicators);
    indicators.forEach(indicator => {
        sendDataViaAjax(indicator.id, indicator.pourcentage);
    });
})

function formatResponseText(text) {
    return marked.parse(text)
}

async function sendDataViaAjax(id, pourcentage) {
    $.ajax({
        url: "http://localhost:8000/suggestions",
        type: "GET",
        data: {
            id: id,
            pourcentage: pourcentage
        },
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        success: function(response) {
            console.log("ty no valiny " + response.solution);
            recipient.push(formatResponseText(response.solution));
            displayMessage(formatted);
        },
        error: function(xhr, status, error) {
            console.error("An error occurred: " + error);
        },
        complete: function() {
        }
    });
}

async function sendAllDataViaAjax(indicators) {
    $.ajax({
        url: "http://localhost:8000/suggestions",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(indicators),
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        success: function(response) {
            console.log("Réponses reçues : ", response);
            global = formatResponseText(response.solution);
            result.innerHTML = global;
        },
        error: function(xhr, status, error) {
            console.error("Une erreur est survenue : " + error);
        },
        complete: function() {
            $("#overlay").hide();
            $("#loader").hide();
        }
    });
}

function showSolutions(id) {
    result.innerHTML = recipient[id];
}

function showSolutionGlobal(){
    result.innerHTML = global;
}