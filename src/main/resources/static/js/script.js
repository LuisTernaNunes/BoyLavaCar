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