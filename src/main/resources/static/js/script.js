document.addEventListener('DOMContentLoaded', function() {
   const radiosDias = document.querySelectorAll('input[name="btnradio"]');
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

  function mostrarEtapa(numero) {
        const totalEtapas = 5;
        for (let i = 1; i <= totalEtapas; i++) {
            const bloco = document.getElementById('etapa' + i);
            if (bloco) {
                bloco.classList.add('d-none');
            }
        }

        const atual = document.getElementById('etapa' + numero);
        if (atual) {
            atual.classList.remove('d-none');
        }

        // Controla o botão final
        const botaoFinal = document.getElementById('botaoFinal');
        if (botaoFinal) {
            botaoFinal.classList.toggle('d-none', numero != 4);
        }
    }