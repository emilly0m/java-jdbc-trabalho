public class Funcionario {
    private int codigo;
    private String nome;
    private String sobrenome;
    private int idade;
    private double salario;

    // Getters e Setters
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
}