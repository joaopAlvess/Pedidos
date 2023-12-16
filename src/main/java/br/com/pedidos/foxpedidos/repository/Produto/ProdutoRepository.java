package br.com.pedidos.foxpedidos.repository.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedidos.foxpedidos.domain.Produto.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
