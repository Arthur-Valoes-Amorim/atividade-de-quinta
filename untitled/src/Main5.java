import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Classe Cliente
class Cliente {
    private String nome;
    private String cpf;
    private List<Pedido> pedidos; // um cliente pode ter vários pedidos

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void exibirPedidos() {
        System.out.println("\nPedidos do cliente " + nome + ":");
        for (Pedido p : pedidos) {
            p.exibirDetalhes();
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}

// Classe Vendedor
class Vendedor {
    private String nome;
    private String matricula;
    private List<Pedido> pedidosEmitidos; // um vendedor pode emitir vários pedidos

    public Vendedor(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.pedidosEmitidos = new ArrayList<>();
    }

    public Pedido emitirPedido(int numero, Date data, double valorTotal, Cliente cliente) {
        Pedido pedido = new Pedido(numero, data, valorTotal, cliente, this);
        pedidosEmitidos.add(pedido);
        cliente.adicionarPedido(pedido);
        return pedido;
    }

    public void exibirPedidosEmitidos() {
        System.out.println("\nPedidos emitidos pelo vendedor " + nome + ":");
        for (Pedido p : pedidosEmitidos) {
            p.exibirDetalhes();
        }
    }

    public String getNome() {
        return nome;
    }
}

// Classe Pedido
class Pedido {
    private int numero;
    private Date data;
    private double valorTotal;
    private Cliente cliente;
    private Vendedor vendedor;

    public Pedido(int numero, Date data, double valorTotal, Cliente cliente, Vendedor vendedor) {
        this.numero = numero;
        this.data = data;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public void exibirDetalhes() {
        System.out.println("Pedido Nº " + numero + " | Data: " + data +
                " | Valor: R$ " + valorTotal +
                " | Cliente: " + cliente.getNome() +
                " | Vendedor: " + vendedor.getNome());
    }
}

// Classe principal para testar
public class Main5 {
    public static void main(String[] args) {
        // Criando clientes
        Cliente cliente1 = new Cliente("João Silva", "123.456.789-00");
        Cliente cliente2 = new Cliente("Maria Souza", "987.654.321-00");

        // Criando vendedores
        Vendedor vendedor1 = new Vendedor("Carlos", "V001");
        Vendedor vendedor2 = new Vendedor("Fernanda", "V002");

        // Registrando pedidos
        vendedor1.emitirPedido(1, new Date(), 1500.00, cliente1);
        vendedor1.emitirPedido(2, new Date(), 200.00, cliente2);
        vendedor2.emitirPedido(3, new Date(), 350.00, cliente1);

        // Exibir pedidos
        cliente1.exibirPedidos();
        cliente2.exibirPedidos();

        vendedor1.exibirPedidosEmitidos();
        vendedor2.exibirPedidosEmitidos();
    }
}
