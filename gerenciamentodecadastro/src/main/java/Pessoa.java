
public class Pessoa {
    private String nomePessoa;
    private int idadePessoa;
    private String cpfPessoa;
    
    public Pessoa(String nome,int idade, String cpf){
        this.nomePessoa=nome;
        this.idadePessoa=idade;
        this.cpfPessoa=cpf;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public int getIdadePessoa() {
        return idadePessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public void setIdadePessoa(int idadePessoa) {
        this.idadePessoa = idadePessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }
    
    
    
}
