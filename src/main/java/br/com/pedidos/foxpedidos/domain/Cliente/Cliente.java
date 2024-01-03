package br.com.pedidos.foxpedidos.domain.Cliente;

import br.com.pedidos.foxpedidos.domain.Produto.Produto;
import br.com.pedidos.foxpedidos.dto.Cliente.DTOCadastroCliente;
import br.com.pedidos.foxpedidos.dto.Cliente.DTOEditarCliente;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
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
    private boolean ativo;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Cliente(DTOCadastroCliente data) {
        this.ativo = true;
        this.nome = data.nome();
        this.endereco = data.endereco();
        this.telefone = data.telefone();
        this.valorAdicional = data.valorAdicional();
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
