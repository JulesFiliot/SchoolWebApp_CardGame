// --- FUNCTIONS ---

//fetch all cards of the connected user
function fetch_cards() {

    const GET_CARDS_URL="http://127.0.0.1:8080/mycards"; 
    let context =   {
                        method: 'GET'
                    };
        
    fetch(GET_CARDS_URL,context)
        .then(reponse => reponse.json().then(body => cardList_callback(body)))
        .catch(error => err_callback(error));
}

//fetch userName and balance of the connected user
function fecth_userName(){

    const GET_USER_URL="http://127.0.0.1:8080/infoUser"; 
    let context =   {
                        method: 'GET'
                    };
        
    fetch(GET_USER_URL,context)
    	.then(reponse => reponse.json().then(body => userName_callback(body)))
        .catch(error => err_callback(error));
}

function userName_callback(response){
    console.log(response);
	document.getElementById("userName").innerHTML = response.name;
    document.getElementById("currentMoney").innerHTML = response.money;
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
        let clone = document.importNode(template.content, true);

        newContent= clone.firstElementChild.innerHTML
                    .replace(/{{name}}/g, card.name);
                    /*.replace(/{{family_src}}/g, card.family_src)
                    .replace(/{{family_name}}/g, card.family_name)
                    .replace(/{{img_src}}/g, card.img_src)
                    .replace(/{{name}}/g, card.name)
                    .replace(/{{description}}/g, card.description)
                    .replace(/{{hp}}/g, card.hp)
                    .replace(/{{energy}}/g, card.energy)
                    .replace(/{{attack}}/g, card.attack)
                    .replace(/{{defense}}/g, card.defense)
                    .replace(/{{price}}/g, card.price);*/
        clone.firstElementChild.innerHTML= newContent;

        let cardContainer= document.querySelector("#tableContent");
        cardContainer.appendChild(clone);
    }
}

function err_callback(error){
    console.log(error);
}


// --- CODE ---

let cardList = [];
document.addEventListener("DOMContentLoaded", function() {
  fetch_cards();
  fecth_userName();
});



    






