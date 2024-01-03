package br.com.pedidos.foxpedidos.dto.Cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DTOCadastroCliente(

        String nome,
        String endereco,
        String telefone,
        String valorAdicional,
        Long produtoId) {


}
