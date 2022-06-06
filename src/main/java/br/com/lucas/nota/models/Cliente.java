package br.com.lucas.nota.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.lucas.nota.repository.ClienteRepository;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull @NotEmpty
	private String codigo;
	
	@NotNull @NotEmpty
	private String nome;
	
		
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cliente alteraCliente(Integer id, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.findById(id).get();
		
		cliente.setCodigo(this.codigo);
		cliente.setNome(this.nome);
		
		return cliente;		
	}

}
