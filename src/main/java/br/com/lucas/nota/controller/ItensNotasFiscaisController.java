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

import br.com.lucas.nota.models.ItensNotaFiscal;
import br.com.lucas.nota.repository.ItemNotaFiscalRepository;

@RestController
@RequestMapping(value = "/itensnotafiscal")
public class ItensNotasFiscaisController {
	
		final 
		ItemNotaFiscalRepository itemNotaFiscalRepository;
		
	    public ItensNotasFiscaisController(ItemNotaFiscalRepository itemNotaFiscalRepository) {
	        this.itemNotaFiscalRepository = itemNotaFiscalRepository;
	    }
	
	    @GetMapping("/")
	    public List<ItensNotaFiscal> listaItensNotaFiscal() {
	        return itemNotaFiscalRepository.findAll();
	    }
	
	    @GetMapping("/{id}")
	    public ItensNotaFiscal listaItensNotaFiscal(@PathVariable Integer id){
	        return itemNotaFiscalRepository.findById(id).get();
	    }
	    
	    @PostMapping("/")
	    @Transactional
	    public ItensNotaFiscal salvaItemNotaFiscal(@RequestBody @Valid ItensNotaFiscal itensNota){
	        return itemNotaFiscalRepository.save(itensNota);
	    }
	
	    @PutMapping("/{id}")
	    @Transactional
	    public ItensNotaFiscal alteraItensNotaFiscal(@PathVariable Integer id, @RequestBody @Valid ItensNotaFiscal itensNota) {
	    	ItensNotaFiscal atualizaItensNotaFiscal = itensNota.alteraItensNotaFiscal(id, itemNotaFiscalRepository);
	    	return atualizaItensNotaFiscal;	    		
	    }
	
	    @DeleteMapping("/{id}")
	    @Transactional
	    public void deletaItemNotaFiscal(@PathVariable Integer id) {
	    	itemNotaFiscalRepository.deleteById(id);
	    }
    
} 
