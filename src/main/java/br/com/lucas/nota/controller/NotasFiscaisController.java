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

import br.com.lucas.nota.models.NotaFiscal;
import br.com.lucas.nota.repository.NotaFiscalRepository;

@RestController 
@RequestMapping(value = "/notafiscal")
public class NotasFiscaisController {
	
		final 
		NotaFiscalRepository notaFiscalRepository;
	
	    public NotasFiscaisController(NotaFiscalRepository notaFiscalRepository) {
	        this.notaFiscalRepository = notaFiscalRepository;
	    }
	
	    @GetMapping("/")
	    public List<NotaFiscal> listaTodasNotas() {
	        return notaFiscalRepository.findAll();
	    }
	
	    @GetMapping("/{id}")
	    public NotaFiscal listaNota(@PathVariable Integer id) {
	    	return notaFiscalRepository.findById(id).get(); 
	    }
	
	    @PostMapping("/")
	    @Transactional
	    public NotaFiscal salvaNotaFiscal(@RequestBody @Valid NotaFiscal nota) {
	        return notaFiscalRepository.save(nota);
	    }
	
	    @PutMapping("/{id}")
	    @Transactional
	    public NotaFiscal alteraNotaFiscal(@PathVariable Integer id, @RequestBody @Valid NotaFiscal nota) {
	    	NotaFiscal atualizaNotaFiscal = nota.alteraNotaFiscal(id, notaFiscalRepository);
	    	return atualizaNotaFiscal;    
	    }
	
	    @DeleteMapping("/{id}")
	    @Transactional
	    public void deletaNota(@PathVariable Integer id) {
	    	notaFiscalRepository.deleteById(id);
	    }
} 

