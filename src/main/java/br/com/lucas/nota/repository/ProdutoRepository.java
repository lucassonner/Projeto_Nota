package br.com.lucas.nota.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.nota.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
		Optional<Produto> findById(Integer idproduto);
	}
