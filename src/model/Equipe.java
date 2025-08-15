package src.model;

import java.util.List;

public class Equipe {
  private String nome;
  private int ID;
  private List<Produtor> produtores;

  public Equipe(int ID, String nome, List<Produtor> produtores) { 
    this.ID = ID;
    this.nome = nome;
    this.produtores = produtores;
  }
 
  public int getID() { return ID; }

  @Override
  public String toString() {
    return  "\nIdentificador: " + ID + ";" +
            "\nNome da Equipe: " + nome + ";" +
            "\nProdutores na equipe: " + produtores.size() + ".";
  }
}
