package br.com.boylavacar.BoyLavaCar.Agendamento.Service;

import br.com.boylavacar.BoyLavaCar.Categoria.DTOCategoria;
import br.com.boylavacar.BoyLavaCar.Categoria.DTOServ;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoCategoria {
    public DTOCategoria[] BuscaCategoria(){
        DTOServ[] servicosCarro = {
                 new DTOServ("Lavagem Simples",70.0),
                 new DTOServ("Lavagem Motor",170.0),
                 new DTOServ("Lavagem Chassi",50.0)
        };
        DTOServ[] servicosCamionete = {
                new DTOServ("Lavagem Simples",90.0),
                new DTOServ("Lavagem Motor",170.0),
                new DTOServ("Lavagem Chassi",80.0)
        };
        DTOServ[] servicosMoto = {
                new DTOServ("Lavagem Simples",50.0),

        };



        DTOCategoria[] categorias = {
            new DTOCategoria("Carro",servicosCarro),
            new DTOCategoria("Camionete",servicosCamionete),
            new DTOCategoria("Moto",servicosMoto)
        };

        return categorias;
    }
}
