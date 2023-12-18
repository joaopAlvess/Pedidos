package br.com.pedidos.foxpedidos.controller;

import br.com.pedidos.foxpedidos.dto.Cliente.DTOEditarCliente;
import br.com.pedidos.foxpedidos.dto.Cliente.DTOListarCliente;
import br.com.pedidos.foxpedidos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid DTOCadastroCliente data) {
        clienteRepository.save(new Cliente(data));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/ativar")
    @Transactional
    public ResponseEntity<Void> ativarClientes() {
        clienteService.ativarAll();
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public ResponseEntity<Page<DTOListarCliente>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<DTOListarCliente> dados = clienteService.listarClientes(paginacao);
        return ResponseEntity.ok(dados);
    }

    @PutMapping("/{clienteId}")
    @Transactional
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @RequestBody DTOEditarCliente dtoEditarCliente) {

        Cliente clienteAtt = clienteService.editarCliente(clienteId, dtoEditarCliente);
        return ResponseEntity.ok(clienteAtt);
    }

    @DeleteMapping("/{clienteId}")
    @Transactional
    public ResponseEntity<Void> excluirPorId(@PathVariable Long clienteId) {
        clienteRepository.deleteById(clienteId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> exclusaoLogicaTodos() {
        clienteService.exclusaoLogicaAll();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/excluir")
    @Transactional
    public ResponseEntity<Void> excluir() {
        clienteRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
