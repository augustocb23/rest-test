package com.augus.restTest.persistence.dao;

import com.augus.restTest.domain.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoImpl extends AbstractDao<Cliente, Long> implements ClienteDao {
}
