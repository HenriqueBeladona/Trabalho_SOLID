package cardapio;

import excecoes.PrecoInvalidoException;

public abstract class ModeloCardapio {
    private String nome;
    private double precoBase;
    private int tempoPreparo;

    public ModeloCardapio(String nome, double precoBase, int tempoPreparo) throws PrecoInvalidoException {

        if (precoBase < 0) {
            throw new PrecoInvalidoException("Preço base negativo recusado!!");
        }

        this.nome = nome;
        this.precoBase = precoBase;
        this.tempoPreparo = tempoPreparo;
    }

    public abstract double calcularPreco();

    public String getNome() {
        return nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

}