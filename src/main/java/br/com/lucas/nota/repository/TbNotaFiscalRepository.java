package br.com.lucas.nota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.nota.modelo.TbNotaFiscal;

public interface TbNotaFiscalRepository extends JpaRepository<TbNotaFiscal, Long> {
		TbNotaFiscal findById(Integer idnota_fiscal);
}
