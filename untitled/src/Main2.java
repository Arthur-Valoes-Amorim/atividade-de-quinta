public class Main2 {
    private String matricula;
    private String nome;
    private double salarioBruto;

    // Construtor
    public Main2(String matricula, String nome, double salarioBruto) {
        this.matricula = matricula;
        this.nome = nome;
        this.salarioBruto = salarioBruto;
    }

    // Método para calcular o INSS
    public double calcularInss() {
        return salarioBruto * 0.15;
    }

    // Método para calcular o salário líquido
    public double calcularSalarioLiquido() {
        return salarioBruto - calcularInss();
    }

    // Método para exibir o contracheque
    public void exibirContracheque() {
        System.out.println("----- CONTRACHEQUE -----");
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nome: " + nome);
        System.out.printf("Salário Bruto: R$ %.2f%n", salarioBruto);
        System.out.printf("Desconto INSS (15%%): R$ %.2f%n", calcularInss());
        System.out.printf("Salário Líquido: R$ %.2f%n", calcularSalarioLiquido());
        System.out.println("------------------------");
    }
}
