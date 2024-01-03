package br.com.pedidos.foxpedidos.dto.Produto;

import java.math.BigDecimal;

public record DTODetalhesProduto(
        Long id,
        String nome,
        BigDecimal valor
) {
}
