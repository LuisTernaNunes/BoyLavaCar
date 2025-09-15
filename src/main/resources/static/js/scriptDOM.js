document.addEventListener('DOMContentLoaded', function() {
   const radiosDias = document.querySelectorAll('input[name="dia"]');
           const containersHoras = document.querySelectorAll('.horas-container');
           radiosDias.forEach((radio, idx) => {
               radio.addEventListener('change', () => {
                   containersHoras.forEach((container, cIdx) => {
                       if (cIdx === idx) {
                           container.classList.remove('d-none');
                       } else {
                           container.classList.add('d-none');
                       }
                   });
               });
           });
});

document.addEventListener('DOMContentLoaded', function() {
   const radiosCat = document.querySelectorAll('input[name="cat"]');
           const containerServ = document.querySelectorAll('.serv-container');
           radiosCat.forEach((radio, idx) => {
               radio.addEventListener('change', () => {
                   containerServ.forEach((container, cIdx) => {
                       if (cIdx === idx) {
                           container.classList.remove('d-none');
                       } else {
                           container.classList.add('d-none');
                       }
                   });
               });
           });
});

document.addEventListener('DOMContentLoaded', () => {
  const urlParams = new URLSearchParams(window.location.search);
  const secaoAtual = urlParams.get('secao');

  if (secaoAtual) {
    const linkAtivo = document.getElementById(secaoAtual);
    if (linkAtivo) {
      linkAtivo.classList.add('bg-dark');
      linkAtivo.classList.remove('text-white');
      linkAtivo.classList.add('text-light');
    }
  }
});

document.addEventListener("DOMContentLoaded", function(){
    const inputWhats = document.getElementById("whats");
    if (!inputWhats) return;

    inputWhats.addEventListener("input", function(e){
        let valor = inputWhats.value.replace(/\D/g, "");
        if (valor.length > 0) {
            valor = valor.replace(/^(\d{2})(\d)/g, "($1) $2");
            valor = valor.replace(/(\d{5})(\d{1,4})$/, "$1-$2");
        }
        inputWhats.value = valor;
    });
});

document.addEventListener("DOMContentLoaded", function(){
    secao = document.getElementById('navBarSecao').innerText;
    if(secao == "Agendamentos"){
         document.getElementById('dropdownAgendamento').classList.remove("d-none");
    }
});


