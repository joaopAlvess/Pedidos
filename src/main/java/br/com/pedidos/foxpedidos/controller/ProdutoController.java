package br.com.pedidos.foxpedidos.controller;


import br.com.pedidos.foxpedidos.dto.Produto.DTOEditarProduto;
import br.com.pedidos.foxpedidos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.pedidos.foxpedidos.domain.Produto.Produto;
import br.com.pedidos.foxpedidos.dto.Produto.DTOCadastroProduto;
import br.com.pedidos.foxpedidos.repository.Produto.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid DTOCadastroProduto data){
        produtoRepository.save(new Produto(data));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<Produto>> listar(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        Page<Produto> produtos = produtoRepository.findAll(paginacao);
        return ResponseEntity.ok(produtos);
    }

    @PutMapping("/{produtoId}")
    @Transactional
    public ResponseEntity<Produto> atualizar(@PathVariable Long produtoId, @RequestBody DTOEditarProduto dtoEditarProduto) {

        Produto produtoAtt = produtoService.editarProduto(produtoId, dtoEditarProduto);
        return ResponseEntity.ok(produtoAtt);
    }
}
