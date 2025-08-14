package src.service;

import java.util.ArrayList;
import java.util.List;
import src.model.Equipe;

public class EquipeService {
  private static int contador = 0;
  private List<Equipe> equipes = new ArrayList<>();

  public Equipe cadastrarEquipe(String nome) {
    Equipe equipe = new Equipe(contador++, nome);
    equipes.add(equipe);

    return equipe;
  }

  public boolean removerEquipe(int ID) { return equipes.removeIf(equipe -> equipe.getID() == ID); }
  public List<Equipe> listarEquipes() { return new ArrayList<>(equipes); }

}
