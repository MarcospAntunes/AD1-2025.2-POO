package src.model;
import src.enums.TipoCategoria;

public class Categoria {
  private String nome;
  private TipoCategoria tipo;

  public Categoria(String nome, TipoCategoria tipo) {
    this.tipo = tipo;
    this.nome = nome;
  }

  public String getNome() { return nome; }
  public TipoCategoria getTipo() { return tipo; }
}
