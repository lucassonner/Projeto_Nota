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

import br.com.lucas.nota.modelo.TbNotaFiscal;
import br.com.lucas.nota.repository.TbNotaFiscalRepository;

@RestController 
@RequestMapping(value = "/notafiscal")
public class NotasFiscais {
	
	final TbNotaFiscalRepository notaFiscalRepository;

    public NotasFiscais(TbNotaFiscalRepository notaFiscalRepository) {
        this.notaFiscalRepository = notaFiscalRepository;
    }

    @GetMapping("/")
    public List<TbNotaFiscal> listaNotas() {
        return notaFiscalRepository.findAll();
    }

    @GetMapping("/{idnota_fiscal}")
    public TbNotaFiscal listaNota(@PathVariable(value = "idnota_fiscal") Integer idnota_fiscal) {
    	TbNotaFiscal notaFiscal = notaFiscalRepository.findById(idnota_fiscal); 
        return notaFiscal;
    }

    @PostMapping("/")
    public TbNotaFiscal salvaNotaFiscal(@RequestBody TbNotaFiscal cadastronota) {
        return notaFiscalRepository.save(cadastronota);
    }

    @PutMapping("/")
    public TbNotaFiscal alteraNotaFiscal(@RequestBody TbNotaFiscal nota) {
        return notaFiscalRepository.save(nota);
    }

    @DeleteMapping("/")
    public void deletaNota(@RequestBody TbNotaFiscal nota) {
    	notaFiscalRepository.delete(nota);
    }

} 

