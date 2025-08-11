package br.com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record DadosBusca(
        @JsonAlias("count") Integer contagem,
        @JsonAlias("result") List<DadosLivro> resultado
) {
}
