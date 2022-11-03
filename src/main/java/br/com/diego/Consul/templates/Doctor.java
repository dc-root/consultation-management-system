package br.com.diego.Consul.templates;

import lombok.*;
import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true, callSuper=false)
@Table(name="medicos", uniqueConstraints={@UniqueConstraint(columnNames={"cpf", "identidade", "crm", "ctps"})})
@Entity
public class Doctor extends Person {
    @Column(length=20, nullable=false)
    private String especialidade;

    @Id
    @Column(length=6, nullable=false)
    @EqualsAndHashCode.Include
    private String crm;

    @Column(length=11, nullable=false)
    @EqualsAndHashCode.Include
    private int ctps;

    public Doctor() {}
    public Doctor(
        String nome,
        String especialidade,
        String crm,
        int ctps
    ) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
        this.ctps = ctps;
    }
}
