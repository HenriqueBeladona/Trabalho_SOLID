package relatorio;

import controle.ControleDosPedidos;
import modelo.Pedido;

public class Fechamento {
    private ControleDosPedidos controle;
    private Saida saida;

    public Fechamento(ControleDosPedidos controle, Saida saida) {
        this.controle = controle;
        this.saida = saida;
    }

    public void fechar() {
        StringBuilder sb = new StringBuilder("----- FECHAMENTO DO DIA -----\n");
        double faturamento = 0;
        Pedido maisCaro = null;

        for (Pedido p : controle.listar()) {
            sb.append(String.format("Cliente: %s | Data: %s | Pratos: %d | Total: R$ %.2f%n", p.getCliente().getNome(), p.getData(), p.getPratos().size(), p.getTotal()));

            faturamento += p.getTotal();

            if (maisCaro == null || p.getTotal() > maisCaro.getTotal()) {
                maisCaro = p;
            }
        }

        sb.append(String.format("Faturamento total: R$ %.2f%n", faturamento));

        if (maisCaro != null) {
            sb.append(String.format("Pedido mais caro: %s (R$ %.2f)", maisCaro.getCliente().getNome(), maisCaro.getTotal()));
        }

        saida.escrever(sb.toString());
    }
}