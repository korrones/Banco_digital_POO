package bancodigital;

import java.time.LocalDate;
import java.util.Map;

public class Transacao {
    private LocalDate data;
    private double valor;
    private String tipoTransacao;
    private int contaOrigem;
    private int contaDestino;

    public Transacao(double valor, String tipoTransacao, int contaOrigem, int contaDestino) {
        this.data = LocalDate.now();
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

    public boolean validarTransacao() {
        return valor > 0;
    }

    public void executarTransacao(Map<Integer, Conta> contas) {
        if (validarTransacao()) {
            Conta origem = contas.get(contaOrigem);
            Conta destino = contas.get(contaDestino);
            if (origem != null && destino != null) {
                origem.transferir(valor, destino);
            } else {
                System.out.println("Contas de origem ou destino não encontradas!");
            }
        } else {
            System.out.println("Transação inválida!");
        }
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "data=" + data +
                ", valor=" + valor +
                ", tipoTransacao='" + tipoTransacao + '\'' +
                ", contaOrigem=" + contaOrigem +
                ", contaDestino=" + contaDestino +
                '}';
    }
}
