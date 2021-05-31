// --- FUNCTIONS ---

//fetch all cards of connected user
function fetch_play() {
    const GET_PLAY_URL="http://127.0.0.1:8090/play/allPlay"; 
    let context =   {
                        method: 'GET'
                    };
        
    fetch(GET_PLAY_URL,context)
        .then(reponse => reponse.json().then(body => playList_callback(body)))
        .catch(error => err_callback(error));
}

function err_callback(error){
    console.log(error);
}

function playList_callback(reponse) {
	console.log("In playList_callback !");
	for(var i = 0; i < reponse.length; i++) {
    	playList[i] = reponse[i];        
    }
    replace_content();
}

function replace_content() {
    let template = document.querySelector("#row");
    console.log(playList)
    for(const play of playList){
        console.log(play);
        let clone = document.importNode(template.content, true);

        newContent= clone.firstElementChild.innerHTML
                    .replace(/{{name}}/g, play.name)
                    .replace(/{{IdP1}}/g, play.IdP1)
                    .replace(/{{pari}}/g, play.pari);
                    
        clone.firstElementChild.innerHTML= newContent;

        let playContainer= document.querySelector("#tableContent");
        playContainer.appendChild(clone);

    	document.getElementById("a").href = "./waitingRoom.html";
    	document.getElementById("a").id = "a" + play.id;
    
    }
}


//fetch all cards of connected user
function fetch_user() {
    const GET_USER_URL="http://127.0.0.1:8090/user/infoUser"; 
    let context =   {
                        method: 'GET'
                    };        
    fetch(GET_USER_URL,context)
        .then(reponse => reponse.json().then(body => user_callback(body)))
        .catch(error => err_callback_user(error));
}

function err_callback_user(error){
    console.log(error);
}

function user_callback(reponse) {
	console.log("In user_callback !");
    document.getElementById("userNameId").innerHTML = reponse.name;
    document.getElementById("userMoneyId").innerHTML = reponse.money;
}


// --- CODE ---

let playList = [];
document.addEventListener("DOMContentLoaded", function() {
  fetch_play();
  fetch_user();
});