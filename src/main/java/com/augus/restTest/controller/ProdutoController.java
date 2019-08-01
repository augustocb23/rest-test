package com.augus.restTest.controller;

import com.augus.restTest.domain.Produto;
import com.augus.restTest.domain.helpers.BuscaLazyParams;
import com.augus.restTest.persistence.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/produtos")
@Api(value = "produtos", tags = {"produtos"})
public class ProdutoController {
    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService service) {
        this.produtoService = service;
    }

    @ApiOperation(value = "Lista de produtos", response = List.class)
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Produto> buscarTodos(@RequestParam String filter,
                                     @RequestParam String sortOrder,
                                     @RequestParam String sortColumn,
                                     @RequestParam String pageNumber,
                                     @RequestParam String pageSize) {
        BuscaLazyParams params;
        try {
            params = new BuscaLazyParams(filter, sortOrder,sortColumn, pageNumber, pageSize);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parâmetros inválidos: " + e.getMessage());
        }
        return produtoService.buscarLazy(params);
    }

    @ApiOperation(value = "Buscar produto por ID", response = Produto.class)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Produto buscarPorId(@ApiParam(value = "ID do produto")
                               @PathVariable String id) {
        return produtoService.buscarPorId(Long.parseLong(id));
    }

    @ApiOperation(value = "Cadastrar produto", response = Produto.class)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Produto salvar(@RequestBody Produto produto) {
        produtoService.salvar(produto);
        return produto;
    }

    @ApiOperation(value = "Editar produto", response = Produto.class)
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Produto editar(@ApiParam(value = "ID do produto")
                          @PathVariable String id, @RequestBody Produto produto) {
        if (Long.parseLong(id) != produto.getId())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Código do objeto difere da requisição");
        produtoService.editar(produto);
        return produto;
    }

    @ApiOperation(value = "Excluir produto", response = void.class)
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void excluir(@ApiParam(value = "ID do produto")
                        @PathVariable String id) {
        produtoService.excluir(Long.parseLong(id));
    }
}
