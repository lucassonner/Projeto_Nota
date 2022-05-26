package br.com.lucas.nota.modelo;

public class TbCliente {

	private Integer id;
	private Integer codigo;
	private String nome;
	
	public TbCliente(Integer codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public TbCliente(Integer id, Integer codigo, String nome) {
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return String.format("Cliente: %d, %s, %s ", 
				this.id, this.codigo, this.nome);
	}
	
}
