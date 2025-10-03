// Classe base
class Medico {
    protected String nome;
    protected String crm;

    // Construtor
    public Medico(String nome, String crm) {
        this.nome = nome;
        this.crm = crm;
    }

    // Método comum
    public void exibirInfo() {
        System.out.println("Médico: " + nome + " | CRM: " + crm);
    }
}

// Subclasse Clínico Geral
class ClinicoGeral extends Medico {

    public ClinicoGeral(String nome, String crm) {
        super(nome, crm);
    }

    // Método específico
    public void atenderPaciente() {
        System.out.println(nome + " está atendendo um paciente como Clínico Geral.");
    }
}

// Subclasse Cirurgião
class Cirurgiao extends Medico {

    public Cirurgiao(String nome, String crm) {
        super(nome, crm);
    }

    // Método específico
    public void realizarCirurgia() {
        System.out.println(nome + " está realizando uma cirurgia.");
    }
}

// Classe principal para teste
public class Main4 {
    public static void main(String[] args) {
        // Criando objetos
        ClinicoGeral clinico = new ClinicoGeral("Dra. Ana", "12345-SP");
        Cirurgiao cirurgiao = new Cirurgiao("Dr. Carlos", "67890-RJ");

        // Exibindo informações
        clinico.exibirInfo();
        clinico.atenderPaciente();

        System.out.println();

        cirurgiao.exibirInfo();
        cirurgiao.realizarCirurgia();
    }
}
