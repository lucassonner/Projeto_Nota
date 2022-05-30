package br.com.lucas.nota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.nota.modelo.TbProduto;

public interface TbProdutoRepository extends JpaRepository<TbProduto, Long> {
		TbProduto findById(Integer idproduto);
	}
