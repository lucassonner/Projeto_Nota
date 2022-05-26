package br.com.lucas.nota;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.lucas.nota.modelo.TbItensNotaFiscal;

public class InserirEConsultarItensNotasFiscais {

	public static void main(String[] args) throws SQLException {

		TbItensNotaFiscal itensNotaFiscal = new TbItensNotaFiscal(3, 3, 5, 99, 495, "2345");
		
		try(Connection connection = new ConexaoBancoNota().recuperarConexao()){
			ItensNotasFiscais tbItensNotaFiscal = new ItensNotasFiscais(connection);
			tbItensNotaFiscal.salvar(itensNotaFiscal);
			
			List<TbItensNotaFiscal> listaDeItensNotasFiscais = tbItensNotaFiscal.listar();
			listaDeItensNotasFiscais.stream().forEach(linf -> System.out.println(linf));
		}	
	}
}
