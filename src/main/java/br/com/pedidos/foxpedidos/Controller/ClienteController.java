package br.com.pedidos.foxpedidos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.foxpedidos.Domain.Cliente.ClienteRepository;
import br.com.pedidos.foxpedidos.Domain.Cliente.DTOCadastroCliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public void cadastrar(@RequestBody String data){
        System.out.println(data);
    }
}
