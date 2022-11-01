package br.com.diego.consultationmanagmentsystem.templates;

import lombok.*;
import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true, callSuper=false)
@MappedSuperclass
public abstract class Person {
    @Column(length=50, nullable=false)
    protected String nome;

    @EqualsAndHashCode.Include
    @Column(length=8, nullable=false)
    protected String identidade;

    @Id
    @EqualsAndHashCode.Include
    @Column(length=11, nullable=false)
    protected String cpf;

    @Column(length=13)
    protected String telefone;

    public Person() {}
    public Person (
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
}
