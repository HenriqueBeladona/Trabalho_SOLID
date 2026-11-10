package cardapio;

import excecoes.PrecoInvalidoException;

public class PratoExecutivo extends ModeloCardapio {

    public PratoExecutivo(String nome, double precoBase, int tempoPreparo) throws PrecoInvalidoException {
        super(nome, precoBase, tempoPreparo);
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase();
    }
}