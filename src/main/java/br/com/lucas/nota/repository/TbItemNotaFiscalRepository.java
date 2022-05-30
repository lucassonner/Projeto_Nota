package br.com.lucas.nota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.nota.modelo.TbItensNotaFiscal;

public interface TbItemNotaFiscalRepository extends JpaRepository<TbItensNotaFiscal, Long> {
		TbItensNotaFiscal findById(Integer iditens_nf);
}
