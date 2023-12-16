package br.com.pedidos.foxpedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.foxpedidos.domain.Cliente.Cliente;
import br.com.pedidos.foxpedidos.repository.Cliente.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public void exclusaoLogicaAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        for (Cliente cliente : clientes) {
            cliente.setAtivo(false);
        }
        clienteRepository.saveAll(clientes);
    }

    public void ativarAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        for (Cliente cliente : clientes) {
            cliente.setAtivo(true);
        }
        clienteRepository.saveAll(clientes);
    }
}
