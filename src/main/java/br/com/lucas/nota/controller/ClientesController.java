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

import br.com.lucas.nota.models.Cliente;
import br.com.lucas.nota.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/cliente")
public class ClientesController {
	
		final
	    ClienteRepository clienteRepository;

	    public ClientesController(ClienteRepository clienteRepository) {
	        this.clienteRepository = clienteRepository;
	    }

	    @GetMapping("/")
	    public List<Cliente> listaClientes() {
	        return clienteRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public Cliente listaCliente(@PathVariable(value = "id") Integer id) {
	        return clienteRepository.findById(id).get();
	    }

	    @PostMapping("/")
	    public Cliente salvarCliente(@RequestBody Cliente cliente) {
	        return clienteRepository.save(cliente);
	    }

	    @PutMapping("/")
	    public Cliente alteraCliente(@RequestBody Cliente cliente) {
	        return clienteRepository.save(cliente);
	    }

	    @DeleteMapping("/")
	    public void deletaCliente(@RequestBody Cliente cliente) {
	      clienteRepository.delete(cliente);
	    }
} 

