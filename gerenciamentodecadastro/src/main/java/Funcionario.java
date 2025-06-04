public class Funcionario extends Pessoa {
    private String funcao;
    private double salario;

    public Funcionario(String nome, int idade, String cpf, String funcao, double salario) {
        // Chama o construtor da classe pai (Pessoa) para inicializar os atributos herdados
        super(nome, idade, cpf);
        this.funcao = funcao;
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome='" + getNomePessoa() + '\'' + // Acessa os atributos herdados através dos getters
               ", idade=" + getIdadePessoa() +
               ", cpf='" + getCpfPessoa() + '\'' +
               ", funcao='" + funcao + '\'' +
               ", salario=" + salario +
               '}';
    }
}