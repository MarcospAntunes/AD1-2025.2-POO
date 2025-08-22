package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import src.enums.TipoCategoria;
import src.model.Categoria;
import src.model.Cerimonia;
import src.model.Equipe;
import src.model.Filme;
import src.model.Produtor;
import src.service.CategoriaService;
import src.service.CerimoniaService;
import src.service.EquipeService;
import src.service.FilmeService;
import src.service.ProdutorService;

public class CineSystem {
  private final Scanner scanner = new Scanner(System.in);

  private final ProdutorService produtorService = new ProdutorService();
  private final EquipeService equipeService = new EquipeService();
  private final CategoriaService categoriaService = new CategoriaService();
  private final FilmeService filmeService = new FilmeService();
  private final CerimoniaService cerimoniaService = new CerimoniaService();

  private String option;

  public static void main(String[] args) {
    CineSystem app = new CineSystem();
    app.menu();
  }

  private void pausar() {
    try { Thread.sleep(700); } catch (InterruptedException e) { }
  }

  private void menu() {
    while (true) {
      System.out.println("\n----------Bem-vindo(a) ao CineSystem!----------\n");
      System.out.println("O que deseja fazer hoje?");
      System.out.println("1. Cadastrar produtores, equipes, categorias, filmes e cerimônias;");
      System.out.println("2. Adicionar prêmios aos filmes em cada cerimônia;");
      System.out.println("3. Adicionar produtor em uma equipe;");
      System.out.println("4. Verificar a pontuação de cada participante.");
      System.out.println("0. Sair");
      System.out.println("\n-----------------------------------------------\n");

      System.out.print("Digite a opção (0 a 4): ");
      option = scanner.nextLine().trim();

      switch(option) {
        case "1":
          cadastrar();
          break;
        case "2":
          adicionarPremiosEmCerimonia();
          break;
        case "3":
          adicionarProdutorEmEquipe();
          break;
        case "4":
          mostrarPontuacoes();
          break;
        case "0":
          System.out.println("Encerrando... até mais!");
          scanner.close();
          return;
        default:
          System.out.println("Opção inválida!");
          pausar();
      }
    }
  }

  private void cadastrar() {
    System.out.println("\nOk, o que deseja cadastrar?");
    System.out.println("1. Produtor");
    System.out.println("2. Equipe");
    System.out.println("3. Categoria");
    System.out.println("4. Filme");
    System.out.println("5. Cerimônia");
    System.out.print("\nDigite a opção (1 a 5): ");
    String op = scanner.nextLine().trim();

    switch (op) {
      case "1": cadastrarProdutor(); break;
      case "2": cadastrarEquipe(); break;
      case "3": cadastrarCategoria(); break;
      case "4": cadastrarFilme(); break;
      case "5": cadastrarCerimonia(); break;
      default: System.out.println("Opção inválida!");
    }
    pausar();
  }

  private void cadastrarProdutor() {
    System.out.println("\n-- Cadastro de Produtor --");
    System.out.print("Nome: ");
    String nome = scanner.nextLine();
    System.out.print("Idade: ");
    int idade = Integer.parseInt(scanner.nextLine().trim());
    System.out.print("Nacionalidade: ");
    String nac = scanner.nextLine();

    Produtor p = produtorService.cadastrarProdutor(nome, idade, nac);
    System.out.println("\nProdutor cadastrado com sucesso!\n" + p);
  }

  private void cadastrarEquipe() {
    System.out.println("\n-- Cadastro de Equipe --");
    System.out.print("Nome: ");
    String nome = scanner.nextLine();
    Equipe e = equipeService.cadastrarEquipe(nome);
    System.out.println("\nEquipe cadastrada com sucesso!\n" + e);
  }

  private void cadastrarCategoria() {
    try {
      System.out.println("\n-- Cadastro de Categoria --");
      System.out.print("Nome da categoria: ");
      String nome = scanner.nextLine();

      System.out.println("Tipo da categoria:");
      System.out.println("1. INDIVIDUAL");
      System.out.println("2. EQUIPE");
      System.out.print("Escolha (1/2): ");
      String escolha = scanner.nextLine().trim();

      TipoCategoria tipo;
      if (escolha.equals("1")) tipo = TipoCategoria.INDIVIDUAL;
      else if (escolha.equals("2")) tipo = TipoCategoria.EQUIPE;
      else throw new IllegalArgumentException("Tipo de categoria incorreto!");

      Categoria c = categoriaService.cadastrarCategoria(nome, tipo);
      System.out.println("\nCategoria cadastrada com sucesso!\n" + c);
    } catch (IllegalArgumentException e) {
      System.err.println("Erro: " + e.getMessage());
    }
  }

  private void cadastrarFilme() {
    try {
      System.out.println("\n-- Cadastro de Filme --");
      System.out.print("Título: ");
      String nome = scanner.nextLine();

      System.out.println("Digite os gêneros (um por linha). Linha vazia para terminar:");
      List<String> genero = new ArrayList<>();
      while (true) {
        String g = scanner.nextLine().trim();
        if (g.isEmpty()) break;
        genero.add(g);
      }

      Filme filme = filmeService.cadastrarFilme(nome, genero);
      System.out.println("\nFilme cadastrado com sucesso!\n" + filme);
    } catch (IllegalArgumentException e) {
      System.err.println("Erro: " + e.getMessage());
    }
  }

  private void cadastrarCerimonia() {
    System.out.println("\n-- Cadastro de Cerimônia --");
    System.out.print("Nome da cerimônia: ");
    String nome = scanner.nextLine();


    listarCategorias();
    System.out.print("Digite o ID da Categoria: ");
    int id = Integer.parseInt(scanner.nextLine().trim());
    Categoria categoria = categoriaService.getCategoria(id);

    Cerimonia cerimonia = cerimoniaService.cadastrarCerimonia(nome, LocalDate.now(), categoria);
    System.out.println("\nCerimônia cadastrada com sucesso!\n" + cerimonia);
  }


  private void adicionarPremiosEmCerimonia() {
    if (cerimoniaService.listarCerimonia().isEmpty()) {
      System.out.println("Não há cerimônias cadastradas.");
      return;
    }
    System.out.println("\n-- Adicionar prêmios em cerimônia --");
    listarCerimonias();
    System.out.print("Informe o ID da cerimônia: ");
    int idCer = Integer.parseInt(scanner.nextLine().trim());
    Cerimonia cer = cerimoniaService.getCerimonia(idCer);
    if (cer == null) {
      System.out.println("Cerimônia não encontrada.");
      return;
    }

    if (cer.getFilmes().isEmpty()) {
      System.out.println("\nA cerimônia ainda não tem participantes.");
      System.out.println("Adicione filmes participantes (IDs). Linha vazia para terminar.");
      listarFilmes();

      while (true) {
        System.out.print("ID do filme (vazio para encerrar): ");
        String line = scanner.nextLine().trim();
        if (line.isEmpty()) break;
        int idFilme = Integer.parseInt(line);
        Filme f = filmeService.getFilme(idFilme);
        if (f == null) {
          System.out.println("Filme não encontrado.");
          continue;
        }

        if (cer.getCategoria().getTipo() == TipoCategoria.INDIVIDUAL) {
          listarProdutores();
          System.out.print("Informe o ID do produtor responsável pelo filme: ");
          int idProd = Integer.parseInt(scanner.nextLine().trim());
          Produtor prod = produtorService.getProdutor(idProd);
          if (prod == null) { System.out.println("Produtor não encontrado."); continue; }
          f.setProdutor(prod);
        } else {
          listarEquipes();
          System.out.print("Informe o ID da equipe responsável pelo filme: ");
          int idEq = Integer.parseInt(scanner.nextLine().trim());
          Equipe eq = equipeService.getEquipe(idEq);
          if (eq == null) { System.out.println("Equipe não encontrada."); continue; }
          f.setEquipe(eq);
        }

        cerimoniaService.adicionarFilme(cer, f);
        System.out.println("Filme adicionado como participante.");
      }
    }

    if (cer.getFilmes().isEmpty()) {
      System.out.println("Nenhum participante definido. Abortando.");
      return;
    }

    System.out.println("\nParticipantes da cerimônia:");
    for (Filme f : cer.getFilmes()) {
      System.out.println("ID: " + f.getID() + " | " + f.getTitulo());
    }

    System.out.println("\nRegistre os vencedores (1=OURO, 2=PRATA, 3=BRONZE). Deixe vazio para pular.");
    for (int pos = 1; pos <= 3; pos++) {
      System.out.print("Informe o ID do filme para posição " + pos + ": ");
      String line = scanner.nextLine().trim();
      if (line.isEmpty()) continue;
      int idFilme = Integer.parseInt(line);
      Filme f = cer.getFilmes().stream().filter(x -> x.getID() == idFilme).findFirst().orElse(null);
      if (f == null) {
        System.out.println("Filme não está como participante desta cerimônia.");
        pos--;
        continue;
      }
      cer.registrarPremio(f, pos);
      System.out.println("Prêmio registrado.");
    }
    System.out.println("\nPrêmios registrados com sucesso!");
  }

  private void adicionarProdutorEmEquipe() {
    if (equipeService.listarEquipes().isEmpty()) {
      System.out.println("Não há equipes cadastradas.");
      return;
    }
    if (produtorService.listarProdutores().isEmpty()) {
      System.out.println("Não há produtores cadastrados.");
      return;
    }

    System.out.println("\n-- Adicionar produtor em equipe --");
    listarEquipes();
    System.out.print("ID da equipe: ");
    int idEq = Integer.parseInt(scanner.nextLine().trim());
    Equipe equipe = equipeService.getEquipe(idEq);
    if (equipe == null) {
      System.out.println("Equipe não encontrada.");
      return;
    }

    listarProdutores();
    System.out.println("Informe IDs de produtores para adicionar. Linha vazia para terminar.");
    while (true) {
      System.out.print("ID do produtor: ");
      String line = scanner.nextLine().trim();
      if (line.isEmpty()) break;
      int idProd = Integer.parseInt(line);
      Produtor p = produtorService.getProdutor(idProd);
      if (p == null) {
        System.out.println("Produtor não encontrado.");
        continue;
      }
      equipeService.adicionarProdutor(equipe, p);
      System.out.println("Produtor adicionado à equipe.");
    }
    System.out.println("\nEquipe atualizada:\n" + equipe);
  }

  private void mostrarPontuacoes() {
    System.out.println("\n-- Pontuação dos Filmes --");
    for (Filme f : filmeService.listarFilmes()) {
      System.out.println("Filme: " + f.getTitulo() + " | Pontos: " + f.getPontos());
    }

    System.out.println("\n-- Pontuação das Equipes (soma dos filmes da equipe) --");
    Map<Integer, Integer> pontosPorEquipe = new HashMap<>();
    for (Filme f : filmeService.listarFilmes()) {
      if (f.getEquipe() != null) {
        int id = f.getEquipe().getID();
        pontosPorEquipe.put(id, pontosPorEquipe.getOrDefault(id, 0) + f.getPontos());
      }
    }
    if (pontosPorEquipe.isEmpty()) {
      System.out.println("Nenhuma equipe com pontuação ainda.");
    } else {
      for (Map.Entry<Integer, Integer> e : pontosPorEquipe.entrySet()) {
        Equipe eq = equipeService.getEquipe(e.getKey());
        System.out.println("Equipe: " + (eq != null ? eq.getNome() : ("#" + e.getKey())) + " | Pontos: " + e.getValue());
      }
    }
  }

  private void listarFilmes() {
    System.out.println("\nFilmes cadastrados:");
    for (Filme f : filmeService.listarFilmes()) {
      System.out.println("ID: " + f.getID() + " | " + f.getTitulo());
    }
  }

  private void listarProdutores() {
    System.out.println("\nProdutores cadastrados:");
    for (Produtor p : produtorService.listarProdutores()) {
      System.out.println("ID: " + p.getID() + " | " + p.getNome());
    }
  }

  private void listarEquipes() {
    System.out.println("\nEquipes cadastradas:");
    for (Equipe e : equipeService.listarEquipes()) {
      System.out.println("ID: " + e.getID() + " | " + e.getNome());
    }
  }

  private void listarCategorias() {
    System.out.println("\nCategorias cadastradas:");
    for (Categoria c : categoriaService.listarCategorias()) {
      System.out.println("ID: " + c.getID() + " | " + c.getNome() + " | " + c.getTipo());
    }
  }

  private void listarCerimonias() {
    System.out.println("\nCerimônias cadastradas:");
    for (Cerimonia c : cerimoniaService.listarCerimonia()) {
      System.out.println("ID: " + c.getID() + " | " + c.getNome() + " | " + c.getCategoria().getTipo() + " | Participantes: " + c.getTotalParticipantes());
    }
  }
}
