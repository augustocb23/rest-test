# Rest Test
API Java [Spring](https://spring.io/) com base de dados [SQLite](http://sqlite.org/)

## Instruções

1. Baixe os arquivos da pasta [download](download)
2. Abra o arquivo `restTest.bat` (Windows) ou execute 
`java -jar restTest.jar` no terminal.


Para utilizar a API, acesse a URL `localhost:8080/[recurso]`.
Use o método `get` para listar todos ou `post` para cadastrar.

Os recursos disponíveis são:

- **clientes** (100 registros)
- **produtos** (1 000 registros)
- **pedidos** (10 000 registros)
  
Para cada recurso, pode utilizar `/[id-do-objeto]` com os métodos:

- **get** (buscar)
- **put** (editar)
- **delete** (excluir)