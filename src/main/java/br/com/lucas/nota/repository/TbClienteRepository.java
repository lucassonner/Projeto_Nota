package br.com.lucas.nota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.nota.modelo.TbCliente;

public interface TbClienteRepository extends JpaRepository<TbCliente, Long> {
		TbCliente findById(Integer idcliente);

}
