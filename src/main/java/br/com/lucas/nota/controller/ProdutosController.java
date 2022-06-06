package br.com.lucas.nota.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.nota.models.Produto;
import br.com.lucas.nota.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/produto")

public class ProdutosController {
	
	 	final
	    ProdutoRepository  produtoRepository;

	    public ProdutosController(ProdutoRepository produtoRepository) { 
	    	this.produtoRepository = produtoRepository;
	    }

	    @GetMapping("/")
	    public List<Produto> listaTodosProdutos() {
	        return produtoRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public Produto listarProduto(@PathVariable Integer id) {
	        return produtoRepository.findById(id).get();
	    }

	    @PostMapping("/")
	    @Transactional
	    public Produto salvarProduto(@RequestBody @Valid Produto produto){
	        return produtoRepository.save(produto); 
	    }

	    @PutMapping("/{id}")
	    @Transactional
	    public Produto alteraProduto(@PathVariable Integer id, @RequestBody @Valid Produto produto) {
	    	Produto atualizaProduto = produto.alteraProduto(id, produtoRepository);
	    	return atualizaProduto;
	    }

	    @DeleteMapping("/{id}")
	    @Transactional
	    public void deletaProduto(@PathVariable Integer id){
	        produtoRepository.deleteById(id);
	    }
} 

