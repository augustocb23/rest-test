package com.augus.restTest.controller;

import com.augus.restTest.domain.Cliente;
import com.augus.restTest.persistence.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	private final ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService service) {
		this.clienteService = service;
	}


	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Cliente> buscarTodos() {
		return clienteService.buscarTodos();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Cliente buscarPorId(@PathVariable String id) {
		return clienteService.buscarPorId(Long.parseLong(id));

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Cliente salvar(@RequestBody Cliente cliente) {
		clienteService.salvar(cliente);
		return cliente;
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Cliente editar(@PathVariable String id, @RequestBody Cliente cliente) {
		if (Long.parseLong(id) != cliente.getId())
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Código do objeto difere da requisição");
		clienteService.editar(cliente);
		return cliente;
	}

	@DeleteMapping(value = "/{id}")
	@ResponseBody
	public void excluir(@PathVariable String id) {
		clienteService.excluir(Long.parseLong(id));
	}
}
