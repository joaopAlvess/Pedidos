package br.com.pedidos.foxpedidos.dto.Produto;

import java.util.Optional;

public record DTOEditarProduto(
        Optional<String> nome,
        Optional<String> valor
) {
}
