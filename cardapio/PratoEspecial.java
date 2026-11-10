package cardapio;

import excecoes.PrecoInvalidoException;

public class PratoEspecial extends ModeloCardapio {
    private double custoIngredientePremium;

    public PratoEspecial(String nome, double precoBase, int tempoPreparo, double custoIngredientePremium) throws PrecoInvalidoException {
        super(nome, precoBase, tempoPreparo);

        this.custoIngredientePremium = custoIngredientePremium;
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase() + custoIngredientePremium;
    }
}