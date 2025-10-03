import java.util.Scanner;

class Filme {
    private String nome;
    private String genero;
    private int ano;
    private int duracao; // em minutos
    private double somaNotas;
    private int qtdAvaliacoes;

    // Construtor
    public Filme(String nome, String genero, int ano, int duracao) {
        this.nome = nome;
        this.genero = genero;
        this.ano = ano;
        this.duracao = duracao;
        this.somaNotas = 0;
        this.qtdAvaliacoes = 0;
    }

    // Exibir os detalhes do filme
    public void exibirDetalhes() {
        System.out.println("\n=== Detalhes do Filme ===");
        System.out.println("Nome: " + nome);
        System.out.println("Gênero: " + genero);
        System.out.println("Ano de Lançamento: " + ano);
        System.out.println("Duração: " + duracao + " minutos");
    }

    // Avaliar o filme com uma nota de 0 a 10
    public void avaliar(int nota) {
        if (nota >= 0 && nota <= 10) {
            somaNotas += nota;
            qtdAvaliacoes++;
            System.out.println("Avaliação registrada com sucesso!");
        } else {
            System.out.println("Nota inválida! Digite entre 0 e 10.");
        }
    }

    // Calcular a média das avaliações
    public double calcularMediaAvaliacoes() {
        if (qtdAvaliacoes == 0) {
            return 0.0;
        }
        return somaNotas / qtdAvaliacoes;
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Filme filme = null; // filme começa nulo (não cadastrado)
        int opcao;

        do {
            System.out.println("\n=== MENU STREAMING ===");
            System.out.println("1 - Cadastrar título");
            System.out.println("2 - Exibir detalhes do título");
            System.out.println("3 - Avaliar título");
            System.out.println("4 - Calcular média das avaliações");
            System.out.println("5 - Encerrar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do filme: ");
                    String nome = sc.nextLine();
                    System.out.print("Gênero: ");
                    String genero = sc.nextLine();
                    System.out.print("Ano de lançamento: ");
                    int ano = sc.nextInt();
                    System.out.print("Duração (minutos): ");
                    int duracao = sc.nextInt();
                    sc.nextLine(); // limpar buffer
                    filme = new Filme(nome, genero, ano, duracao);
                    System.out.println("Filme cadastrado com sucesso!");
                    break;

                case 2:
                    if (filme != null) {
                        filme.exibirDetalhes();
                    } else {
                        System.out.println("Nenhum filme cadastrado ainda.");
                    }
                    break;

                case 3:
                    if (filme != null) {
                        System.out.print("Digite sua nota (0 a 10): ");
                        int nota = sc.nextInt();
                        filme.avaliar(nota);
                    } else {
                        System.out.println("Cadastre um filme antes de avaliar.");
                    }
                    break;

                case 4:
                    if (filme != null) {
                        double media = filme.calcularMediaAvaliacoes();
                        if (media == 0.0) {
                            System.out.println("Ainda não há avaliações para este filme.");
                        } else {
                            System.out.println("Média das avaliações: " + media);
                        }
                    } else {
                        System.out.println("Cadastre um filme antes de calcular a média.");
                    }
                    break;

                case 5:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        sc.close();
    }
}
