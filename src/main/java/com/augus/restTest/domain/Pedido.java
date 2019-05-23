package com.augus.restTest.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Pedido extends AbstractEntity<Long> {
	@ManyToOne
	@JoinColumn(name = "produto", nullable = false)
	private Produto produto;
	@ManyToOne
	@JoinColumn(name = "cliente", nullable = false)
	private Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
