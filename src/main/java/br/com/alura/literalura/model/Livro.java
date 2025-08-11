package br.com.alura.literalura.model;

public class Livro {

    private String titulo;
    private Autor autor;
    private Livro linguagem;
    private Integer quantidadeDownloads;

    public Livro(){}

    public Livro getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(Livro linguagem) {
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
