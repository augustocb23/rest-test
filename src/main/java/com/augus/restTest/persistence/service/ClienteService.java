package com.augus.restTest.persistence.service;

import com.augus.restTest.domain.Cliente;

import java.util.List;

public interface ClienteService {
	void salvar(Cliente cliente);

	void editar(Cliente cliente);

	void excluir(Long id);

	Cliente buscarPorId(Long id);

	List<Cliente> buscarTodos();
}
