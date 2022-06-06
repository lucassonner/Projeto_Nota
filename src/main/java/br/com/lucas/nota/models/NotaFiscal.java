package br.com.lucas.nota.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.lucas.nota.repository.NotaFiscalRepository;

@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private Integer numeroNota;
	
	@ManyToOne
	private Cliente cliente;
	
	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dataCompra;
	
	@OneToMany(mappedBy="notaFiscal", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ItensNotaFiscal> itens;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(Integer numeroNota) {
		this.numeroNota = numeroNota;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataCompra() {
		return dataCompra;
	}
	
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public List<ItensNotaFiscal> getItens() {
		return itens;
	}

	public void setItens(List<ItensNotaFiscal> itens) {
		this.itens = itens;
	}

	public NotaFiscal alteraNotaFiscal(Integer id, NotaFiscalRepository notaFiscalRepository) {
		NotaFiscal notaFiscal = notaFiscalRepository.findById(id).get();
		
		notaFiscal.setNumeroNota(this.numeroNota);
		notaFiscal.setCliente(this.cliente);
		notaFiscal.setDataCompra(this.dataCompra);
		notaFiscal.setItens(this.itens);
		
		return notaFiscal;
	}	

}
