package br.com.pedidos.foxpedidos.Domain.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "clientes")
@Entity(name = "Cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String valorAdicional;
    private Boolean ativo;

    public Cliente(DTOCadastroCliente data){
        this.ativo = true;
        this.nome = data.nome();
        this.endereco = data.endereco();
        this.telefone = data.telefone();
        this.valorAdicional = data.valorAdicional();
    }

    public void exclusao(){
        this.ativo = false;
    }

}
