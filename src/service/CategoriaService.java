package src.service;

import java.util.ArrayList;
import java.util.List;

import src.enums.TipoCategoria;
import src.model.Categoria;

public class CategoriaService {
  private static int contador = 0;
  private final List<Categoria> categorias = new ArrayList<>();

  public Categoria cadastrarCategoria(String nome, TipoCategoria tipo) {
    Categoria categoria = new Categoria(contador++, nome, tipo);
    this.categorias.add(categoria);
    return categoria;
  }

  public boolean removerCategoria(int ID) { return categorias.removeIf(categoria -> categoria.getID() == ID); }
  public List<Categoria> listarCategorias() { return new ArrayList<>(categorias); }

  public Categoria getCategoria(int ID) {
    for (Categoria c : categorias) if (c.getID() == ID) return c;
    return null;
  }
}
