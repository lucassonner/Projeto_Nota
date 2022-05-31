package br.com.lucas.nota.controller;

import java.util.List;

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

	    public ProdutosController(ProdutoRepository produtoRepository){ this.produtoRepository = produtoRepository;}

	    @GetMapping("/")
	    public List<Produto> listaProdutos(){
	        return produtoRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public Produto listarProduto(@PathVariable(value = "id") Integer id){
	        Produto produto =  produtoRepository.findById(id).get();
	        return produto; }

	    @PostMapping("/")
	    public Produto salvarProduto(@RequestBody Produto produto){
	        return produtoRepository.save(produto); }

	    @PutMapping("/")
	    public Produto alteraProduto(@RequestBody Produto produto) {
	        return produtoRepository.save(produto);
	    }

	    @DeleteMapping("/")
	    public void deletaProduto(@RequestBody Produto produto){
	        produtoRepository.delete(produto);
	    }
} 

