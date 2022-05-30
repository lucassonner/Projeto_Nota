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

import br.com.lucas.nota.modelo.TbItensNotaFiscal;
import br.com.lucas.nota.repository.TbItemNotaFiscalRepository;

@RestController
@RequestMapping(value = "/itensnotafiscal")
public class ItensNotasFiscais {
	
	final TbItemNotaFiscalRepository itemNotaFiscalRepository;
    public ItensNotasFiscais(TbItemNotaFiscalRepository itemNotaFiscalRepository) {
        this.itemNotaFiscalRepository = itemNotaFiscalRepository;
    }

    @GetMapping("/")
    public List<TbItensNotaFiscal> listaItensNotaFiscal() {
        return itemNotaFiscalRepository.findAll();
    }

    @GetMapping("/{iditens_nf}")
    public TbItensNotaFiscal listaItensNotaFiscal(@PathVariable(value = "iditens_nf") Integer iditens_nf){
        return itemNotaFiscalRepository.findById(iditens_nf);
    }
    
    @PostMapping("/")
    public TbItensNotaFiscal salvaItemNotaFiscal(@RequestBody TbItensNotaFiscal itensnf){
        return itemNotaFiscalRepository.save(itensnf);
    }

    @PutMapping("/")
    public TbItensNotaFiscal alteraItensNotaFiscal(@RequestBody TbItensNotaFiscal itensnf) {
        return itemNotaFiscalRepository.save(itensnf);
}

    @DeleteMapping("/")
    public void deletaItemNotaFiscal(@RequestBody TbItensNotaFiscal itensnf) {
    	itemNotaFiscalRepository.delete(itensnf);
    }
    
} 

