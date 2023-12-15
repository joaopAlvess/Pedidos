package br.com.pedidos.foxpedidos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.foxpedidos.Domain.Cliente.Cliente;
import br.com.pedidos.foxpedidos.Domain.Cliente.ClienteRepository;
import br.com.pedidos.foxpedidos.Domain.Cliente.DTOCadastroCliente;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid DTOCadastroCliente data){
        clienteRepository.save(new Cliente(data));
        return ResponseEntity.ok().build();
    }
}
