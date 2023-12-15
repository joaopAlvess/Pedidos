package br.com.pedidos.foxpedidos.Domain.Produto;

import jakarta.validation.constraints.NotBlank;

public record DTOCadastroProduto(
    
    @NotBlank
    String nome,
    @NotBlank
    String valor

) {
    
}
