package br.com.lucas.nota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemocaoBancoNota {

	public static void main(String[] args) throws SQLException {

		ConexaoBancoNota conBancoNota = new ConexaoBancoNota();
		Connection connection = conBancoNota.recuperarConexao();
				
		PreparedStatement stm = connection.prepareStatement("DELETE FROM produto WHERE idproduto > ?");
		stm.setInt(1, 2);
		stm.execute();
		
		Integer linhasApagadas = stm.getUpdateCount();
		
		System.out.println("Linhas apagadas: " + linhasApagadas);
		
		connection.close();
	}

}
