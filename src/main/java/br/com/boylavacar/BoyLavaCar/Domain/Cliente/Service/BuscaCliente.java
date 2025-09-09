package br.com.boylavacar.BoyLavaCar.Domain.Cliente.Service;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.DTO.DTOFormAgenda;
import br.com.boylavacar.BoyLavaCar.Domain.Cliente.Cliente;
import br.com.boylavacar.BoyLavaCar.Domain.Cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscaCliente {
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente existeCliente(DTOFormAgenda dados){
        var optionalCliente = clienteRepository.findByTelefone(dados.whats());
        if(optionalCliente.isPresent()){
            System.out.println("cliente ja salvo");
            return optionalCliente.get();
        }else {
            Cliente cliente = new Cliente(dados);
            clienteRepository.save(cliente);
            System.out.println("cliente salvo com sucesso");
            return cliente;
        }
    }
}
