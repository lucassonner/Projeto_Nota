package br.com.lucas.nota.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.nota.models.ItensNotaFiscal;

public interface ItemNotaFiscalRepository extends JpaRepository<ItensNotaFiscal, Integer> {
		Optional<ItensNotaFiscal> findById(Integer id);
}
