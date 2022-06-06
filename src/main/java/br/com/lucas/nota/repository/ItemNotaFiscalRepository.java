package br.com.lucas.nota.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucas.nota.models.ItensNotaFiscal;

@Repository
public interface ItemNotaFiscalRepository extends JpaRepository<ItensNotaFiscal, Integer> {
		Optional<ItensNotaFiscal> findById(Integer id);
}
