package src.service;

import java.util.ArrayList;
import java.util.List;

import src.model.Filme;
import src.model.Equipe;

public class FilmeService {
  private static int contador = 0;
  private final List<Filme> filmes = new ArrayList<>();

  public Filme cadastrarFilme(String nome, List<String> genero) {
    Filme filme = new Filme(contador++, nome, genero);
    filmes.add(filme);
    return filme;
  }

  public boolean removerEquipe(int ID) { return filmes.removeIf(filme -> filme.getID() == ID); }
  public List<Filme> listarFilmes() { return new ArrayList<>(filmes); }
  public void adicionarEquipe(Filme filme, Equipe equipe) { filme.setEquipe(equipe); }

  public Filme getFilme(int ID) {
    for (Filme f : filmes) if (f.getID() == ID) return f;
    return null;
  }
}
