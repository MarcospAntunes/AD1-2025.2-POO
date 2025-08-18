package src.service;

import java.util.ArrayList;
import java.util.List;
import src.model.Equipe;
import src.model.Produtor;

public class EquipeService {
  private static int contador = 0;
  private List<Equipe> equipes;
  private List<Produtor> produtores = new ArrayList<>();

 public Equipe cadastrarEquipe(String nome) {
  List<Produtor> novaListaProdutores = new ArrayList<>();
  Equipe equipe = new Equipe(contador++, nome, novaListaProdutores);
  equipes.add(equipe);
  return equipe;
  }

  public boolean removerEquipe(int ID) { return equipes.removeIf(equipe -> equipe.getID() == ID); }
  public List<Equipe> listarEquipes() { return new ArrayList<>(equipes); }
  public void adicionarProdutor(Equipe equipe, Produtor produtor) { equipe.getProdutores().add(produtor); }
  public List<Produtor> getProdutores() { return produtores; }
}
