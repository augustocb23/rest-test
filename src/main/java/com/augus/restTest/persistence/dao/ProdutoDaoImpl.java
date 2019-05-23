package com.augus.restTest.persistence.dao;

import com.augus.restTest.domain.Produto;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDaoImpl extends AbstractDao<Produto, Long> implements ProdutoDao {
}
