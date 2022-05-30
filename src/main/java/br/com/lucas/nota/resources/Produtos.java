package br.com.lucas.nota.resources;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.nota.modelo.TbProduto;
import br.com.lucas.nota.repository.TbProdutoRepository;

@RestController
@RequestMapping(value = "/produto")

public class Produtos {
	
	 	final
	    TbProdutoRepository  produtoRepository;

	    public Produtos(TbProdutoRepository produtoRepository){ this.produtoRepository = produtoRepository;}

	    @GetMapping("/")
	    public List<TbProduto> listaProdutos(){
	        return produtoRepository.findAll();
	    }

	    @GetMapping("/{idproduto}")
	    public TbProduto listaProduto(@PathVariable(value = "idproduto") Integer idproduto){
	        TbProduto produto =  produtoRepository.findById(idproduto);
	        return produto; }

	    @PostMapping("/")
	    public TbProduto salvaProduto(@RequestBody TbProduto cadastroProduto){
	        return produtoRepository.save(cadastroProduto); }

	    @PutMapping("/")
	    public TbProduto alteraProduto(@RequestBody TbProduto produto) {
	        return produtoRepository.save(produto);
	    }

	    @DeleteMapping("/")
	    public void deletaProduto(@RequestBody TbProduto produto){
	        produtoRepository.delete(produto);
	    }
} 

