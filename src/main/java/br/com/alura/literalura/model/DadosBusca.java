package br.com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosBusca(
        @JsonAlias("count") Integer contagem,
        @JsonAlias("result") List<DadosLivro> resultado
) {
}
