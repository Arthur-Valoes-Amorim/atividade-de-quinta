import java.util.Scanner;

class ContaBancaria {
    private int numeroConta;
    private String titular;
    private double saldo;

    // Construtor
    public ContaBancaria(int numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0; // saldo inicial zero
    }

    // Métodos
    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    public void transferir(ContaBancaria destino, double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            destino.saldo += valor;
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Criando duas contas para simular transferências
        ContaBancaria conta1 = new ContaBancaria(1, "João");
        ContaBancaria conta2 = new ContaBancaria(2, "Maria");

        int opcao;
        do {
            System.out.println("\n=== MENU BANCO ===");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    conta1.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor do depósito: ");
                    double dep = sc.nextDouble();
                    conta1.depositar(dep);
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: ");
                    double saque = sc.nextDouble();
                    conta1.sacar(saque);
                    break;
                case 4:
                    System.out.print("Digite o valor da transferência: ");
                    double transf = sc.nextDouble();
                    conta1.transferir(conta2, transf);
                    break;
                case 5:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 5);

        sc.close();
    }
}