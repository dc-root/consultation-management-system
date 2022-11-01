package br.com.diego.consultationmanagmentsystem.templates;

import lombok.*;
import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Table(name="consultas")
@Entity
public class Query {
    @OneToOne
    @JoinColumn(nullable=false)
    private Doctor medico;

    @OneToOne
    @JoinColumn(nullable=false)
    private Patient paciente;

    @Column(length=10, name="data_consulta")
    private LocalDate data;

    @Column(length=8, name="hora_consulta")
    private LocalTime hora;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private String codigo;

    public Query(
        Doctor medico,
        Patient paciente
    ) {
        this.medico = medico;
        this.paciente = paciente;
        this.data = LocalDate.now();
        this.hora = LocalTime.now();
    }
}