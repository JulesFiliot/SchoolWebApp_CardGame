function generate(){

    const GET_USER_URL="http://127.0.0.1:8080/infoUser"; 
    let context =   {
                        method: 'GET'
                    };
        
    fetch(GET_USER_URL,context)
    	.then(reponse => reponse.json().then(body => callback(body)))
        .catch(error => err_callback(error));
}

function callback(response){
	document.getElementById("userName").innerHTML = response.name;
    document.getElementById("currentMoney").innerHTML = "Balance : " + response.money + "$";
}

function err_callback(error){
    console.log(error);
}