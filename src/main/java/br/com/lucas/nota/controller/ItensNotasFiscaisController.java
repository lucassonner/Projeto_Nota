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

import br.com.lucas.nota.models.ItensNotaFiscal;
import br.com.lucas.nota.repository.ItemNotaFiscalRepository;

@RestController
@RequestMapping(value = "/itensnotafiscal")
public class ItensNotasFiscaisController {
	
	final ItemNotaFiscalRepository itemNotaFiscalRepository;
    public ItensNotasFiscaisController(ItemNotaFiscalRepository itemNotaFiscalRepository) {
        this.itemNotaFiscalRepository = itemNotaFiscalRepository;
    }

    @GetMapping("/")
    public List<ItensNotaFiscal> listaItensNotaFiscal() {
        return itemNotaFiscalRepository.findAll();
    }

    @GetMapping("/{id}")
    public ItensNotaFiscal listaItensNotaFiscal(@PathVariable(value = "id") Integer id){
        return itemNotaFiscalRepository.findById(id).get();
    }
    
    @PostMapping("/")
    public ItensNotaFiscal salvaItemNotaFiscal(@RequestBody ItensNotaFiscal itensNota){
        return itemNotaFiscalRepository.save(itensNota);
    }

    @PutMapping("/")
    public ItensNotaFiscal alteraItensNotaFiscal(@RequestBody ItensNotaFiscal itensNota) {
        return itemNotaFiscalRepository.save(itensNota);
}

    @DeleteMapping("/")
    public void deletaItemNotaFiscal(@RequestBody ItensNotaFiscal itensNota) {
    	itemNotaFiscalRepository.delete(itensNota);
    }
    
} 

