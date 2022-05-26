package br.com.lucas.nota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.lucas.nota.modelo.TbCliente;

public class Clientes {
	
	private Connection connection;
	
	public Clientes(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(TbCliente cliente) throws SQLException {
		
		String sql = "INSERT INTO cliente (codigo, nome) VALUES (?, ?)";
		
		try(PreparedStatement stm = 
				connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			stm.setInt(1, cliente.getCodigo());
			stm.setString(2, cliente.getNome());
			
			stm.execute();
			
			try(ResultSet rst = stm.getGeneratedKeys()) {
				while(rst.next()) {
					cliente.setId(rst.getInt(1));
				}
			}
		}
	}
	
	public List<TbCliente> listar() throws SQLException {
		List<TbCliente> clientes = new ArrayList<TbCliente>();
		
		String sql = "SELECT idcliente, codigo, nome FROM cliente";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			stm.execute();
			
			try(ResultSet rst = stm.getResultSet()){
				while(rst.next()) {
					TbCliente cliente = new TbCliente(rst.getInt(1), rst.getInt(2), rst.getString(3));
					
					clientes.add(cliente);
				}
			}
		}
		return clientes;
	}
} 

