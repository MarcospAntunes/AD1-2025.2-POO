package src.model;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
  private int qntdProdutores;
  private List<Produtor> produtores;
  private int ID;

  public Equipe(int ID) { 
    this.produtores = new ArrayList<>(); 
    this.ID = ID;
  }

  public void setProdutores(Produtor produtor) { 
    produtores.add(produtor); 
    contarProdutores();
  }

  public List<Produtor> getProdutores() { return produtores; }
  public int getQntdProdutores() { return qntdProdutores; }

  private void contarProdutores() { qntdProdutores = produtores.size(); }
}
