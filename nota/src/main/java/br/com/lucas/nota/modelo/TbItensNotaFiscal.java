package br.com.lucas.nota.modelo;

import java.util.ArrayList;
import java.util.List;

public class TbItensNotaFiscal {

	private Integer id;
	private Integer sequencial;
	private Integer produto;
	private Integer quantidade;
	private double valorUnitario;
	private double valorTotal;
	private String notaFiscal;	
	private List<TbProduto> produtos = new ArrayList<TbProduto>();
	
	public TbItensNotaFiscal(Integer sequencial, Integer produto, Integer quantidade, double valorUnitario, 
			double valorTotal, String notaFiscal) {
		super();
		this.sequencial = sequencial;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
		this.notaFiscal = notaFiscal;
	}
	
	public TbItensNotaFiscal(Integer id, Integer sequencial, Integer produto, Integer quantidade, double valorUnitario, 
			Double valorTotal, String notaFiscal) {
		this.id = id;
		this.sequencial = sequencial;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
		this.notaFiscal = notaFiscal;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSequencial() {
		return sequencial;
	}
	
	public Integer getProduto() {
		return produto;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public Double getValorUnitario() {
		return valorUnitario;
	}
	
	public Double getValorTotal() {
		return valorTotal;
	}
	
	public String getNotaFiscal() {
		return notaFiscal;
	}
	
	@Override
	public String toString() {
		return String.format("Itens Nota Fiscal: %d, %s, %s, %s, %s, %s, %s ", 
				this.id, this.sequencial, this.produto, this.quantidade, this.valorUnitario, this.valorTotal, 
				this.notaFiscal);
	}
	
	public List<TbProduto> getProdutos() {
		return produtos;
	}
	
}
