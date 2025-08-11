package br.com.alura.literalura.model;


import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Idioma linguagem;
    private Integer quantidadeDownloads;

    public Livro(){}

    public Livro(DadosLivro dadosLivro){
        this.titulo = dadosLivro.titulo();
        this.linguagem = Idioma.fromString(dadosLivro.idiomas().toString().split(",")[0].trim());
        this.quantidadeDownloads = dadosLivro.quantidadeDownloads();
    }

    @Override
    public String toString() {
        String nomeAutor = (autor != null) ? autor.getNome() : "Autor Desconhecido";
        return String.format("*** Livro ***%nTitulo: " +
                " %s%nAutor: %s%nIdioma: %s%nQuantidade de Downloads: " +
                " %d%n****************%n", titulo, nomeAutor, linguagem, quantidadeDownloads);
    }

    public Idioma getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(Idioma linguagem) {
        this.linguagem = linguagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Integer getQuantidadeDownloads() {
        return quantidadeDownloads;
    }

    public void setQuantidadeDownloads(Integer quantidadeDownloads) {
        this.quantidadeDownloads = quantidadeDownloads;
    }
}
