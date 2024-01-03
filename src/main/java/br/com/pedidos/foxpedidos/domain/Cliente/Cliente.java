package br.com.pedidos.foxpedidos.domain.Cliente;

import br.com.pedidos.foxpedidos.domain.Produto.Produto;
import br.com.pedidos.foxpedidos.dto.Cliente.DTOCadastroCliente;
import br.com.pedidos.foxpedidos.dto.Cliente.DTOEditarCliente;
import br.com.pedidos.foxpedidos.dto.Cliente.DTOListarCliente;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

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
    @Column(name = "valor_adicional")
    private BigDecimal valorAdicional;
    private boolean ativo;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Cliente(DTOCadastroCliente data) {
        this.ativo = true;
        this.nome = data.nome();
        this.endereco = data.endereco();
        this.telefone = data.telefone();
        this.valorAdicional = new BigDecimal(data.valorAdicional());
    }

    public DTOListarCliente toDTOListarCliente() {
      return new DTOListarCliente(
              this.id,
              this.nome,
              this.telefone,
              this.valorAdicional,
              this.produto != null ? this.produto.toDTODetalhesProduto(): null
      );
    };

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
