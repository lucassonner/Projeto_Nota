package br.com.lucas.nota.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.lucas.nota.repository.ItemNotaFiscalRepository;

@Entity
@Table(name = "itens_nf")
public class ItensNotaFiscal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@NotNull @JsonIgnore
	private NotaFiscal notaFiscal;	
	
	@NotNull
	private Integer sequencial;
	
	@ManyToOne
	private Produto produto;
	
	@NotNull
	private BigDecimal quantidade;
	
	@NotNull
	private BigDecimal valorUnit;
	
	@NotNull
	private BigDecimal valorTotal;
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
	
	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	
	public Integer getSequencial() {
		return sequencial;
	}
	
	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(BigDecimal valorUnit) {
		this.valorUnit = valorUnit;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ItensNotaFiscal alteraItensNotaFiscal(Integer id, ItemNotaFiscalRepository itemNotaFiscalRepository) {
		ItensNotaFiscal itensNota = itemNotaFiscalRepository.findById(id).get();
		
		itensNota.setNotaFiscal(this.notaFiscal);
		itensNota.setSequencial(this.sequencial);
		itensNota.setProduto(this.produto);
		itensNota.setQuantidade(this.quantidade);
		itensNota.setValorUnit(this.valorUnit);
		itensNota.setValorTotal(this.valorTotal);

		return itensNota;
	}

}
