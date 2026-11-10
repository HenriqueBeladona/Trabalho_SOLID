package cardapio;

import excecoes.PrecoInvalidoException;

public class Combo extends ModeloCardapio {

    public Combo(String nome, double precoBase, int tempoPreparo) throws PrecoInvalidoException {
        super(nome, precoBase, tempoPreparo);
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase() * (0.85);
    }
}