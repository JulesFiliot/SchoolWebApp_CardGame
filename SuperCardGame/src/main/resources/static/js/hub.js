function generate(){

    const GET_USER_URL="http://127.0.0.1:8080/infoUser"; 
    let context =   {
                        method: 'GET'
                    };
        
    fetch(GET_USER_URL,context)
    	.then(reponse => reponse.json().then(body => test_callback(body)))
        .catch(error => err_callback(error));
}

function callback(response){
	
	for(var i = 0; i < reponse.length; i++) {
    	document.getElementById("currentMoney").innerHTML = response[i].name;
    	console.log(reponse[i].name);
	}
}

function test_callback(message) {

	for(var i = 0; i < message.length; i++) {
    	document.getElementById("currentMoney").innerHTML = message[i].name;
    	console.log(message[i].name);
    }
	console.log(message[1]);
	console.log("OUAIS !");
	console.log(message[0].name);
}

function err_callback(error){
    console.log(error);
}