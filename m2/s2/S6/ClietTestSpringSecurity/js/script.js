const url = 'localhost:8080/api/auth/';

document.addEventListener("DOMContentLoaded", () => {
    const registerBtn = document.querySelector("#registerForm button");
    registerBtn.addEventListener("click", register);
})

const login = () => {
    alert('login');
}

const register = () => {
    const form = document.querySelectorAll("#registerForm");
    let name = form[0][0].value;
    let lastname = form[0][1].value;
    let email = form[0][2].value;
    let username = form[0][3].value;
    let password = form[0][4].value;
    

    let obj = {
        name: name, 
        lastname: lastname, 
        email: email,  
        username: username,  
        password: password
    }

    console.log(obj);

    // faccio tutti gli opportuni controlli
    // se tutto ok invio i dati al server    
   
    fetch(url+'/register', {
        method: 'POST',
        headers: {'Content-type': 'application/json; charset=UTF-8'},
        body: JSON.stringify(obj)
    }).then(response => console.log(response))

}