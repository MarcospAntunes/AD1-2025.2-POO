package src.model;

public class Filme {
  private String[] genero;
  private String titulo;
  private Medalhas medalhas;
  private int ID;

  public Filme(int ID, String titulo, String[] genero) {
    this.titulo = titulo;
    this.genero = genero;
    this.medalhas = new Medalhas();
    this.ID = ID;
  }

  public void ganharOuro() { medalhas.ganharOuro(); }
  public void ganharPrata() { medalhas.ganharPrata(); }
  public void ganharBronze() { medalhas.ganharBronze(); }

  public String getTitulo() { return titulo; }
  public String[] getGenero() { return genero; }
  public Medalhas getMedalhas() { return medalhas; }

}
