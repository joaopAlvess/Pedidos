package br.com.pedidos.foxpedidos.dto.Cliente;

import br.com.pedidos.foxpedidos.dto.Produto.DTODetalhesProduto;

public record DTOListarCliente(
        Long id,
        String nome,
        String telefone,
        String valorAdicional,
        DTODetalhesProduto produto
) {
}
