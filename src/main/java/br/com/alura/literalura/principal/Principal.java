package br.com.alura.literalura.principal;

import br.com.alura.literalura.model.DadosBusca;
import br.com.alura.literalura.model.DadosLivro;
import br.com.alura.literalura.model.Livro;
import br.com.alura.literalura.service.ConsumoAPI;
import br.com.alura.literalura.service.ConverteDados;

import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String ENDERECO = "https://gutendex.com/books/?search=";
    private ConverteDados conversor = new ConverteDados();

    public void menu(){
        var opcao = -1;
        while(opcao != 0){
            System.out.println("*******************\n");
            var menu = """
                    1 - Buscar Livros
                    2 - 
                    3 - 
                    
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
                    break;
                case 3:
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


        }
    }
}
