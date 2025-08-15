package src.service;

import java.util.ArrayList;
import java.util.List;
import src.model.Equipe;
import src.model.Produtor;

public class EquipeService {
  private static int contador = 0;
  private List<Equipe> equipes = new ArrayList<>();
  private int qntdProdutores;
  private List<Produtor> produtores = new ArrayList<>();

  public Equipe cadastrarEquipe(String nome) {
    Equipe equipe = new Equipe(contador++, nome, produtores);
    equipes.add(equipe);

    return equipe;
  }

  public boolean removerEquipe(int ID) { return equipes.removeIf(equipe -> equipe.getID() == ID); }
  public List<Equipe> listarEquipes() { return new ArrayList<>(equipes); }
  private void contarProdutores() { qntdProdutores = produtores.size(); }
  public List<Produtor> getProdutores() { return produtores; }

  public void adicionarProdutores(Produtor produtor) { 
    produtores.add(produtor); 
    contarProdutores();
  }
}
