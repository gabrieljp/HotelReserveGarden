package hotelreservegarden;

public class Funcionario {
    private String nome;
    private String telefone;
    private String login;
    private String senha;

    public Funcionario(String nome, String telefone, String login, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
    }//Método Construtor

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
