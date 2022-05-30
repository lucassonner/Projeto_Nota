package br.com.lucas.nota.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itens_nf")
public class TbItensNotaFiscal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iditens_nf;
	
	private Integer sequencial;
	
	@OneToOne
	@JoinColumn(name = "produto")
	private TbProduto produto;
	
	private Integer quantidade;
	private double valor_unit;
	private double valor_total;
	
	@ManyToOne
    @JoinColumn(name="nota_fiscal")
	private TbNotaFiscal nota_fiscal;	
	
	public void setIditens_nf(Integer iditens_nf) {
		this.iditens_nf = iditens_nf;
	}
	
	public Integer getIditens_nf() {
		return iditens_nf;
	}

	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}
	
	public Integer getSequencial() {
		return sequencial;
	}
	
	public void setProduto(TbProduto produto) {
		this.produto = produto;
	}
	
	public TbProduto getProduto() {
		return produto;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
		
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setValor_unit(double valor_unit) {
		this.valor_unit = valor_unit;
	}
	
	public Double getValorUnitario() {
		return valor_unit;
	}
	
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	
	public Double getValorTotal() {
		return valor_total;
	}
	
	public void setNota_fiscal(TbNotaFiscal nota_fiscal) {
		this.nota_fiscal = nota_fiscal;
	}
	
	public TbNotaFiscal getNotaFiscal() {
		return nota_fiscal;
	}
		
}
