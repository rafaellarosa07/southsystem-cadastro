package com.southsystem.api.cadastro.entity;

import com.southsystem.api.cadastro.enums.TipoPessoaEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Long id;

    @Column(name = "TP_PESSOA")
    private TipoPessoaEnum tipoPessoa;

    @Column(name = "NRO_DOC")
    private Long numeroDocumento;

    @Column(name = "SCORE")
    private Integer score;



}