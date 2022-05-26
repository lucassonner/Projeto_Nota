package br.com.lucas.nota;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.lucas.nota.modelo.TbProduto;

public class InserirEConsultarProduto {

	public static void main(String[] args) throws SQLException {

		TbProduto novoProduto = new TbProduto(753456, "MOUSE SEM FIO", 99.9);
		
		try(Connection connection = new ConexaoBancoNota().recuperarConexao()){
			Produtos tbProduto = new Produtos(connection);
			tbProduto.salvar(novoProduto);
			
			List<TbProduto> listaDeProdutos = tbProduto.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}	
	}
}
