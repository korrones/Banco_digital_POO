package bancodigital;

public class Conta {
    private int numeroConta;
    private double saldo;
    private String tipoConta;
    private String titular;

    public Conta(int numeroConta, String tipoConta, String titular) {
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido!");
        }
    }

    public void transferir(double valor, Conta contaDestino) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            contaDestino.depositar(valor);
        } else {
            System.out.println("Saldo insuficiente ou valor de transferência inválido!");
        }
    }

    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public int hashCode() {
        return numeroConta;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numeroConta=" + numeroConta +
                ", saldo=" + saldo +
                ", tipoConta='" + tipoConta + '\'' +
                ", titular='" + titular + '\'' +
                '}';
    }
}
