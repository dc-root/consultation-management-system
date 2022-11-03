package br.com.diego.Consul.templates;

import lombok.*;
import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Entity
public abstract class Address {
    @Column(length=50)
    protected String logradouro;

    @Column(length=12)
    protected int numero;

    @Column(length=30)
    protected String complemento;

    @Column(length=30)
    protected String bairro;

    @Column(length=30)
    protected String municipio;

    @Id
    @Column(length=8)
    @EqualsAndHashCode.Include
    protected String cep;

    @Column
    protected Boolean tipo;

    public Address() {}
    public Address(
        String logradouro,
        int numero,
        String complemento,
        String bairro,
        String municipio,
        String cep,
        Boolean tipo
    ) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.municipio = municipio;
        this.cep = cep;
        this.tipo = tipo;
    }
}
