package br.com.pedidos.foxpedidos.Domain.Cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DTOCadastroCliente(

        @NotBlank
        String nome,
        String endereco,
        @Pattern(regexp = "\\d{11}")
        String telefone,
        String valorAdicional) {

}
