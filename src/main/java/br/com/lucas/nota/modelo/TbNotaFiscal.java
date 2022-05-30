package br.com.lucas.nota.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "nota_fiscal")
public class TbNotaFiscal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idnota_fiscal;
	
	private String numero_nf;
	
	@ManyToOne
	@JoinColumn(name = "cliente")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idcliente")
	private TbCliente cliente;
	
	private String data_compra;
	
	@OneToMany(mappedBy="nota_fiscal", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TbItensNotaFiscal> itens = new ArrayList<TbItensNotaFiscal>();
	

	public void setIdnota_fiscal(Integer idnota_fiscal) {
		this.idnota_fiscal = idnota_fiscal;
	}
	
	public Integer getIdnota_fiscal() {
		return idnota_fiscal;
	}

	public void setNumero_nf(String numero_nf) {
		this.numero_nf = numero_nf;
	}
	
	public String getNumeroNf() {
		return numero_nf;
	}

	public void setCliente(TbCliente cliente) {
		this.cliente = cliente;
	}
	
	public TbCliente getCliente() {
		return cliente;
	}
	
	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}

	public String getDataCompra() {
		return data_compra;
	}
	
	public void setItens(List<TbItensNotaFiscal> itens) {
		this.itens = itens;
	}
	
	public List<TbItensNotaFiscal> getItens() {
		return itens;
	}
}
