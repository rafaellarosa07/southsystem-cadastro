package com.southsystem.api.cadastro.repository;

import com.southsystem.api.cadastro.entity.Pessoa;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PessoaRepository  extends  JpaRepository<Pessoa, Long>{
}
