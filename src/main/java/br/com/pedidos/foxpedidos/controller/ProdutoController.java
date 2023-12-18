package br.com.pedidos.foxpedidos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
