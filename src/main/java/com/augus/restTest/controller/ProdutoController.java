package com.augus.restTest.controller;

import com.augus.restTest.domain.Produto;
import com.augus.restTest.persistence.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	private final ProdutoService produtoService;

	@Autowired
	public ProdutoController(ProdutoService service) {
		this.produtoService = service;
	}

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Produto> buscarTodos() {
		return produtoService.buscarTodos();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Produto buscarPorId(@PathVariable String id) {
		return produtoService.buscarPorId(Long.parseLong(id));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Produto salvar(@RequestBody Produto produto) {
		produtoService.salvar(produto);
		return produto;
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Produto editar(@PathVariable String id, @RequestBody Produto produto) {
		if (Long.parseLong(id) != produto.getId())
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Código do objeto difere da requisição");
		produtoService.editar(produto);
		return produto;
	}

	@DeleteMapping(value = "/{id}")
	@ResponseBody
	public void excluir(@PathVariable String id) {
		produtoService.excluir(Long.parseLong(id));
	}
}
