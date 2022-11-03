package br.com.diego.Consul.templates;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true, callSuper=false)
@Table(name="pacientes", uniqueConstraints={@UniqueConstraint(columnNames={"identidade", "cpf"})})
@Entity
public class Patient extends Person {
    @Column(length=50, nullable=false, name="nome_convenio")
    private String nomeConvenio;

    @Id
    @Column(length=13, nullable=false, name="numero_convenio")
    private int numeroConvenio;

    @OneToMany
    private List<Address> enderecos;

    public Patient() {}
    public Patient(
        String nome,
        String cpf,
        String identidade,
        String telefone,
        String nomeConvenio,
        int numeroConvenio,
        List<Address> enderecos
    ) {
        this.nome = nome;
        this.cpf = cpf;
        this.identidade = identidade;
        this.telefone = telefone;
        this.nomeConvenio = nomeConvenio;
        this.numeroConvenio = numeroConvenio;
        this.enderecos = enderecos;
    }
}
