package src.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import src.enums.TipoMedalha;

public class Cerimonia {
  private String nome;
  private LocalDate data;
  private Categoria categoria;
  private List<Filme> filmes;
  private int ID;

  public Cerimonia(int ID, String nome, LocalDate date, Categoria categoria){
    this.nome = nome;
    this.data = date;
    this.categoria = categoria;
    this.filmes = new ArrayList<>();
    this.ID = ID;
  }

  public void setFilme(Filme filme) { filmes.add(filme); }

  public int getTotalParticipantes() { return filmes.size(); }
  public Categoria getCategoria() { return categoria; }
  public LocalDate getData() { return data; }
  public List<Filme> getFilmes() { return filmes; }
  public String getNome() { return nome; }


  public void definirVencendor(int idFilme, TipoMedalha medalha) {
    switch(medalha) {
      case OURO:
        filmes.get(idFilme).ganharOuro();
        break;

      case PRATA:
        filmes.get(idFilme).ganharPrata();
        break;
      case BRONZE:
        filmes.get(idFilme).ganharBronze();
        break;
      
      default:
        System.out.println("Medalha indefinida ou incorreta!");
        break;
    }
    
  }
}
