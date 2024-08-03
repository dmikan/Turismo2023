function saludo() {
    alert("Good afternoon ADSO 279446")
}

function retorno(numero1, numero2){
    let resta = numero1 - numero2;
    return(resta);
}

function mostrar(){
    let numero1 = parseInt(prompt("Enter the first number"));
    let numero2 = parseInt(prompt("Enter the second number"));
    let respuesta = retorno(numero1, numero2);
    alert("The answer of the substraction is: " + respuesta);
}

function cambio(){
    let element = document.getElementById("oldClass");
    let clase1 = element.classList;

    if (clase1 == "oldClass"){
        element.classList.add("newClass");
    }
    else{
        element.classList.remove("newClass");
    }
}

function estilo(){
    let element = document.getElementsByClassName("miClase1");
    element[0].style.fontSize="20px";
    element[0].style.background="blue";

    for (let i=2; i< element.length; i++){
        element[i].style.fontSize="20px";
    }
        
}

function cambioTexto(){
    let element = document.getElementsByTagName("p");
    for (let i=0; i< element.length; i++){
        element[i].textContent="hola mundo";
    }
}