package br.com.alura.literalura.model;

public enum Idioma {
    en("[en]", "Ingles"),
    es("[pt]", "Portugues");

    private String idiomaGutendex;
    private String idiomaPortugues;

    Idioma(String idiomaGutendex, String idiomaPortugues){
        this.idiomaGutendex = idiomaGutendex;
        this.idiomaPortugues = idiomaPortugues;
    }

    public static Idioma fromString(String text){
        for(Idioma idioma : Idioma.values()){
            if (idioma.idiomaGutendex.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Nenhum idioma encontrado para a String fornecida: " + text);
    }

    public static Idioma fromPortugues(String text){
        for(Idioma idioma : Idioma.values()) {
            if(idioma.idiomaPortugues.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada paraa String fornecida: " + text);
    }
}
