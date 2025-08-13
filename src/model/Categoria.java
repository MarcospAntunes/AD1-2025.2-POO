package src.model;
import src.enums.TipoCategoria;

public class Categoria {
  private String nome;
  private TipoCategoria tipo;
  private int ID;

  public Categoria(int ID, String nome, TipoCategoria tipo) {
    this.tipo = tipo;
    this.nome = nome;
    this.ID = ID;
  }

  public String getNome() { return nome; }
  public TipoCategoria getTipo() { return tipo; }
}
