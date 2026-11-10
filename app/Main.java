package app;

import cardapio.*;
import modelo.*;
import controle.ControleDosPedidos;
import excecoes.PrecoInvalidoException;
import relatorio.Fechamento;
import relatorio.SaidaConsole;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ControleDosPedidos controle = new ControleDosPedidos();

        Cliente ana = new Cliente("Ana", "Rua A", "5587-7485");
        Cliente henrique = new Cliente("Henrique", "Rua B", "4874-8785");

        try {
            Pedido p1 = new Pedido(ana, LocalDate.now());
            p1.adicionarPrato(new PratoExecutivo("Frango", 30.0, 20));
            p1.adicionarPrato(new Combo("Combo hambúrguer", 40.0, 15));
            controle.adicionar(p1);

            Pedido p2 = new Pedido(henrique, LocalDate.now());
            p2.adicionarPrato(new PratoEspecial("Filé", 55.0, 30, 25.0));
            p2.adicionarPrato(new PratoExecutivo("Arroz e feijão", 18.0, 10));
            controle.adicionar(p2);

            new PratoExecutivo("Prato inválido", -18.0, 14);

        } catch (PrecoInvalidoException e) {
            System.out.println("Erro tratado: " + e.getMessage());
        }

        new Fechamento(controle, new SaidaConsole()).fechar();
    }
}