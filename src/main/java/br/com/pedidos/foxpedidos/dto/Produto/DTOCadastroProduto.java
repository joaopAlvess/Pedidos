package br.com.pedidos.foxpedidos.dto.Produto;

import jakarta.validation.constraints.NotBlank;

public record DTOCadastroProduto(
    

    String nome,
    String valor

) {
    
}
