package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.enums.TipoCategoria;
import src.model.Categoria;
import src.model.Equipe;
import src.model.Produtor;
import src.model.Filme;
import src.service.CategoriaService;
import src.service.EquipeService;
import src.service.FilmeService;
import src.service.ProdutorService;

public class CineSystem {
  private String option;
  private Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    CineSystem app = new CineSystem();

    app.menu();
  }

  private void menu() {
    System.out.println("\n----------Bem-vindo(a) ao CineSystem!----------\n");
    System.out.println("O que deseja fazer hoje?");
    System.out.println("1. Cadastrar produtores, equipes, categorias, filmes e cerimônias;");
    System.out.println("2. Adicionar prêmios aos filmes em cada cerimônia;");
    System.out.println("3. Adicionar produtor em uma equipe;");
    System.out.println("4. Verificar a pontuação de cada participante.");
    System.out.println("\n-----------------------------------------------\n");

    System.out.print("Digite a opção (1, 2 ou 3): ");
    option = scanner.nextLine();

    switch(option) {
      case "1":
        System.out.println("\nOk, quais dos três gostaria de cadastrar?");
        System.out.println("1. Produtor;");
        System.out.println("2. Equipe;");
        System.out.println("3. Categoria;");
        System.out.println("4. Filme;");
        System.out.println("5. Cerimônia.");

        System.out.print("\nDigite a opção (1, 2 ou 3): ");
        option = scanner.nextLine();

        if(option.equals("1")) {
          String nome;
          int idade;
          String nacionalidade;

          System.out.println("\nOk, vamos cadastrar o produtor.");
          
          System.out.println("Digite o NOME do produtor: ");
          nome = scanner.nextLine();

          System.out.println("Digite a IDADE do produtor: ");
          idade = scanner.nextInt();
          scanner.nextLine();

          System.out.println("Digite a NACIONALIDADE do produtor: ");
          nacionalidade = scanner.nextLine();

          Produtor produtor = new ProdutorService().cadastrarProdutor(nome, idade, nacionalidade);
          System.out.println("\nProdutor cadastrado com sucesso!\n" + produtor);

          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
            System.err.print("Atenção, erro castratófico.");
            menu();
          }

          menu();

        } else if(option.equals("2")) {
          String nome;

          System.out.println("\nOk, vamos cadastrar a equipe.");
          
          System.out.println("Digite o NOME da equipe: ");
          nome = scanner.nextLine();

          Equipe equipe = new EquipeService().cadastrarEquipe(nome);
          System.out.println("\nEquipe cadastrada com sucesso!\n" + equipe);

          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
            System.err.print("Atenção, erro castratófico.");
            menu();
          }

          menu();
        } else if (option == "3") {
          try {
            String nome;
            TipoCategoria tipoCategoria;
            System.out.println("\nOk, vamos cadastrar a categoria.");
            
            System.out.println("Digite o NOME da categoria: ");
            nome = scanner.nextLine();

            System.out.println("Escolha o TIPO da categoria: ");
            System.out.print("1. INDIVIDUAL");
            System.out.print("2. EQUIPE");
            if(scanner.nextLine() == "1") {
              tipoCategoria = TipoCategoria.INDIVIDUAL;
            } else if(scanner.nextLine() == "2") {
              tipoCategoria = TipoCategoria.EQUIPE;
            } else {
              throw new IllegalArgumentException("Tipo de categoria incorreto!");
            }

            Categoria categoria = new CategoriaService().cadastrarCategoria(nome, tipoCategoria);
            System.out.println("\nCategoria cadastrada com sucesso!\n" + categoria);

            try {
              Thread.sleep(1000);
            } catch (InterruptedException e) {
              e.printStackTrace();
              System.err.print("Atenção, erro castratófico.");
              menu();
            }
          } catch (IllegalArgumentException e) {
            System.err.println(e);
            menu();
          }
        } else if (option == "4") {
          try {
            String nome;
            List<String> genero = new ArrayList<String>();
            System.out.println("\nOk, vamos cadastrar o filme.");
            
            System.out.println("Digite o NOME da filme: ");
            nome = scanner.nextLine();

            System.out.println("Digite o GÊNERO do filme: ");
            while (scanner.nextLine().trim() != "") {
              genero.add(scanner.nextLine());
            }

            Filme filme = new FilmeService().cadastrarFilme(nome, genero);
            System.out.println("\nFilme cadastrado com sucesso!\n" + filme);

            try {
              Thread.sleep(1000);
            } catch (InterruptedException e) {
              e.printStackTrace();
              System.err.print("Atenção, erro castratófico.");
              menu();
            }
          } catch (IllegalArgumentException e) {
            System.err.println(e);
            menu();
          }
        } else if(option == "5") {
          //
        }

        break;
      case "2":
      System.out.println("2");
        break;

      case "3":
      System.out.println("3");
        break;

      default:
        System.out.println("Opção " + option + " " + "não encontrada!");
        scanner.close();
        break;
    }
  }
  
}
