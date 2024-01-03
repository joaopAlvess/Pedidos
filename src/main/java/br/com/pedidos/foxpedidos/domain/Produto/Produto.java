package br.com.pedidos.foxpedidos.domain.Produto;

import br.com.pedidos.foxpedidos.domain.Cliente.Cliente;
import br.com.pedidos.foxpedidos.dto.Produto.DTOCadastroProduto;
import br.com.pedidos.foxpedidos.dto.Produto.DTODetalhesProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "produtos")
@Entity(name = "Produto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Produto {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String valor;
//    @OneToMany(mappedBy = "produto")
//    private List<Cliente> clientes;

    public Produto(DTOCadastroProduto data){
        this.nome = data.nome();
        this.valor = data.valor();
    }

    public DTODetalhesProduto toDTODetalhesProduto() {
      return new DTODetalhesProduto(
              this.id,
              this.nome,
              this.valor
      );
    };

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getValor() {
        return valor;
    }

    public void setNome(String nome) {
         this.nome = nome;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
