package br.com.pedidos.foxpedidos.service;

import br.com.pedidos.foxpedidos.domain.Produto.Produto;
import br.com.pedidos.foxpedidos.dto.Produto.DTOEditarProduto;
import br.com.pedidos.foxpedidos.repository.Produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto editarProduto(Long produtoId, DTOEditarProduto dtoEditarProduto) {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("O ID de produto não foi encontrado."));

        dtoEditarProduto.nome().ifPresent(produto::setNome);
        dtoEditarProduto.valor().ifPresent(produto::setValor);

        Produto produtoAtt = produtoRepository.save(produto);
        return produtoAtt;
    }
}
