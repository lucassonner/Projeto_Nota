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

import br.com.lucas.nota.modelo.TbCliente;
import br.com.lucas.nota.repository.TbClienteRepository;

@RestController
@RequestMapping(value = "/cliente")
public class Clientes {
	
	 final
	    TbClienteRepository clienteRepository;

	    public Clientes(TbClienteRepository clienteRepository) {
	        this.clienteRepository = clienteRepository;
	    }

	    @GetMapping("/")
	    public List<TbCliente> listaClientes() {
	        return clienteRepository.findAll();
	    }

	    @GetMapping("/{idcliente}")
	    public TbCliente listaClienteUnico(@PathVariable(value = "idcliente") Integer idcliente) {
	        return clienteRepository.findById(idcliente);
	    }

	    @PostMapping("/")
	    public TbCliente salvarCliente(@RequestBody TbCliente cliente) {
	        return clienteRepository.save(cliente);
	    }

	    @PutMapping("/")
	    public TbCliente alteraCliente(@RequestBody TbCliente cliente) {
	        return clienteRepository.save(cliente);
	    }

	    @DeleteMapping("/")
	    public void deletaCliente(@RequestBody TbCliente cliente) {
	      clienteRepository.delete(cliente);
	    }
} 

