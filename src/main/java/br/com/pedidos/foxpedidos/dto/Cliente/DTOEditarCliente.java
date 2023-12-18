package br.com.pedidos.foxpedidos.dto.Cliente;

import java.util.Optional;

public record DTOEditarCliente(
        Optional<String> telefone,
        Optional<String> endereco
) {


}
