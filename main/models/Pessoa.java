package main.models;

public abstract class Pessoa {
    protected String nome;
    protected String identidade;
    protected String cpf;
    protected String telefone;

    public Pessoa() {}
    public Pessoa(
        String nome,
        String identidade,
        String cpf,
        String telefone
    ) {
        this.nome = nome;
        this.identidade = identidade;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
