package br.com.lucas.nota.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class TbCliente {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idcliente;
	private Integer codigo;
	private String nome;

	
	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}
	
	public Integer getIdcliente() {
		return idcliente;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
