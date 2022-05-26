package br.com.lucas.nota.modelo;

import java.util.ArrayList;
import java.util.List;

public class TbNotaFiscal {

	private Integer id;
	private String numeroNf;
	private Integer cliente;
	private String dataCompra;
	private List<TbCliente> clientes = new ArrayList<TbCliente>();
	
	public TbNotaFiscal(String numeroNf, Integer cliente, String dataCompra) {
		super();
		this.numeroNf = numeroNf;
		this.cliente = cliente;
		this.dataCompra = dataCompra;
	}
	
	public TbNotaFiscal(Integer id, String numeroNf, Integer cliente, String dataCompra) {
		this.id = id;
		this.numeroNf = numeroNf;
		this.cliente = cliente;
		this.dataCompra = dataCompra;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroNf() {
		return numeroNf;
	}

	public Integer getCliente() {
		return cliente;
	}

	public String getDataCompra() {
		return dataCompra;
	}
	
	@Override
	public String toString() {
		return String.format("Nota Fiscal: %d, %s, %s, %s ", 
				this.id, this.numeroNf, this.cliente, this.dataCompra);
	}
	
	public List<TbCliente> getClientes() {
		return clientes;
	}
	
}
