// seleccionar elemento
let elemento1 = document.getElementById('parrafo_1');
let elemento2 = document.querySelector('.parrafo_2'); // modifica el primero
let elemento3 = document.querySelectorAll('.parrafo_2'); // modifica el primero
// modificar elemento
// elemento.innerHTML='<h2>ELEMENTO MODIFICADO POR ID</h2>';
elemento1.innerHTML='<h2 style="color:yellow">ELEMENTO MODIFICADO POR ID</h2>';
elemento2.innerHTML='ELEMENTO MODIFICADO POR CLASE'
//elemento3.innerHTML='<a> etiqueta cambiada </a>'
elemento3.forEach(function(par2) {
    par2.innerHTML = '<a style="color:red" href="">Etiqueta cambiada</a>';
});


// eventos
let boton = document.getElementById('Enviar');
let respuesta = document.getElementById('respuesta')

boton.addEventListener('click', function () {
    let nom = getElementById('nombre').value;
    respuesta.innerHTML = nom;
})

