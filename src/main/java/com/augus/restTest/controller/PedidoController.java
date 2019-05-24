package com.augus.restTest.controller;

import com.augus.restTest.domain.Pedido;
import com.augus.restTest.persistence.service.PedidoService;
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
@RequestMapping("/pedidos")
@Api(value = "pedidos", tags = {"pedidos"})
public class PedidoController {
    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @ApiOperation(value = "Lista de pedidos", response = List.class)
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Pedido> buscarTodos() {
        return pedidoService.buscarTodos();
    }

    @ApiOperation(value = "Buscar pedido por ID", response = Pedido.class)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Pedido buscarPorId(@ApiParam(value = "ID do pedido")
                              @PathVariable String id) {
        return pedidoService.buscarPorId(Long.parseLong(id));

    }

    @ApiOperation(value = "Cadastrar pedido", response = Pedido.class)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Pedido salvar(@RequestBody Pedido pedido) {
        pedidoService.salvar(pedido);
        return pedido;
    }

    @ApiOperation(value = "Editar pedido", response = Pedido.class)
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Pedido editar(@ApiParam(value = "ID do pedido")
                         @PathVariable String id, @RequestBody Pedido pedido) {
        if (Long.parseLong(id) != pedido.getId())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Código do objeto difere da requisição");
        pedidoService.editar(pedido);
        return pedido;
    }

    @ApiOperation(value = "Excluir pedido", response = void.class)
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void excluir(@ApiParam(value = "ID do pedido")
                        @PathVariable String id) {
        pedidoService.excluir(Long.parseLong(id));
    }
}
