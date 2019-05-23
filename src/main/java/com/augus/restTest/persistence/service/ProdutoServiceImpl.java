package com.augus.restTest.persistence.service;

import com.augus.restTest.domain.Produto;
import com.augus.restTest.persistence.dao.ProdutoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	private final ProdutoDao dao;

	@Autowired
	public ProdutoServiceImpl(ProdutoDao dao) {
		this.dao = dao;
	}

	@Transactional
	public void salvar(Produto produto) {
		dao.save(produto);
	}

	@Transactional
	public void editar(Produto produto) {
		dao.update(produto);
	}

	@Transactional
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	public Produto buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	public List<Produto> buscarTodos() {
		return dao.findAll();
	}
}
