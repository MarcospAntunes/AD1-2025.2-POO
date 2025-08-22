package src.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import src.model.Categoria;
import src.model.Cerimonia;
import src.model.Filme;

public class CerimoniaService {
  private static int contador = 0;
  private final List<Cerimonia> cerimonias = new ArrayList<>();

  public Cerimonia cadastrarCerimonia(String nome, LocalDate date, Categoria categoria) {
    List<Filme> novaListaFilmes = new ArrayList<>();
    Cerimonia cerimonia = new Cerimonia(contador++, nome, date, categoria, novaListaFilmes);
    cerimonias.add(cerimonia);
    return cerimonia;
  }

  public boolean removerCerimonia(int ID) { return cerimonias.removeIf(cerimonia -> cerimonia.getID() == ID); }
  public List<Cerimonia> listarCerimonia() { return new ArrayList<>(cerimonias); }
  public void adicionarFilme(Cerimonia cerimonia, Filme filme) { cerimonia.setFilme(filme); }

  public Cerimonia getCerimonia(int ID) {
    for (Cerimonia c : cerimonias) if (c.getID() == ID) return c;
    return null;
  }
}
