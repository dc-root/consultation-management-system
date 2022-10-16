package main.models;

import java.util.ArrayList;
import java.util.Objects;

public class Paciente extends Pessoa {
    private String nomeConvenio;
    private int numeroConvenio;
    private ArrayList<Endereco> enderecos;

    public Paciente(
        String nome,
        String cpf,
        String identidade,
        String telefone,
        String nomeConvenio,
        int numeroConvenio,
        ArrayList<Endereco> enderecos
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

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> endereco) {
        this.enderecos = endereco;
    }

    @Override
    public String toString() {
        return "[ "+nome+", "+cpf+", "+identidade+", "+telefone+", "+nomeConvenio+", "+numeroConvenio+
        ", Endereços: "+
            (enderecos.size() == 2 ? "("+enderecos.get(0)+"), ("+enderecos.get(1)+")" : "("+enderecos.get(0))+")"+" ]";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;

        Paciente paciente = (Paciente) obj;
        return Objects.equals(cpf, paciente.cpf) && Objects.equals(identidade, paciente.identidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, identidade);
    }
}
