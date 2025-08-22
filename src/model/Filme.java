package src.model;

import java.util.List;

public class Filme {
  private List<String> genero;
  private String titulo;
  private Medalhas medalhas;
  private int ID;
  private Equipe equipe;
  private Produtor produtor;

  public Filme(int ID, String titulo, List<String> genero) {
    this.titulo = titulo;
    this.genero = genero;
    this.medalhas = new Medalhas();
    this.ID = ID;
  }

  public void ganharOuro() { medalhas.ganharOuro(); }
  public void ganharPrata() { medalhas.ganharPrata(); }
  public void ganharBronze() { medalhas.ganharBronze(); }

  public String getTitulo() { return titulo; }
  public List<String> getGenero() { return genero; }
  public Medalhas getMedalhas() { return medalhas; }
  public int getID() { return ID; }
  public Equipe getEquipe() { return equipe; }
  public Produtor getProdutor() { return produtor; }

  public void setEquipe(Equipe equipe) { this.equipe = equipe; }
  public void setProdutor(Produtor produtor) { this.produtor = produtor; }

  public int getPontos() { return medalhas.getPontos(); }

  @Override
  public String toString() {
    return  "\nIdentificador: " + ID + ";" +
            "\nNome do filme: " + titulo + ";" +
            "\nEquipe: " + (equipe != null ? equipe.getNome() : "Nenhuma") + ";" +
            "\nProdutor: " + (produtor != null ? produtor.getNome() : "Nenhum") + ";" +
            "\nMedalhas: " + medalhas + ".";
  }
}
