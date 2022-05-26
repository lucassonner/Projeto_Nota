package br.com.lucas.nota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.lucas.nota.modelo.TbItensNotaFiscal;
import br.com.lucas.nota.modelo.TbProduto;

public class ItensNotasFiscais {
	
	private Connection connection;
	
	public ItensNotasFiscais(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(TbItensNotaFiscal itensNotaFiscal) throws SQLException {
		
		String sql = "INSERT INTO itens_nf (sequencial, produto, quantidade, valor_unit, valor_total, nota_fiscal)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement stm = 
				connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			stm.setInt(1, itensNotaFiscal.getSequencial());
			stm.setInt(2, itensNotaFiscal.getProduto());
			stm.setInt(3, itensNotaFiscal.getQuantidade());
			stm.setDouble(4, itensNotaFiscal.getValorUnitario());
			stm.setDouble(5, itensNotaFiscal.getValorTotal());
			stm.setString(6, itensNotaFiscal.getNotaFiscal());
			
			stm.execute();
			
			try(ResultSet rst = stm.getGeneratedKeys()) {
				while(rst.next()) {
					itensNotaFiscal.setId(rst.getInt(1));
				}
			}
		}
	}
	
	public List<TbItensNotaFiscal> listar() throws SQLException {
		List<TbItensNotaFiscal> itensNotasFiscais = new ArrayList<TbItensNotaFiscal>();
		
		String sql = "SELECT I.iditens_nf, I.sequencial, I.produto, P.codigo, P.descricao, I.quantidade, P.valor_unitario,"
				+ "I.valor_total, N.numero_nf FROM itens_nf I INNER JOIN produto P ON I.produto = P.idproduto "
				+ "INNER JOIN nota.nota_fiscal N ON I.nota_fiscal = N.numero_nf";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			stm.execute();
			
			try(ResultSet rst = stm.getResultSet()){
				while(rst.next()) {
					TbItensNotaFiscal itensNotafiscal = new TbItensNotaFiscal(rst.getInt(1), rst.getInt(2), 
							rst.getInt(3), rst.getInt(6), rst.getDouble(7), rst.getDouble(8), rst.getString(9));
					
					itensNotasFiscais.add(itensNotafiscal);
					
					@SuppressWarnings("unused")
					TbProduto produto = new TbProduto(null, rst.getInt(4), rst.getString(5), 0);
				}
			}
		}
		return itensNotasFiscais;
	}
} 

