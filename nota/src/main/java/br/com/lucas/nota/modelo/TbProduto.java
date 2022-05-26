package br.com.lucas.nota.modelo;

public class TbProduto {

	private Integer id;
	private Integer codigo;
	private String descricao;
	private double valor_unitario;
	
	public TbProduto(Integer codigo, String descricao, double valor_unitario) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor_unitario = valor_unitario;
	}
	
	public TbProduto(Integer id, Integer codigo, String descricao, double valor_unitario) {
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor_unitario = valor_unitario;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValor_unitario() {
		return valor_unitario;
	}
	
	@Override
	public String toString() {
		return String.format("Produto: %d, %s, %s, %s ", 
				this.id, this.codigo, this.descricao, this.valor_unitario);
	}
	
}
