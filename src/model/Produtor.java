package src.model;

public class Produtor {
  private String nome;
  private int idade;
  private String nacionalidade;
  private int ID;

  public Produtor(int ID, String nome, int idade, String nacionalidade) {
    this.idade = idade;
    this.nacionalidade = nacionalidade;
    this.nome = nome;
    this.ID = ID;
  }

  public int getIdade() { return idade; }
  public String getNacionalidade() { return nacionalidade; }
  public String getNome() { return nome; }
  public int getID() { return ID; }

  @Override
  public String toString() {
    return  "\nIdentificador: " + ID + ";" +
            "\nNome: " + nome + ";" +
            "\nIdade: " + idade + ";" +
            "\nNacionalidade: " + nacionalidade + ".";
  }

}
