package br.com.lucas.nota.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.lucas.nota.repository.ProdutoRepository;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
    @NotNull @NotEmpty
	private String codigo;
    
    @NotNull @NotEmpty
	private String descricao;
    
    @NotNull
	private BigDecimal valorUnitario;
		
	
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
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Produto alteraProduto(Integer id, ProdutoRepository produtoRepository) {
		Produto produto = produtoRepository.findById(id).get();
		
		produto.setCodigo(this.codigo);
		produto.setDescricao(this.descricao);
		produto.setValorUnitario(this.valorUnitario);
		
		return produto;
	}
	
}
