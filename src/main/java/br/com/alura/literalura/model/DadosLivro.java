package br.com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record DadosLivro(
        @JsonAlias("id") Integer id,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DadosAutor> autor,
        @JsonAlias("download_count") Integer quantidadeDownloads
) {
}
