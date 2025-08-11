package br.com.alura.literalura.model;

public class Autor {

    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;

    public Autor(){}

    @Override
    public String toString() {
        return "Nome= " + nome + '\'' +
                ", Ano de Nascimento= " + anoNascimento +
                ", Ano de falecimento= " + anoFalecimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }
}
