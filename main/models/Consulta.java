package main.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Consulta {
    private Medico medico;
    private Paciente paciente;
    private LocalDate data;
    private LocalTime hora;
    private String codigo;

    DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Consulta(
        Medico medico,
        Paciente paciente
    ) {
        this.medico = medico;
        this.paciente = paciente;
        this.data = LocalDate.now();
        this.hora = LocalTime.now();
        this.codigo = data.format(DateTimeFormatter.ofPattern("ddMMyyyy"))+hora.format(DateTimeFormatter.ofPattern("HHmmss"))+"";
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

    public String getCodigo() {
        return codigo;
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
        return Objects.equals(codigo, consulta.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
