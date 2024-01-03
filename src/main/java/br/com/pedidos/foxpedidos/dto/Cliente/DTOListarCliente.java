package br.com.pedidos.foxpedidos.dto.Cliente;

import br.com.pedidos.foxpedidos.dto.Produto.DTODetalhesProduto;

import java.math.BigDecimal;

public record DTOListarCliente(
        Long id,
        String nome,
        String telefone,
        BigDecimal valorAdicional,
        DTODetalhesProduto produto
) {
}
