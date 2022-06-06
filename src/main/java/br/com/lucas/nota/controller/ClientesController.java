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
	    public List<Cliente> listaTodosClientes() {
	        return clienteRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public Cliente listaCliente(@PathVariable Integer id) {
	        return clienteRepository.findById(id).get();
	    }

	    @PostMapping("/")
	    @Transactional
	    public Cliente salvarCliente(@RequestBody @Valid Cliente cliente) {
	        return clienteRepository.save(cliente);
	    }

	    @PutMapping("/{id}")
	    @Transactional
	    public Cliente alteraCliente(@PathVariable Integer id, @RequestBody @Valid Cliente cliente) {
	    	Cliente atualizaCliente = cliente.alteraCliente(id, clienteRepository);
	    	return atualizaCliente;
	    }

	    @DeleteMapping("/{id}")
	    @Transactional
	    public void deletaCliente(@PathVariable Integer id) {
	      clienteRepository.deleteById(id);
	    }
}
