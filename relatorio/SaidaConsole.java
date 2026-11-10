package relatorio;

public class SaidaConsole implements Saida {

    @Override
    public void escrever(String texto) {
        System.out.println(texto);
    }
}