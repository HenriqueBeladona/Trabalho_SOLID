package modelo;

import cardapio.ModeloCardapio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Cliente cliente;
    private LocalDate data;
    private List<ModeloCardapio> pratos = new ArrayList<>();

    public Pedido(Cliente cliente, LocalDate data) {

        if (cliente == null) {
            throw new IllegalArgumentException("Pedido sem cliente não pode existir.");
        }
        this.cliente = cliente;
        this.data = data;
    }

    public void adicionarPrato(ModeloCardapio prato) {
        pratos.add(prato);
    }

    public double getTotal() {
        double total = 0;

        for (ModeloCardapio prato : pratos) {
            total += prato.calcularPreco();
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public List<ModeloCardapio> getPratos() {
        return pratos;
    }
}