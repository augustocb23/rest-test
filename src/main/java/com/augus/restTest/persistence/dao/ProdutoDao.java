package com.augus.restTest.persistence.dao;

import com.augus.restTest.domain.Produto;
import com.augus.restTest.domain.helpers.BuscaLazyParams;

import javax.persistence.TypedQuery;
import java.util.List;

public interface ProdutoDao {

	void save(Produto produto);

	void update(Produto produto);

	void delete(Long id);

	Produto findById(Long id);

	List<Produto> findAll();

	List<Produto> findPage(BuscaLazyParams params);
}
