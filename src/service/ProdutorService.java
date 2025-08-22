package src.service;

import java.util.ArrayList;
import java.util.List;
import src.model.Produtor;

public class ProdutorService {
    private static int contador = 0;
    private final List<Produtor> produtores = new ArrayList<>();

    public Produtor cadastrarProdutor(String nome, int idade, String nacionalidade) {
        Produtor produtor = new Produtor(contador++, nome, idade, nacionalidade);
        produtores.add(produtor);
        return produtor;
    }

    public boolean removerProdutor(int ID) {
        return produtores.removeIf(produtor -> produtor.getID() == ID);
    }

    public List<Produtor> listarProdutores() {
        return new ArrayList<>(produtores);
    }

    public Produtor getProdutor(int ID) {
        for (Produtor p : produtores) {
            if (p.getID() == ID) {
                return p;
            }
        }
        return null;
    }
}
