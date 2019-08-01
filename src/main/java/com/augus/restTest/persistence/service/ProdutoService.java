package com.augus.restTest.persistence.service;

import com.augus.restTest.domain.Produto;
import com.augus.restTest.domain.dto.LazyList;
import com.augus.restTest.domain.helpers.BuscaLazyParams;

import java.util.List;

public interface ProdutoService {
    void salvar(Produto produto);

    void editar(Produto produto);

    void excluir(Long id);

    Produto buscarPorId(Long id);

    List<Produto> buscarTodos();

    LazyList<Produto> buscarLazy(BuscaLazyParams params);
}
