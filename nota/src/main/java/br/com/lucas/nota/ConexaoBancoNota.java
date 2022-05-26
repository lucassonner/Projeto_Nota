package br.com.lucas.nota;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@SpringBootApplication
public class ConexaoBancoNota {
	
	public DataSource dataSource;
	
	public ConexaoBancoNota() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/nota?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("@XsonnerP");
		
		comboPooledDataSource.setMaxPoolSize(15);
		
		this.dataSource = comboPooledDataSource;
	}

	public Connection recuperarConexao() throws SQLException {		
		return this.dataSource.getConnection();		
	}

}
