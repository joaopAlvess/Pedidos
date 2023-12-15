package br.com.pedidos.foxpedidos.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.foxpedidos.Domain.Cliente.DTOCadastroCliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    public ResponseEntity cadastrar(@RequestBody DTOCadastroCliente data){
        return ResponseEntity.ok(data);
    }
}
