// --- FUNCTIONS ---

//fetch all cards of connected user
function fetch_play() {
    const GET_PLAY_URL="http://127.0.0.1:8084/allPlay"; 
    alert(GET_PLAY_URL);
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
		alert("ok");
    let template = document.querySelector("#row");
    
    for(const play of playList){
        console.log(play);
        let clone = document.importNode(template.content, true);

        newContent= clone.firstElementChild.innerHTML
                    .replace(/{{name}}/g, play.name)
                    .replace(/{{pari}}/g, play.pari);
                    
        clone.firstElementChild.innerHTML= newContent;

        let playContainer= document.querySelector("#tableContent");
        playContainer.appendChild(clone);

    	//document.getElementById("a").href = "./market/buyCard/" + card.id;
    	//document.getElementById("a").id = "a" + card.id;
    
    }
}


//fetch all cards of connected user
function fetch_user() {
    const GET_USER_URL="http://127.0.0.1:8080/infoUser"; 
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
	console.log("In JavaScript !");
  fetch_play();
  fetch_user();
});