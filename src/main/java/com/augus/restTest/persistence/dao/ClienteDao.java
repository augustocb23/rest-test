package com.augus.restTest.persistence.dao;

import com.augus.restTest.domain.Cliente;

import java.util.List;

public interface ClienteDao {

	void save(Cliente cliente);

	void update(Cliente cliente);

	void delete(Long id);

	Cliente findById(Long id);

	List<Cliente> findAll();
}
