package bancodigital;

import java.util.ArrayList;
import java.util.List;

public class Gerente {
    private int cpf;
    private String nome;
    private String cargo;
    private List<Cliente> clientes;

    public Gerente(int cpf, String nome, String cargo) {
        this.cpf = cpf;
        this.nome = nome;
        this.cargo = cargo;
        this.clientes = new ArrayList<>();
    }

    public Conta abrirConta(Cliente cliente, String tipoConta) {
        Conta novaConta = new Conta(cliente.getCpf(), tipoConta, cliente.getNome());
        cliente.adicionarConta(novaConta);
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
        return novaConta;
    }

    public int getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
