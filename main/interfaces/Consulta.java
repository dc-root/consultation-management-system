package main.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Consulta {
    private Medico medico;
    private Paciente paciente;
    private LocalDate data;
    private LocalTime hora;

    DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("hhs:mm:ss");

    public Consulta(
        Medico medico,
        Paciente paciente,
        LocalDate data,
        LocalTime hora
    ) {
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
        this.hora = hora;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "[ medico: "+medico.getNome()+", paciente: "+paciente.getNome()+", data: "+data.format(formatadorData)+", hora: "+hora.format(formatadorHora)+"]";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;

        Consulta consulta = (Consulta) obj;

        return Objects.equals(hora.format(formatadorHora), consulta.hora.format(formatadorHora));
    }

    @Override
    public int hashCode() {
        return Objects.hash(hora.format(formatadorHora));
    }
}
