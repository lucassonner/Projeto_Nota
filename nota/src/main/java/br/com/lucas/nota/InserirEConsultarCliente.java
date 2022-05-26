package br.com.lucas.nota;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.lucas.nota.modelo.TbCliente;

public class InserirEConsultarCliente {

	public static void main(String[] args) throws SQLException {

		TbCliente novoCliente = new TbCliente(3333, "JOAQUIM PEREIRA");
		
		try(Connection connection = new ConexaoBancoNota().recuperarConexao()){
			Clientes tbCliente = new Clientes(connection);
			tbCliente.salvar(novoCliente);
			
			List<TbCliente> listaDeClientes = tbCliente.listar();
			listaDeClientes.stream().forEach(lc -> System.out.println(lc));
		}	
	}
}
