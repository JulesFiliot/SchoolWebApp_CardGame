// --- FUNCTIONS ---

//fetch all cards of connected user
function fetch_cards() {
    const GET_CARDS_URL="http://127.0.0.1:8090/card/mycards"; 
    let context =   {
                        method: 'GET'
                    };
    fetch(GET_CARDS_URL,context)
        .then(reponse => reponse.json().then(body => cardList_callback(body)))
        .catch(error => err_callback(error));
}

function err_callback(error){
    console.log(error);
}

function cardList_callback(reponse) {
	console.log("In cardList_callback !");
	for(var i = 0; i < reponse.length; i++) {
    	cardList[i] = reponse[i];        
    }
    replace_content();
}

function replace_content() {
    let template = document.querySelector("#row");

    for(const card of cardList){
        console.log(card);
        let clone = document.importNode(template.content, true);

        newContent= clone.firstElementChild.innerHTML
        			.replace(/{{img_src}}/g, card.imgSrc)
                    .replace(/{{name}}/g, card.name)
                    .replace(/{{description}}/g, card.description)
                    .replace(/{{family_name}}/g, card.family)
                    .replace(/{{hp}}/g, card.hp)
                    .replace(/{{energy}}/g, card.energy)
                    .replace(/{{attack}}/g, card.attack)
                    .replace(/{{defense}}/g, card.defense)
                    .replace(/{{price}}/g, card.price);

        clone.firstElementChild.innerHTML= newContent;

        let cardContainer= document.querySelector("#tableContent");
        cardContainer.appendChild(clone);

    	document.getElementById("a").href = "http://127.0.0.1:8090/market/sellCard/" + card.id;
    	document.getElementById("a").id = "a" + card.id;
    
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

let cardList = [];
document.addEventListener("DOMContentLoaded", function() {
  fetch_cards();
  fetch_user();
});