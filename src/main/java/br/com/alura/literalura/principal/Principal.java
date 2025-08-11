package br.com.alura.literalura.principal;

import br.com.alura.literalura.service.ConsumoAPI;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String ENDERECo = "https://gutendex.com/books/?search=";

    public void menu(){
        var opcao = -1;
        while(opcao != 0){
            System.out.println("*******************\n");
            var menu = """
                    1 - 
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
}
