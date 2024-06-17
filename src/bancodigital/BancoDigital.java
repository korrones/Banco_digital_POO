package bancodigital;

import java.util.*;

public class BancoDigital {
    private static Map<Integer, Cliente> clientes = new HashMap<>();
    private static Map<Integer, Conta> contas = new HashMap<>();
    private static List<Gerente> gerentes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Adicionar Cliente");
            System.out.println("2. Adicionar Gerente");
            System.out.println("3. Abrir Conta");
            System.out.println("4. Depositar");
            System.out.println("5. Sacar");
            System.out.println("6. Transferir");
            System.out.println("7. Consultar Saldo");
            System.out.println("8. Listar Clientes");
            System.out.println("9. Listar Contas");
            System.out.println("10. Listar Gerentes");
            System.out.println("11. Sair");
            System.out.print("Selecione a opção desejada: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarCliente(scanner);
                    break;
                case 2:
                    adicionarGerente(scanner);
                    break;
                case 3:
                    abrirConta(scanner);
                    break;
                case 4:
                    depositar(scanner);
                    break;
                case 5:
                    sacar(scanner);
                    break;
                case 6:
                    transferir(scanner);
                    break;
                case 7:
                    consultarSaldo(scanner);
                    break;
                case 8:
                    listarClientes();
                    break;
                case 9:
                    listarContas();
                    break;
                case 10:
                    listarGerentes();
                    break;
                case 11:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void adicionarCliente(Scanner scanner) {
        System.out.print("CPF: ");
        int cpfCliente = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        System.out.print("Nome: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Tipo de Conta: ");
        String tipoContaCliente = scanner.nextLine();
        System.out.print("Endereço: ");
        String enderecoCliente = scanner.nextLine();
        System.out.print("Telefone: ");
        int telefoneCliente = scanner.nextInt();
        Cliente cliente = new Cliente(cpfCliente, nomeCliente, tipoContaCliente, enderecoCliente, telefoneCliente);
        clientes.put(cpfCliente, cliente);
        System.out.println("Cliente adicionado com sucesso!");
    }

    private static void adicionarGerente(Scanner scanner) {
        System.out.print("CPF: ");
        int cpfGerente = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        System.out.print("Nome: ");
        String nomeGerente = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargoGerente = scanner.nextLine();
        Gerente gerente = new Gerente(cpfGerente, nomeGerente, cargoGerente);
        gerentes.add(gerente);
        System.out.println("Gerente adicionado com sucesso!");
    }

    private static void abrirConta(Scanner scanner) {
        if (clientes.isEmpty() || gerentes.isEmpty()) {
            System.out.println("É necessário ter pelo menos um cliente e um gerente cadastrados para abrir uma conta.");
            return;
        }
        System.out.println("Clientes Disponíveis:");
        List<Cliente> listaClientes = new ArrayList<>(clientes.values());
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println((i + 1) + ". " + listaClientes.get(i).getNome());
        }
        System.out.print("Selecione o cliente pelo número: ");
        int clienteIndex = scanner.nextInt() - 1;
        Cliente clienteConta = listaClientes.get(clienteIndex);

        System.out.println("Gerentes Disponíveis:");
        for (int i = 0; i < gerentes.size(); i++) {
            System.out.println((i + 1) + ". " + gerentes.get(i).getNome());
        }
        System.out.print("Selecione o gerente pelo número: ");
        int gerenteIndex = scanner.nextInt() - 1;
        Gerente gerenteConta = gerentes.get(gerenteIndex);

        scanner.nextLine(); // Consumir nova linha
        System.out.print("Tipo de Conta: ");
        String tipoConta = scanner.nextLine();

        Conta novaConta = gerenteConta.abrirConta(clienteConta, tipoConta);
        contas.put(novaConta.hashCode(), novaConta);
        System.out.println("Conta aberta com sucesso!");
    }

    private static void depositar(Scanner scanner) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }
        System.out.println("Contas Disponíveis:");
        List<Conta> listaContas = new ArrayList<>(contas.values());
        for (int i = 0; i < listaContas.size(); i++) {
            System.out.println((i + 1) + ". " + listaContas.get(i));
        }
        System.out.print("Selecione a conta pelo número: ");
        int contaIndex = scanner.nextInt() - 1;
        Conta contaDeposito = listaContas.get(contaIndex);

        System.out.print("Valor do Depósito: ");
        double valorDeposito = scanner.nextDouble();
        contaDeposito.depositar(valorDeposito);
        System.out.println("Depósito realizado com sucesso! Saldo atual: " + contaDeposito.consultarSaldo());
    }

    private static void sacar(Scanner scanner) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }
        System.out.println("Contas Disponíveis:");
        List<Conta> listaContas = new ArrayList<>(contas.values());
        for (int i = 0; i < listaContas.size(); i++) {
            System.out.println((i + 1) + ". " + listaContas.get(i));
        }
        System.out.print("Selecione a conta pelo número: ");
        int contaIndex = scanner.nextInt() - 1;
        Conta contaSaque = listaContas.get(contaIndex);

        System.out.print("Valor do Saque: ");
        double valorSaque = scanner.nextDouble();
        contaSaque.sacar(valorSaque);
        System.out.println("Saque realizado com sucesso! Saldo atual: " + contaSaque.consultarSaldo());
    }

    private static void transferir(Scanner scanner) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }
        System.out.println("Contas Disponíveis:");
        List<Conta> listaContas = new ArrayList<>(contas.values());
        for (int i = 0; i < listaContas.size(); i++) {
            System.out.println((i + 1) + ". " + listaContas.get(i));
        }
        System.out.print("Selecione a conta de origem pelo número: ");
        int contaOrigemIndex = scanner.nextInt() - 1;
        Conta contaOrigem = listaContas.get(contaOrigemIndex);

        System.out.print("Selecione a conta de destino pelo número: ");
        int contaDestinoIndex = scanner.nextInt() - 1;
        Conta contaDestino = listaContas.get(contaDestinoIndex);

        System.out.print("Valor da Transferência: ");
        double valorTransferencia = scanner.nextDouble();
        Transacao transacao = new Transacao(valorTransferencia, "Transferência", contaOrigem.hashCode(), contaDestino.hashCode());
        transacao.executarTransacao(contas);
        System.out.println("Transferência realizada com sucesso!");
    }

    private static void consultarSaldo(Scanner scanner) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }
        System.out.println("Contas Disponíveis:");
        List<Conta> listaContas = new ArrayList<>(contas.values());
        for (int i = 0; i < listaContas.size(); i++) {
            System.out.println((i + 1) + ". " + listaContas.get(i));
        }
        System.out.print("Selecione a conta pelo número: ");
        int contaIndex = scanner.nextInt() - 1;
        Conta contaConsulta = listaContas.get(contaIndex);

        System.out.println("Saldo: " + contaConsulta.consultarSaldo());
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Clientes cadastrados:");
            for (Cliente cliente : clientes.values()) {
                System.out.println(cliente);
            }
        }
    }

    private static void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            System.out.println("Contas cadastradas:");
            for (Conta conta : contas.values()) {
                System.out.println(conta);
            }
        }
    }

    private static void listarGerentes() {
        if (gerentes.isEmpty()) {
            System.out.println("Nenhum gerente cadastrado.");
        } else {
            System.out.println("Gerentes cadastrados:");
            for (Gerente gerente : gerentes) {
                System.out.println(gerente);
            }
        }
    }
}
