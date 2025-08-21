package src.service;

import java.util.ArrayList;
import java.util.List;

import src.enums.TipoCategoria;
import src.model.Categoria;

public class CategoriaService {
  private static int contador = 0;
  private List<Categoria> categorias;

 public Categoria cadastrarCategoria(String nome, TipoCategoria tipo) {
  Categoria categoria = new Categoria(contador++, nome, tipo);
  categorias.add(categoria);
  return categoria;
  }

  public boolean removerCategoria(int ID) { return categorias.removeIf(categoria -> categoria.getID() == ID); }
  public List<Categoria> listarCategorias() { return new ArrayList<>(categorias); }
  public Categoria getCategoria(int ID) {
    return categorias.get(ID);
  }
}
