package com.southsystem.api.cadastro.service;

import com.southsystem.api.cadastro.dto.PessoaDTO;
import com.southsystem.api.cadastro.entity.Pessoa;
import com.southsystem.api.cadastro.repository.PessoaRepository;
import com.southsystem.api.cadastro.util.ConvertModelToDTO;
import com.southsystem.api.cadastro.util.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Random;

@Service
public class PessoaService extends ConvertModelToDTO {

    @Autowired
    private PessoaRepository pessoaRepository;

    private Mensagem mensagem;


    public ResponseEntity<Mensagem> inserir(PessoaDTO pessoaDTO) {
        try {
            Pessoa pessoa = super.toModel(pessoaDTO,Pessoa.class);
            Random random = new Random();
            pessoa.setScore(random.nextInt(9));
            pessoaRepository.save(pessoa);
            mensagem = new Mensagem("Pessoa Cadastrado com Sucesso!!", pessoa.getId(), "success", true);
            return new ResponseEntity<Mensagem>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            mensagem = new Mensagem("Erro ao Cadastrar!", pessoaDTO.getId(), "error", false);
            return new ResponseEntity<Mensagem>(mensagem, HttpStatus.OK);
        }
    }

    public ResponseEntity<Mensagem> alterar(PessoaDTO pessoaDTO) {
        try {
            Pessoa pessoa = pessoaRepository.save(super.toModel(pessoaDTO,Pessoa.class));
            mensagem = new Mensagem("Pessoa Alterado com Sucesso!!", pessoa.getId(), "success", true);
            return new ResponseEntity<Mensagem>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            mensagem = new Mensagem("Erro ao Tentar Alterar", null, "error", false);
            return new ResponseEntity<Mensagem>(mensagem, HttpStatus.OK);
        }
    }

    public ResponseEntity<Mensagem> excluir(Long id) {

        try {
            if (!pessoaRepository.exists(id)) {
                mensagem = new Mensagem("Pessoa não existente!", id, "warn", true);
                return new ResponseEntity<Mensagem>(mensagem, HttpStatus.OK);
            }
            pessoaRepository.delete(id);
            mensagem = new Mensagem("Pessoa Excluída com Sucesso!", id, "success", true);
            return new ResponseEntity<Mensagem>(mensagem, HttpStatus.OK);

        } catch (Exception e) {
            mensagem = new Mensagem("Erro ao tentar excluir", id, "error", false);
            return new ResponseEntity<Mensagem>(mensagem, HttpStatus.OK);
        }
    }

    public ResponseEntity<List<Pessoa>> listarTodos() {

        List<Pessoa> pessoas = pessoaRepository.findAll();
        if (ObjectUtils.isEmpty(pessoas)) {
            return new ResponseEntity<List<Pessoa>>(pessoas, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Pessoa>>(pessoas, HttpStatus.OK);

    }

    public ResponseEntity<Pessoa> listarPorId(Long id) {
        Pessoa retorna = pessoaRepository.findOne(id);
        if (ObjectUtils.isEmpty(retorna)) {
        }
        return new ResponseEntity<Pessoa>(retorna, HttpStatus.OK);
    }


}
