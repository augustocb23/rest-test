package com.augus.restTest.controller;

import com.augus.restTest.domain.Pedido;
import com.augus.restTest.persistence.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	private final PedidoService pedidoService;

	@Autowired
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Pedido> buscarTodos() {
		return pedidoService.buscarTodos();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Pedido buscarPorId(@PathVariable String id) {
		return pedidoService.buscarPorId(Long.parseLong(id));

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Pedido salvar(@RequestBody Pedido pedido) {
		pedidoService.salvar(pedido);
		return pedido;
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Pedido editar(@PathVariable String id, @RequestBody Pedido pedido) {
		if (Long.parseLong(id) != pedido.getId())
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Código do objeto difere da requisição");
		pedidoService.editar(pedido);
		return pedido;
	}

	@DeleteMapping(value = "/{id}")
	@ResponseBody
	public void excluir(@PathVariable String id) {
		pedidoService.excluir(Long.parseLong(id));
	}
}
