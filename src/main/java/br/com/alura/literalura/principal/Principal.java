package br.com.alura.literalura.principal;

import br.com.alura.literalura.model.*;
import br.com.alura.literalura.repository.AutorRepository;
import br.com.alura.literalura.repository.LivroRepository;
import br.com.alura.literalura.service.ConsumoAPI;
import br.com.alura.literalura.service.ConverteDados;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String ENDERECO = "https://gutendex.com/books/?search=";
    private ConverteDados conversor = new ConverteDados();
    private LivroRepository repositorioLivro;
    private AutorRepository repositorioAutor;
    private List<Autor> autores;
    private List<Livro> livros;

    public Principal(AutorRepository repositorioAutor, LivroRepository repositorioLivro) {
    }

    public void menu(){
        var opcao = -1;
        while(opcao != 0){
            System.out.println("*******************\n");
            var menu = """
                    1 - Buscar Livros
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em determinado ano
                    0 - Sair
                    """;

            System.out.println(menu);
            while (!leitura.hasNextInt()){
                System.out.println("Opção inválida! Digite uma opção disponível no menu.");
                leitura.nextLine();
            }
            opcao = leitura.nextInt();
            leitura.nextLine();
            switch(opcao){
                case 1:
                    buscarLivro();
                    break;
                case 2:
                    mostrarLivros();
                    break;
                case 3:
                    mostrarAutores();
                    break;
                case 4:
                    mostrarAutoresPorAno();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.printf("Opção inválida\n");
            }
        }
    }

    private DadosBusca getBusca(){
        System.out.println("Digite o nome do livro: ");
        var nomeLivro = leitura.nextLine();
        var json = consumoAPI.obterDados(ENDERECO + nomeLivro.replace(" ", "+"));
        DadosBusca dados = conversor.obterDados(json, DadosBusca.class);
        return dados;
    }

    private void buscarLivro(){
        DadosBusca dadosBusca = getBusca();
        if (dadosBusca != null && !dadosBusca.resultado().isEmpty()) {
            DadosLivro dadosLivro = dadosBusca.resultado().get(0);

            Livro livro = new Livro(dadosLivro);
            System.out.println("***************");
            System.out.println("Livro: " + livro);
            System.out.println("***************");

            Optional<Livro> livroExiste = repositorioLivro.findByTitulo(livro.getTitulo());
            if (livroExiste.isPresent()){
                System.out.println("O livro buscado já está registrado!");
            } else {
                if (!dadosLivro.autor().isEmpty()){
                    DadosAutor dadosAutor = dadosLivro.autor().get(0);
                    Autor autor = new Autor(dadosAutor);
                    Optional<Autor> autorOptional = repositorioAutor.findByNome(autor.getNome());

                    if(autorOptional.isPresent()){
                        Autor autorExiste = autorOptional.get();
                        livro.setAutor(autorExiste);
                        repositorioLivro.save(livro);
                    } else {
                        Autor autorNovo = repositorioAutor.save(autor);
                        livro.setAutor(autorNovo);
                        repositorioLivro.save(livro);
                    }
                    Integer quantidadeDownloads = livro.getQuantidadeDownloads() != null ? livro.getQuantidadeDownloads() : 0;
                    System.out.println("****** Livro ******");
                    System.out.printf("Titulo: %s%nAutor: %s%nIdioma: %s%nQuantidade de Downloads: %s%n",
                            livro.getTitulo(), autor.getNome(), livro.getLinguagem(), livro.getQuantidadeDownloads());
                    System.out.println("*******************");
                }else{
                    System.out.println("Sem autor");
                }
            }
        }else{
            System.out.println("Livro não encontrado");
        }
    }

    private void mostrarLivros(){
        livros = repositorioLivro.findAll();
        livros.stream()
                .forEach(System.out::println);
    }

    private void mostrarAutores(){
        autores = repositorioAutor.findAll();
        autores.stream()
                .forEach(System.out::println);
    }

    private void mostrarAutoresPorAno(){
        System.out.println("Digite o ano do autor que deseja buscar: ");
        var ano = leitura.nextInt();
        autores = repositorioAutor.listAutorsAliveByYear(ano);
        autores.stream()
                .forEach(System.out::println);
    }

    
}
