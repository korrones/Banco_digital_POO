package bancodigital;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int cpf;
    private String nome;
    private String tipoConta;
    private String endereco;
    private int telefone;
    private List<Conta> contas;

    public Cliente(int cpf, String nome, String tipoConta, String endereco, int telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.tipoConta = tipoConta;
        this.endereco = endereco;
        this.telefone = telefone;
        this.contas = new ArrayList<>();
    }

    public int getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> consultarContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", tipoConta='" + tipoConta + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone=" + telefone +
                '}';
    }
}
