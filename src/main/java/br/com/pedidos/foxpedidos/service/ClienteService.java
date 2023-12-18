package br.com.pedidos.foxpedidos.service;

import java.util.List;

import br.com.pedidos.foxpedidos.dto.Cliente.DTOEditarCliente;
import br.com.pedidos.foxpedidos.dto.Cliente.DTOListarCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<DTOListarCliente> listarClientes(Pageable paginacao) {
        return clienteRepository.findByAtivoTrue(paginacao);
    }

    public void editarCliente(Long clienteId, DTOEditarCliente dtoEditarCliente){
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("O ID de cliente não foi encontrado."));

        dtoEditarCliente.telefone().ifPresent(cliente::setTelefone);
        dtoEditarCliente.endereco().ifPresent(cliente::setEndereco);

        clienteRepository.save(cliente);
    }
}
