package main.interfaces;

public class Paciente extends Pessoa {
    private String nomeConvenio;
    private int numeroConvenio;
    private Endereco[] enderecos = new Endereco[2];

    public Paciente(
        String nome,
        String cpf,
        String identidade,
        String telefone,
        String nomeConvenio,
        int numeroConvenio,
        Endereco[] enderecos
    ) {
        this.nome = nome;
        this.cpf = cpf;
        this.identidade = identidade;
        this.telefone = telefone;
        this.nomeConvenio = nomeConvenio;
        this.numeroConvenio = numeroConvenio;
        this.enderecos = enderecos;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public int getNumeroConvenio() {
        return numeroConvenio;
    }

    public void setNumeroConvenio(int numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] endereco) {
        this.enderecos = endereco;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
}
