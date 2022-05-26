package br.com.lucas.nota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.lucas.nota.modelo.TbCliente;
import br.com.lucas.nota.modelo.TbNotaFiscal;

public class NotasFiscais {
	
	private Connection connection;
	
	public NotasFiscais(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(TbNotaFiscal notaFiscal) throws SQLException {
		
		String sql = "INSERT INTO nota_fiscal (numero_nf, cliente, data_compra) VALUES (?, ?, ?)";
		
		try(PreparedStatement stm = 
				connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			stm.setString(1, notaFiscal.getNumeroNf());
			stm.setInt(2, notaFiscal.getCliente());
			stm.setString(3, notaFiscal.getDataCompra());
			
			stm.execute();
			
			try(ResultSet rst = stm.getGeneratedKeys()) {
				while(rst.next()) {
					notaFiscal.setId(rst.getInt(1));
				}
			}
		}
	}
	
	public List<TbNotaFiscal> listar() throws SQLException {
		List<TbNotaFiscal> notasFiscais = new ArrayList<TbNotaFiscal>();
		
		String sql = "SELECT N.idnota_fiscal, N.numero_nf, N.cliente, C.nome, N.data_compra FROM nota_fiscal N INNER "
				+ "JOIN cliente C ON N.cliente = C.idcliente";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			stm.execute();
			
			try(ResultSet rst = stm.getResultSet()){
				while(rst.next()) {
					TbNotaFiscal notafiscal = new TbNotaFiscal(rst.getInt(1), rst.getString(2), rst.getInt(3), rst.getString(5));
					
					notasFiscais.add(notafiscal);
					
					@SuppressWarnings("unused")
					TbCliente cliente = new TbCliente(null, null, rst.getString(4));
				}
			}
		}
		return notasFiscais;
	}
} 

