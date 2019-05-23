package com.augus.restTest.persistence.service;

import com.augus.restTest.domain.Pedido;
import com.augus.restTest.persistence.dao.PedidoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {
	private final PedidoDao dao;

	@Autowired
	public PedidoServiceImpl(PedidoDao dao) {
		this.dao = dao;
	}

	@Transactional
	public void salvar(Pedido pedido) {
		dao.save(pedido);
	}

	@Transactional
	public void editar(Pedido pedido) {
		dao.update(pedido);
	}

	@Transactional
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	public Pedido buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	public List<Pedido> buscarTodos() {
		return dao.findAll();
	}
}
