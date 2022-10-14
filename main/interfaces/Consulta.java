package main.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
    private Medico medico;
    private Paciente paciente;
    private LocalDate data;
    private LocalTime hora;

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
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }
}
