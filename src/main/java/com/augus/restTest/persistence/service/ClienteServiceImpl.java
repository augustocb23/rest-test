package com.augus.restTest.persistence.service;

import com.augus.restTest.domain.Cliente;
import com.augus.restTest.persistence.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
	private final ClienteDao dao;

	@Autowired
	public ClienteServiceImpl(ClienteDao dao) {
		this.dao = dao;
	}

	@Transactional
	public void salvar(Cliente cliente) {
		dao.save(cliente);
	}

	@Transactional
	public void editar(Cliente cliente) {
		dao.update(cliente);
	}

	@Transactional
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	public Cliente buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	public List<Cliente> buscarTodos() {
		return dao.findAll();
	}

}
