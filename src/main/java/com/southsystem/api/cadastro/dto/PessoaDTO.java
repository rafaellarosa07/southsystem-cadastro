package com.southsystem.api.cadastro.dto;

import lombok.Data;

@Data
public class PessoaDTO{

    private Long id;
    private Integer tipoPessoa;
    private Long numeroDocumento;
    private Integer score;
}