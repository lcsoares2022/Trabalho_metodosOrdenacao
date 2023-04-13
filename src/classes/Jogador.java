package classes;
import java.util.Scanner;

public class Jogador {
    public Scanner scanner = new Scanner(System.in);
    private int id;
    private int altura;
    private int peso;
    private int anoNascimento;
    private String nome;
    private String universidade;
    private String cidadeNascimento;
    private String estadoNascimento;

    public Jogador() {
        id = 0;
        altura = 0;
        peso = 0;
        anoNascimento = 0;
        universidade = "nao informado";
        cidadeNascimento = "nao informado";
        estadoNascimento = "nao informado";
    }

    public Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento,
                   String cidadeNascimento, String estadoNascimento) {
        this.id = id;
        this.altura = altura;
        this.peso = peso;
        this.anoNascimento = anoNascimento;
        this.nome = nome;
        this.universidade = universidade;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }

    public Jogador clone() {
        return new Jogador(this.id, this.nome, this.altura, this.peso, this.universidade, this.anoNascimento,
                this.cidadeNascimento, this.estadoNascimento);
    }

    public void imprimir() {
        System.out.printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", this.getId(), this.getNome(),
                this.getAltura(), this.getPeso(), this.getAnoNascimento(), this.getUniversidade(),
                this.getCidadeNascimento(), this.getEstadoNascimento());
    }

    public void ler() {
        System.out.println("Digite o nome do jogador: ");
        nome = scanner.nextLine();
        System.out.print("Digite o ID: ");
        id = scanner.nextInt();
        System.out.print("Digite a altura: ");
        altura = scanner.nextInt();
        System.out.println("Digite o peso: ");
        peso = scanner.nextInt();
        System.out.println("Digite o ano de nascimento: ");
        anoNascimento = scanner.nextInt();
        System.out.println("Digite a universidade: ");
        universidade = scanner.nextLine();
        System.out.println("Digite a cidade de nascimento: ");
        cidadeNascimento = scanner.nextLine();
        System.out.println("Digite o estado de nascimento: ");
        estadoNascimento = scanner.nextLine();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    public String getEstadoNascimento() {
        return estadoNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

}