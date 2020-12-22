package com.southsystem.api.cadastro.controller;

import com.southsystem.api.cadastro.dto.PessoaDTO;
import com.southsystem.api.cadastro.entity.Pessoa;
import com.southsystem.api.cadastro.service.PessoaService;
import com.southsystem.api.cadastro.util.Mensagem;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Inserir Pessoa", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Registro inserido com sucesso."),
			@ApiResponse(code = 400, message = "Dados incorretos"),
			@ApiResponse(code = 500, message = "Erro interno servidor") })
	public ResponseEntity<Mensagem> inserirPessoa(@Valid @RequestBody PessoaDTO pessoaDTO) throws IOException {
		return pessoaService.inserir(pessoaDTO);
	}

	@PutMapping(value = "/pessoa", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Alterar Pessoa", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Execução realizada com sucesso"),
			@ApiResponse(code = 500, message = "Erro interno servidor") })
	public ResponseEntity<Mensagem>  alterarPessoa(@RequestBody PessoaDTO pessoa) throws IOException {
		return pessoaService.alterar(pessoa);

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Pessoa", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Execução realizada com sucesso"),
			@ApiResponse(code = 500, message = "Erro interno servidor") })
	public ResponseEntity<List<Pessoa>> listarPessoa() {
		return pessoaService.listarTodos();
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retorna Pessoa por Id", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "Identificador único da Pessoa que será consultado.", required = true, dataType = "Integer", paramType = "path") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Execução realizada com sucesso"),
			@ApiResponse(code = 500, message = "Erro interno servidor") })
	public ResponseEntity<Pessoa> buscaPessoaoById(@PathVariable Long id) {
		return pessoaService.listarPorId(id);
	}

	@DeleteMapping(value = "/{id:\\d+}")
	@ApiOperation(value = "Excluir Pessoa", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "Identificador único da Pessoa que será excluída.", required = true, dataType = "Integer", paramType = "path") })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Execução realizada com sucesso"),
			@ApiResponse(code = 500, message = "Erro interno servidor") })
	public ResponseEntity<Mensagem>  excluirPessoa(@PathVariable Long id) throws IOException {
		return pessoaService.excluir(id);

	}
}
