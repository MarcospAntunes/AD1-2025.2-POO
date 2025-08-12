package src.model;

public class Filme {
  private String[] genero;
  private String titulo;
  private Medalhas medalhas;

  public Filme(String titulo, String[] genero) {
    this.titulo = titulo;
    this.genero = genero;
    this.medalhas = new Medalhas();
  }

  public void ganharOuro() { medalhas.ganharOuro(); }
  public void ganharPrata() { medalhas.ganharPrata(); }
  public void ganharBronze() { medalhas.ganharBronze(); }

  public String getTitulo() { return titulo; }
  public String[] getGenero() { return genero; }
  public Medalhas getMedalhas() { return medalhas; }

}
