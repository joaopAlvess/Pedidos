package br.com.pedidos.foxpedidos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.foxpedidos.domain.Cliente.Cliente;
import br.com.pedidos.foxpedidos.dto.Cliente.DTOCadastroCliente;
import br.com.pedidos.foxpedidos.repository.Cliente.ClienteRepository;

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

    @GetMapping    
    public ResponseEntity<Page<Cliente>> listar(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        Page<Cliente> clientes = clienteRepository.findAll(paginacao);
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping
    public ResponseEntity<Void> exclusaoLogicaTodos(){

    }
}
