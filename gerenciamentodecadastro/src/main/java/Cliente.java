
public class Cliente extends Pessoa{
    private String telefone;
    private String endereco;
    
    public Cliente(String nome, int idade, String cpf, String telefone, String endereco){
        super(nome,idade,cpf);
        this.telefone=telefone;
        this.endereco=endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "nome='" + getNomePessoa() + '\'' + // Acessa os atributos herdados através dos getters
               ", idade=" + getIdadePessoa() +
               ", cpf='" + getCpfPessoa() + '\'' +
               ", telefone='" + telefone + '\'' +
               ", endereco=" + endereco +
               '}';
    }
    
}
