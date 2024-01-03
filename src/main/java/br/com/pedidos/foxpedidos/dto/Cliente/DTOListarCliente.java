package br.com.pedidos.foxpedidos.dto.Cliente;

public record DTOListarCliente(
        Long id,
        String nome,
        String telefone,
        String valorAdicional
) {
}
