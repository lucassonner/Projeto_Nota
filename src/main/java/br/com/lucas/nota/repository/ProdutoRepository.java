package br.com.lucas.nota.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucas.nota.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
		Optional<Produto> findById(Integer idproduto);
	}
