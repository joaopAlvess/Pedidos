package br.com.pedidos.foxpedidos.dto.Produto;

import java.math.BigDecimal;
import java.util.Optional;

public record DTOEditarProduto(
        Optional<String> nome,
        Optional<BigDecimal> valor
) {
}
