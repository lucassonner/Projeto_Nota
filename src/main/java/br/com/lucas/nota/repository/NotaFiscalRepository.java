package br.com.lucas.nota.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucas.nota.models.NotaFiscal;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Integer> {
		Optional<NotaFiscal> findById(Integer idnota_fiscal);
}
