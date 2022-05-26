package br.com.lucas.nota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.lucas.nota.modelo.TbProduto;

public class Produtos {
	
	private Connection connection;
	
	public Produtos(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(TbProduto produto) throws SQLException {
		
		String sql = "INSERT INTO produto (codigo, descricao, valor_unitario) VALUES (?, ?, ?)";
		
		try(PreparedStatement stm = 
				connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			stm.setInt(1, produto.getCodigo());
			stm.setString(2, produto.getDescricao());
			stm.setDouble(3, produto.getValor_unitario());
			
			stm.execute();
			
			try(ResultSet rst = stm.getGeneratedKeys()) {
				while(rst.next()) {
					produto.setId(rst.getInt(1));
				}
			}
		}
	}
	
	public List<TbProduto> listar() throws SQLException {
		List<TbProduto> produtos = new ArrayList<TbProduto>();
		
		String sql = "SELECT idproduto, codigo, descricao, valor_unitario FROM produto";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			stm.execute();
			
			try(ResultSet rst = stm.getResultSet()){
				while(rst.next()) {
					TbProduto produto = new TbProduto(rst.getInt(1), rst.getInt(2), rst.getString(3), rst.getDouble(4));
					
					produtos.add(produto);
				}
			}
		}
		return produtos;
	}
} 

