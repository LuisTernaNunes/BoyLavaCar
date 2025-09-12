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
  const secaoSpan = document.getElementById("navBarSecao");
  const secao = secaoSpan.textContent.trim();

    if (secao === "Agendamentos") {
        // Criar container do dropdown
        const dropdown = document.createElement("div");
        dropdown.classList.add("dropdown", "ms-3"); // ms-3 = margem esquerda

        // Botão do dropdown
        const button = document.createElement("button");
        button.className = "btn btn-secondary dropdown-toggle";
        button.type = "button";
        button.id = "dropdownAgendamento";
        button.setAttribute("data-bs-toggle", "dropdown");
        button.setAttribute("aria-expanded", "false");
        button.textContent = "Hoje";

        // Menu do dropdown
        const menu = document.createElement("ul");
        menu.className = "dropdown-menu";
        menu.setAttribute("aria-labelledby", "dropdownAgendamento");

        const opcoes = [
            { text: "Anteriores", action: () => filtrarAgendamento("anteriores")},
            { text: "Hoje",  action: () => filtrarAgendamento("hoje") },
            { text: "Amanhã",  action: () => filtrarAgendamento("amanha") },
            { text: "Proximos Dias",  action: () => filtrarAgendamento("Proximos Dias") }
        ];

          opcoes.forEach(op => {
                  const li = document.createElement("li");
                  const a = document.createElement("a");
                  a.className = "dropdown-item";
                  a.href = "javascript:void(0)";
                  a.textContent = op.text;
                  a.addEventListener("click", () => {
                   op.action();
                   button.textContent = op.text;
                  });
                  li.appendChild(a);
                  menu.appendChild(li);
              });

        // Montar dropdown
        dropdown.appendChild(button);
        dropdown.appendChild(menu);

        // Adicionar ao lado do span
        secaoSpan.parentNode.appendChild(dropdown);
    }
});

