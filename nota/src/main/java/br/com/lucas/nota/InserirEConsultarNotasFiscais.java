package br.com.lucas.nota;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.lucas.nota.modelo.TbNotaFiscal;

public class InserirEConsultarNotasFiscais {

	public static void main(String[] args) throws SQLException {

		TbNotaFiscal novaNotaFiscal = new TbNotaFiscal("7894", 2, "24-05-2022");
		
		try(Connection connection = new ConexaoBancoNota().recuperarConexao()){
			NotasFiscais tbNotaFiscal = new NotasFiscais(connection);
			tbNotaFiscal.salvar(novaNotaFiscal);
			
			List<TbNotaFiscal> listaDeNotasFiscais = tbNotaFiscal.listar();
			listaDeNotasFiscais.stream().forEach(lnf -> System.out.println(lnf));
		}	
	}
}
