package com.augus.restTest.controller;

import com.augus.restTest.domain.Cliente;
import com.augus.restTest.persistence.service.ClienteService;
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
@RequestMapping("/clientes")
@Api(value = "clientes", tags = {"clientes"})
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService service) {
        this.clienteService = service;
    }

    @ApiOperation(value = "Lista de clientes", response = List.class)
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Cliente> buscarTodos() {
        return clienteService.buscarTodos();
    }

    @ApiOperation(value = "Buscar cliente por ID", response = Cliente.class)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Cliente buscarPorId(
            @ApiParam(value = "ID do cliente")
            @PathVariable String id) {
        return clienteService.buscarPorId(Long.parseLong(id));
    }

    @ApiOperation(value = "Cadastrar cliente", response = Cliente.class)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Cliente salvar(@RequestBody Cliente cliente) {
        clienteService.salvar(cliente);
        return cliente;
    }

    @ApiOperation(value = "Editar cliente", response = Cliente.class)
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Cliente editar(@ApiParam(value = "ID do cliente a ser excluído", required = true)
                          @PathVariable String id, @RequestBody Cliente cliente) {
        if (Long.parseLong(id) != cliente.getId())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Código do objeto difere da requisição");
        clienteService.editar(cliente);
        return cliente;
    }

    @ApiOperation(value = "Excluir cliente", response = void.class)
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void excluir(
            @ApiParam(value = "ID do cliente", required = true)
            @PathVariable String id) {
        clienteService.excluir(Long.parseLong(id));
    }
}
