package com.southsystem.api.cadastro.enums;

public enum TipoPessoaEnum {
    PJ("PJ"), PF("PF");


    String nome;

    TipoPessoaEnum(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    public static TipoPessoaEnum getByEnumString(String sigla) {
        for(TipoPessoaEnum  tipo : TipoPessoaEnum.values()) {
            if(tipo.toString().equals(sigla)) {
                return tipo;
            }
        }
        return null;
    }
}
