package src;
import java.util.Scanner;

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
    System.out.println("3. Verificar a pontuação de cada participante;");
    System.out.println("\n-----------------------------------------------\n");

    System.out.print("Digite a opção (1, 2 ou 3): ");
    option = scanner.nextLine();

    switch(option) {
      case "1":
        System.out.println("1");
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
