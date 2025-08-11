package br.com.alura.literalura.repository;

import br.com.alura.literalura.model.Idioma;
import br.com.alura.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIdioma(Idioma idioma);

    Optional<Livro> findByTitulo(String titulo);

    @Query("SELECT l from livro l ORDER BY l.quantidadeDownloads DESC LIMIT 10")
    List<Livro> top10LivrosMaisBaixados();
}
