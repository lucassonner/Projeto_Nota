package br.com.lucas.nota.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class TbProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idproduto;
	private Integer codigo;
	private String descricao;
	private double valor_unitario;
	
	public void setIdproduto(Integer idproduto) {
		this.idproduto = idproduto;
	}
	
	public Integer getIdproduto() {
		return idproduto;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	
	public double getValor_unitario() {
		return valor_unitario;
	}
	
}
