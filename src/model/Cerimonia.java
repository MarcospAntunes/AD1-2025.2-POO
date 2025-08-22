package src.model;

import java.time.LocalDate;
import java.util.List;

public class Cerimonia {
  private String nome;
  private LocalDate data;
  private Categoria categoria;
  private List<Filme> filmes;
  private int ID;

  public Cerimonia(int ID, String nome, LocalDate date, Categoria categoria, List<Filme> filmes){
    this.nome = nome;
    this.data = date;
    this.categoria = categoria;
    this.filmes = filmes;
    this.ID = ID;
  }

  public void setFilme(Filme filme) { filmes.add(filme); }

  public int getTotalParticipantes() { return filmes.size(); }
  public Categoria getCategoria() { return categoria; }
  public LocalDate getData() { return data; }
  public List<Filme> getFilmes() { return filmes; }
  public String getNome() { return nome; }
  public int getID() { return ID; }

  public void registrarPremio(Filme filme, int posicao) {
  if (!filmes.contains(filme)) {
    throw new IllegalArgumentException("Filme não participa desta cerimônia.");
  }
  switch(posicao) {
    case 1:
      filme.ganharOuro();
      break;
    case 2:
      filme.ganharPrata();
      break;
    case 3:
      filme.ganharBronze();
      break;
    default:
      throw new IllegalArgumentException("Posição inválida (1=Ouro, 2=Prata, 3=Bronze)");
  }
}
}
