package main.interfaces;

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

    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected String getCpf() {
        return cpf;
    }

    protected void setCpf(String cpf) {
        this.cpf = cpf;
    }

    protected String getIdentidade() {
        return identidade;
    }

    protected void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    protected String getTelefone() {
        return telefone;
    }

    protected void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
