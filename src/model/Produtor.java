package src.model;

public class Produtor {
  private String nome;
  private int idade;
  private String nacionalidade;

  public Produtor(String nome, int idade, String nacionalidade) {
    this.idade = idade;
    this.nacionalidade = nacionalidade;
    this.nome = nome;
  }

  public int getIdade() { return idade; }
  public String getNacionalidade() { return nacionalidade; }
  public String getNome() { return nome; }
}
