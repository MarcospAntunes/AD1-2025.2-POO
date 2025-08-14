package src.model;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
  private String nome;
  private int qntdProdutores;
  private List<Produtor> produtores;
  private int ID;

  public Equipe(int ID, String nome) { 
    this.produtores = new ArrayList<>(); 
    this.ID = ID;
    this.nome = nome;
  }

  public void setProdutores(Produtor produtor) { 
    produtores.add(produtor); 
    contarProdutores();
  }

  public List<Produtor> getProdutores() { return produtores; }
  public int getQntdProdutores() { return qntdProdutores; }
  public int getID() { return ID; }

  private void contarProdutores() { qntdProdutores = produtores.size(); }

  @Override
  public String toString() {
    return  "\nIdentificador: " + ID + ";" +
            "\nIdade: " + nome + ";" +
            "\nProdutores na equipe: " + getQntdProdutores() + ".";
  }
}
